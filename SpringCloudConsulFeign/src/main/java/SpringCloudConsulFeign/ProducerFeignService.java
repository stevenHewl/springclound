package SpringCloudConsulFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 调用生产者服务
 */
@FeignClient(value = "spring-consul-producer")
public interface ProducerFeignService {
	// @GetMapping("/producer")
	@RequestMapping(value = "producer", method = RequestMethod.GET)
	String producer();
}