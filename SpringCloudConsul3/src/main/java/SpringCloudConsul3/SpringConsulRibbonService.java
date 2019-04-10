package SpringCloudConsul3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpringConsulRibbonService {

	@Autowired
	RestTemplate restTemplate;

	public String producer() {
		return restTemplate.getForObject("http://spring-consul-producer/producer", String.class);
	}
}
