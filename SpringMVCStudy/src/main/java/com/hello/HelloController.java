package com.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hello")
@Controller
public class HelloController {

	/**
	 * ����http://localhost:8080/SpringMVCStudy/hello/hi���ؽ��hello success
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/hi")
	public String say(){
		System.out.println("hello world");
		return "hello success";
	}
}
