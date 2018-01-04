package main;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {

	//生成
	public void generator() throws Exception {
		//错误信息
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		//配置文件
		File configFile = new File("generatorConfig.xml");
		//配置文件解析器
		ConfigurationParser cp = new ConfigurationParser(warnings);
		//解析获得配置
		Configuration config = cp.parseConfiguration(configFile);
		//壳方法支持
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
				callback, warnings);
		//生成
		myBatisGenerator.generate(null);

	}

	public static void main(String[] args) throws Exception {
		try {
			//初步生成dao,实体
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
			System.out.println("dao,entity ok了");
			
			//ContinueGenerate.continueGenerate();
			//System.out.println("service,controller ok了");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}