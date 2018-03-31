package com.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 * 		1.自定义拦截器实现HandlerInterceptor
 * 		2.在配置文件中配置自定义拦截器
 * @author 
 *
 */
public class FirstInterceptor implements HandlerInterceptor{

	/*
	 * 该方法在目标调用之前调用
	 * 返回true目标方法调用
	 * 返回false目标方法不会调用
	 * 
	 * 可以考虑做权限、日志、事务
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("[FirstInterceptor] preHandle");
		return true;
	}

	/**
	 * 该方法是调用目标方法之后，返回视图之前被调用
	 * 可以对请求域中的属性或视图做出修改
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[FirstInterceptor] postHandle");

	}

	/**
	 * 该方法是渲染视图之后被调用
	 * 释放资源
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[FirstInterceptor] afterCompletion");

	}

}
