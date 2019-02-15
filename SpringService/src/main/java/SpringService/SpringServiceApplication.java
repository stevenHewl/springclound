package SpringService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient //通过注解@EnableEurekaClient 表明自己是一个 EurekaClient。@EnableEurekaClient 注解是基于 spring-cloud-netflix 依赖，只能 eureka 使用
@RestController
public class SpringServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceApplication.class, args);
	}

}

