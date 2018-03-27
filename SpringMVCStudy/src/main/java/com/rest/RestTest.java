package com.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST风格
 * CRUD操作：
 * 新增:order 	post
 * 修改:order/1  put
 * 删除:order/1  delete
 * 获取:order/1  get
 * 
 * 如何发送PUT、DELETE 请求：
 * 	1.需要配置HiddenHttpMethodFilter过滤器
 *  2.需要发送post请求
 *  3.需要发送post时，携带一个name="_method"的隐藏域,值为DELETE或PUT
 * 在SpringMVC中如何获取id？
 *  使用@PathVariable注解
 * @author 12862
 *
 */
@RequestMapping("/rest")
@RestController
public class RestTest {

	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String getMethod(@PathVariable("id") Integer id){
		System.out.println("get请求..."+id);
		return "success";
	}
	
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String postMethod(){
		System.out.println("post请求...");
		return "success";
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.DELETE)
	public String deleteMethod(@PathVariable("id") Integer id){
		System.out.println("delete请求..."+id);
		return "success";
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
	public String putMethod(@PathVariable("id") Integer id){
		System.out.println("put请求..."+id);
		return "success";
	}
}
