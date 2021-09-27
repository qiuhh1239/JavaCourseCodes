package com.qhh.java;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*@FeignClient(value = "helle-service")*/
public interface HelloService {

	/*@Hmily
	@RequestMapping("/helle-service/sayHello")*/
    void say(String hello);
}
