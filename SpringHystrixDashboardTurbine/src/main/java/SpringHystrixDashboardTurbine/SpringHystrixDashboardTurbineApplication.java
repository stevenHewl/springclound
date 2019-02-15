package SpringHystrixDashboardTurbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/*
 Hystrix Dashboard 是个独立的服务，可以不注册到 eureka server，但是 Turbine 是聚合多个服务，通过服务实例 id 聚合，
 所以它要注册到 eureka server 中，获取服务列表，用以聚合监控。
 * */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class SpringHystrixDashboardTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHystrixDashboardTurbineApplication.class, args);
	}

}

