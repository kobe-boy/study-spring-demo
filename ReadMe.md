## SpringStudy项目是一个spring学习项目：
### 目录结构：
* com.hello 是spring的helloword.
* com.aop   是spring的aop例子
* com.di    是spring的泛型依赖注入的例子
* com.jdbc  是spring的JdbcTemplate的例子
* com.tx    是spring的注解事务的例子

## SpringMVCStudy是一个springmvc学习项目:
### 目录结构：
* com.hello 是springmvc的helloworld
  * 常用注解@RequestParam,@RequestHeader,@CookieValue，@PathVariable
  * 接收对象类型参数，返回json数据
  * 返回ModelAndView类型
  * 参数中添加Map类型
* com.rest 是springmvc的rest风格API demo
* com.data 是springmvc的数据格式化demo
* com.upload 是springmvc的上传小demo
* com.interceptors 是springmvc的拦截器demo
* com.exception 是springmvc的异常处理

##### 问题1 需要进行 Spring 整合 SpringMVC 吗 ?还是否需要再加入 Spring 的 IOC 容器 ?是否需要再 web.xml 文件中配置启动 Spring IOC 容器的 ContextLoaderListener ?(三个是一个问题)
>答：
>1. 需要: 通常情况下, 类似于数据源, 事务, 整合其他框架都是放在 Spring 的配置文件中(而不是放在 SpringMVC 的配置文件中).实际上放入 Spring 配置文件对应的 IOC 容器中的还有 Service 和 Dao. 
>2. 不需要: 都放在 SpringMVC 的配置文件中. 也可以分多个 Spring 的配置文件, 然后使用 import 节点导入其他的配置文件

##### 问题2: 若 Spring 的 IOC 容器和 SpringMVC 的 IOC 容器扫描的包有重合的部分, 就会导致有的 bean 会被创建 2 次.
>解决:
>1. 使 Spring 的 IOC 容器扫描的包和 SpringMVC 的 IOC 容器扫描的包没有重合的部分. 
>2. 使用 exclude-filter 和 include-filter 子节点来规定只能扫描的注解

##### 问题3 SpringMVC 的 IOC 容器中的 bean 可以来引用 Spring IOC 容器中的 bean. 返回来呢 ? 
>反之则不行. Spring IOC 容器中的 bean 却不能来引用 SpringMVC IOC 容器中的 bean!



![spring注解](
https://github.com/wutao-boy/study-spring-demo/blob/master/%E8%B5%84%E6%96%99/Spring%E6%B3%A8%E8%A7%A3%E9%A9%B1%E5%8A%A8%E5%BC%80%E5%8F%91.PNG
)
