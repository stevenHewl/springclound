package Springfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * 在启动类中，通过 @EnableEurekaClient 向 eureka server 注册，通过 @EnableFeignClients 注解开启 Feign 的功能。
 * */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class SpringfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringfeignApplication.class, args);
	}

}

