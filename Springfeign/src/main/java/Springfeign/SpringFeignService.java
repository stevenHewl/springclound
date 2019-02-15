package Springfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 *通过 @FeignClient 指定调用的服务。@RequestMapping 的 value 值和 spring-test-service 提供的服务接口的 @RequestMapping 的 value 值一致。
 */

@FeignClient(value = "spring-test-service", fallback = ErrorHystrix.class)
public interface SpringFeignService {

	@RequestMapping(value = "port", method = RequestMethod.GET)
	String hello();
}

/*
 * Feign是一个声明式的REST客户端，它的目的就是让REST调用更加简单。
 * Feign提供了HTTP请求的模板，通过编写简单的接口和插入注解，就可以定义好HTTP请求的参数、格式、地址等信息。
 * 而Feign则会完全代理HTTP请求，我们只需要像调用方法一样调用它就可以完成服务请求及相关处理。
 * SpringCloud对Feign进行了封装，使其支持SpringMVC标准注解和HttpMessageConverters。
 * Feign可以与Eureka和Ribbon组合使用以支持负载均衡。
 */