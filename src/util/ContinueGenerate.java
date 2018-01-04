package util;



import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.FreeMakerUtil;
import util.StringUtil;


public class ContinueGenerate {

	//generate_mybatis生成的实体类的路径
	private static String entityPath="D:\\WorkSpace\\MyEclipse2014_workSpace\\mybatisAuto2\\src\\org\\java\\entity";
	//指定生成service,controller的模板路径
	private static String ftlPath="/ftl1_mysql_for_mybatis";
	
	//输出路径
	private static String[] generateTargetPath=null;
	static{
		generateTargetPath=new String[]{
			"D:\\WorkSpace\\MyEclipse2014_workSpace\\mybatisAuto2\\src\\org\\java\\service\\",
			"D:\\WorkSpace\\MyEclipse2014_workSpace\\mybatisAuto2\\src\\org\\java\\service\\impl\\",
			"D:\\WorkSpace\\MyEclipse2014_workSpace\\mybatisAuto2\\src\\org\\java\\controller\\"	
		};
		for (int i = 0; i < generateTargetPath.length; i++) {
			File file=new File(generateTargetPath[i]);
			if (!file.exists()) {
				file.mkdirs();
			}
		}
	}
	
	//生成service接口的模板,包名,类后缀
	private static String[] serviceTemp={
		"service.ftl",
		"org.java.service",
		"Service"
	};
	//生成serviceImpl接口实现的模板,包名,类后缀
	private static String[] serviceImplTemp={
		"serviceImpl.ftl",
		"org.java.service.impl",
		"ServiceImpl"
	};
	//生成controller控制类的模板,包名,类后缀
	private static String[] controllerTemp={
		"controller.ftl",
		"org.java.controller",
		"Controller"
	};
	
	private static FreeMakerUtil freeMakerUtil = new FreeMakerUtil();
	
	/**
	 * 
	 * @param templateName 模版名称
	 * @param packageName 包名
	 * @param entity 实体类名
	 * @param outFileFullPath 文件名(全路径)
	 */
	public static void create(String templateName,
			String packageName, String entity, String outFileFullPath) {
		
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("package", packageName);
		templateData.put("entity", entity);
		templateData.put("lowerentity", entity.substring(0,1).toLowerCase()+entity.substring(1));
		freeMakerUtil.generateFile(ftlPath, templateName, templateData, outFileFullPath);
	}
	
	//基于已经生成的实体类继续生成service,serviceImpl,和controller
	public static void continueGenerate() {
		List<String> models=StringUtil.getDirectoryClassNameListString(entityPath);
		for (String entity : models) {
			create(serviceTemp[0], serviceTemp[1], entity,generateTargetPath[0]+entity+serviceTemp[2]+".java");
			create(serviceImplTemp[0], serviceImplTemp[1], entity,generateTargetPath[1]+entity+serviceImplTemp[2]+".java");
			create(controllerTemp[0], controllerTemp[1], entity,generateTargetPath[2]+entity+controllerTemp[2]+".java");
		}
	}
	
}
