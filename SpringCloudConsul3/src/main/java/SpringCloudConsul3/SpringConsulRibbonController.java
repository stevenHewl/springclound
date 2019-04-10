package SpringCloudConsul3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringConsulRibbonController {

	@Autowired
	SpringConsulRibbonService springConsulRibbonService;

	@RequestMapping("consumer")
	public String port() {
		return springConsulRibbonService.producer();
	}
}
