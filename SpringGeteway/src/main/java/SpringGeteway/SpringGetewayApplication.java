package SpringGeteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 添加 @EnableZuulProxy 注解，开启 Zuul 的功能
public class SpringGetewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGetewayApplication.class, args);
	}

}

