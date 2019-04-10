package SpringCloudConsulFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者
 */
@RestController
public class ConsumerController {
	@Autowired
	private ProducerFeignService producerRemote;

	@GetMapping("/consumer")
	public String getProducer() {
		return producerRemote.producer();
	}
}
