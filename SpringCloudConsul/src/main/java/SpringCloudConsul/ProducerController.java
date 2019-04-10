package SpringCloudConsul;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//生产者代码
@RestController
public class ProducerController {
	@GetMapping("/producer")
	public String producer() {
		System.out.println("I'm producer");
		return "Hello, I'm producer 1";
	}
}
