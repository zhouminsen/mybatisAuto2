
package ${package};

import java.util.List;

import org.java.entity.${entity};
import org.java.entity.${entity}Example;

public interface ${entity}Service {
	
	//insert
	int insert(${entity} record);
	int insertSelective(${entity} record);
	
	//update
	int updateByPrimaryKey(${entity} record);
	int updateByPrimaryKeySelective(${entity} record);
	
	//delete
	int deleteByPrimaryKey(Integer id);
	//id search
	${entity} selectByPrimaryKey(Integer id);
	
	//list search
	List<${entity}> selectByExample(${entity}Example example);
	int countByExample(${entity}Example example);
}
