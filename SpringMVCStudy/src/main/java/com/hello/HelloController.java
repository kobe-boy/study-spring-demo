package com.hello;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/**
	 * @PathVariable 可以将URL中的占位符映射到目标方法的参数中
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/rest/{id}")
	public String restSay(@PathVariable("id") Integer id){
		System.out.println("restSay:"+id);
		return id+"";
	}
	
	/**
	 * @RequestParam 映射请求参数:
	 * 	required参数是否必须，默认true
	 * 	defaultValue 设置默认值
	 * http://localhost:8080/SpringMVCStudy/hello/requestParam?id=1234
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/requestParam")
	public String testRequestParam(@RequestParam(value="id",required=false,defaultValue="0") Integer id){
		System.out.println("requestParam:"+id);
		return id+"";
	} 
	
	/**
	 * 映射请求头信息@RequestHeader
	 * @param al
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/requestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language") String al){
		System.out.println("请求头，Accept-Language："+al);
		return "Accept-Language:"+al;
	}
	
	/**
	 * 映射一个cookie值@CookieValue
	 * @param sessionId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/cookie")
	public String testCookie(@CookieValue("JSESSIONID") String sessionId){
		System.out.println("test sessionId："+sessionId);
		return "sessionId:"+sessionId;
	}
	
	/**
	 * 测试接收对象类型参数
	 * 当前不能返回json对象，缺少json的jar包
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/user")
	public String testPojo(User user){
		System.out.println("test user："+user);
		return user.toString();
	}
	
}
