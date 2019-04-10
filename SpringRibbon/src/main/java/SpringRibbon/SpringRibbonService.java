package SpringRibbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/*
 说明访问controller时，RestTemplate调用了服务，做了负载均衡，访问了不同的端口的服务实例。
一个服务注册中心，eureka server,端口为8761
spring-test-service工程跑了两个实例，端口分别为8081,8082，分别向服务注册中心注册
spring-ribbon-service 端口为8083,向服务注册中心注册
当spring-ribbon-service通过restTemplate调用spring-test-service的port接口时，
因为用ribbon进行了负载均衡，会轮流的调用spring-test-service:8081,8082 两个端口的port接口；
spring-ribbon-service 只提供一个客服端负载均衡作用，轮流调用其它服务的多个实例，本身并不提供功能服务。

通过spring-cloud-zipkin 进行链路追踪查看
 * */
@Service
public class SpringRibbonService {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	/*
	 * restTemplate 调用服务接口的方法不是仅此一种，API 大致如下，具体怎么选择应用，可以查看相关 API 文档， 我们直接使用
	 * getForObject 第一种，在这里我们直接用的程序名替代了具体的 url 地址， 在 Ribbon
	 * 中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的 url 替换掉服务名
	 */

	// 在 port 方法上加上 @HystrixCommand 注解，对此方法开启熔断器功能，用 fallbackMethod 属性指定熔断回调方法。
	@HystrixCommand(fallbackMethod = "portFallback")
	public String port() {
		this.loadBalancerClient.choose("spring-test-service"); // 随机访问策略
		return restTemplate.getForObject("http://spring-test-service/port", String.class);
	}

	public String portFallback() {
		return "sorry ribbon, it's error!";
	}
}
