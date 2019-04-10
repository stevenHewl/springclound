package SpringCloudStream.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 创建 StreamClient 接口，通过 @Input和 @Output注解定义输入通道和输出通道，另外，@Input 和 @Output
 * 注解都还有一个 value 属性， 该属性可以用来设置消息通道的名称，这里指定的消息通道名称分别是 myInput 和 myOutput。
 * 如果直接使用两个注解而没有指定具体的 value 值，则会默认使用方法名作为消息通道的名称。
 */

//消息通道绑定的定义
public interface StreamClient {

	String RECEIVE = "myInput"; // 消息接受通道 myInput 对应配置里面的
	String SEND = "myOutput"; // 消息发送通道 myOutput 对应配置里面的

	// 定义输入通道时，需要返回 SubscribableChannel 接口对象，该接口集成自 MessageChannel
	// 接口，它定义了维护消息通道订阅者的方法。
	@Input(StreamClient.RECEIVE)
	SubscribableChannel GetReceiveMessageChannel();

	// 定义输出通道的时候，需要返回 MessageChannel 接口对象，该接口定义了向消息通道发送消息的方法
	@Output(StreamClient.SEND)
	MessageChannel GetSendMessageChannel();
}



