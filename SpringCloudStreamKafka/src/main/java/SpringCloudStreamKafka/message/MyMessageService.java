package SpringCloudStreamKafka.message;

import javax.annotation.Resource;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyMessageService {
	//使用@Resource注入时需要指定我们刚才定义的输出通道名称
	@Resource(name = MyMessageChannel.SHOP_OUTPUT)
    private MessageChannel sendShopMessageChannel;

    @GetMapping("/sendMsg")
    public String sendShopMessage(String content) {
		boolean isSendSuccess = sendShopMessageChannel.send(MessageBuilder.withPayload(content).build());
        return isSendSuccess ? "发送成功" : "发送失败";
    }

    //这个注解可以监听输入通道里的消息内容，注解里面的属性指定我们刚才定义的输入通道名称，而MessageChannel则可以通过
    @StreamListener(MyMessageChannel.SHOP_INPUT)
    public void receive(Message<String> message) {
        System.out.println(message.getPayload());
    }
}
