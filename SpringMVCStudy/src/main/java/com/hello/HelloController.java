package com.hello;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hello")
@Controller
public class HelloController {

	/**
	 * 请求http://localhost:8080/SpringMVCStudy/hello/hi返回hello success
	 * 常用:使用methodָ请求方式
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public String say(){
		System.out.println("hello world");
		return "hello success";
	}
}
