package com.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rf")
public class RedirectAndForward {

	/**
	 * 请求重定向
	 * @return
	 */
	@RequestMapping(value="/red")
	public String testRedirect() {
		return "redirect:/rest/testRest/123";
	}
	/**
	 * 请求转发
	 * @return
	 */
	@RequestMapping(value="/for")
	public String testForward() {
		return "forward:/rest/testRest/124";
	}
}
