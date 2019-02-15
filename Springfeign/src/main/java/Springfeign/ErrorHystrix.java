package Springfeign;

import org.springframework.stereotype.Component;

/**
 * 创建SpringFeignService中指定的 ErrorHystrix 类，实现 SpringFeignService 接口，注入容器中
 */
@Component
public class ErrorHystrix implements SpringFeignService {
    @Override
    public String hello() {
		return "sorry, feign service call test service error!";
    }
}
