package ${package};

import javax.annotation.Resource;

import org.java.base.BaseController;
import org.java.service.${entity}Service;
import org.springframework.stereotype.Controller;

@Controller
public class ${entity}Controller extends BaseController{
	
	@Resource
	private ${entity}Service ${lowerentity}Service;
	
}