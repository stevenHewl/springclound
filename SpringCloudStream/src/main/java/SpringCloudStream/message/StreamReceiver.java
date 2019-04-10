package SpringCloudStream.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/*
 * 在完成了消息通道绑定的定义后，这些用于定义绑定消息通道的接口则可以被 @EnableBinding 注解的 value 参数指定，
 * 从而在应用启动的时候实现对定义消息通道的绑定，Spring Cloud Stream 会为其创建具体的实例，而开发者只需要通过
 * 注入的方式来获取这些实例并直接使用即可
 * 
 * */

//用于接收来自 RabbitMQ 消息的消费者 StreamReceiver
@Component
//@EnableBinding 注解用来指定一个或多个定义了 @Receive 或 @Send 注解的接口，以此实现对消息通道（Channel）的绑定
@EnableBinding(value = { StreamClient.class })
public class StreamReceiver {

	private Logger logger = LoggerFactory.getLogger(StreamReceiver.class);

	// @StreamListener，主要定义在方法上，作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，
	// 注解中的属性值对应了监听的消息通道名
	@StreamListener(StreamClient.RECEIVE)
	public void receive(String message) {
		logger.info("StreamReceiver: {}", message);
	}
}


