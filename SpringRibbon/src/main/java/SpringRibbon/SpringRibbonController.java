package SpringRibbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 模拟客户端测试，通过SpringRibbonService负载轮流调用其它服务
 * */
@RestController
public class SpringRibbonController {

	@Autowired
	SpringRibbonService springRibbonService;

	@RequestMapping("hello")
	public String port() {
		return springRibbonService.port();
	}
}

