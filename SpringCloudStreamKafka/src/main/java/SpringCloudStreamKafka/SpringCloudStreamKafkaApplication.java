package SpringCloudStreamKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import SpringCloudStreamKafka.message.MyMessageChannel;

//@EnableBinding注解，这个注解指定刚才我们定义消息通道的接口名称，当然这里也可以传多个相关的接口
@SpringBootApplication
@EnableBinding(MyMessageChannel.class)
public class SpringCloudStreamKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaApplication.class, args);
	}

}
