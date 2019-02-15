package SpringRibbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/*要使被监控的服务打开 Actuator，并开启了断路器。
对 SPRING-RIBBON-SERVICE 服务进行监控
*/

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix // 开启短路器
@EnableCircuitBreaker // 开启hystrix-dashboard对此组件进行监控
public class SpringRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IRule ribbonRule() {
		return new RandomRule(); // 这里配置策略，和配置文件对应
		// return new RoundRobinRule(); //轮询
	}
}

