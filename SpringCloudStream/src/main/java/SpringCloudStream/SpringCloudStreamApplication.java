package SpringCloudStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringCloudStream.message.StreamClient;

//使用上面定义的消息通道绑定接口 StreamClient 向被监听的消息通道发送消息，具体如下：
@SpringBootApplication
@RestController
public class SpringCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamApplication.class, args);
	}

	@Autowired
	private StreamClient streamClient;

	@GetMapping("send")
	public void send() {
		streamClient.GetSendMessageChannel().send(MessageBuilder.withPayload("Hello World...").build());
	}
}


