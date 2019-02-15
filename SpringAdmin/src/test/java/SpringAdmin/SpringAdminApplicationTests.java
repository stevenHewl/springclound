package SpringAdmin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.netflix.discovery.shared.Application;

@RunWith(SpringRunner.class) // 就是一个运行器
@SpringBootTest(classes = Application.class)
public class SpringAdminApplicationTests {

	@Test
	public void contextLoads() {
	}

}

