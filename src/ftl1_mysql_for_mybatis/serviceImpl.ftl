package ${package};

import java.util.List;

import javax.annotation.Resource;

import org.java.dao.${entity}Mapper;
import org.java.entity.${entity};
import org.java.entity.${entity}Example;
import org.java.service.${entity}Service;
import org.springframework.stereotype.Service;

@Service("${lowerentity}Service")
public class ${entity}ServiceImpl implements ${entity}Service {

	@Resource
	private ${entity}Mapper ${lowerentity}Mapper;
	
	//insert
	public int insert(${entity} record) {
		return ${lowerentity}Mapper.insert(record);
	}
	public int insertSelective(${entity} record) {
		return ${lowerentity}Mapper.insertSelective(record);
	}
	
	//update
	public int updateByPrimaryKey(${entity} record) {
		return ${lowerentity}Mapper.updateByPrimaryKey(record);
	}
	public int updateByPrimaryKeySelective(${entity} record) {
		return ${lowerentity}Mapper.updateByPrimaryKeySelective(record);
	}
	
	//delete
	public int deleteByPrimaryKey(Integer id) {
		return ${lowerentity}Mapper.deleteByPrimaryKey(id);
	}
	//id search
	public ${entity} selectByPrimaryKey(Integer id) {
		return ${lowerentity}Mapper.selectByPrimaryKey(id);
	}
	
	//list search
	public List<${entity}> selectByExample(${entity}Example example) {
		return ${lowerentity}Mapper.selectByExample(example);
	}
	public int countByExample(${entity}Example example) {
		return ${lowerentity}Mapper.countByExample(example);
	}
}
