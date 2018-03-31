package com.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/data")
@Controller
public class DataController {

	/**
	 * 测试日期类型,货币类型是否能正确转换
	 * 步骤：
	 * 		1.在配置文件中加上<mvc:annotation-driven /> 
	 *  	2.在对象对应的属性上加上注解@DateTimeFormat，@NumberFormat
	 * @param person
	 * @return
	 */
	@RequestMapping("/get")
	public String getPerson(Person person){
		System.out.println(person.toString());
		return "success";
	}
}
