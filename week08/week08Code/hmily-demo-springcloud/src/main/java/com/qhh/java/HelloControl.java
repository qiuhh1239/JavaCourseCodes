package com.qhh.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControl {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value = "/say")
    public Boolean say() {
         System.out.println("control hello world");
         helloService.say("test");
         System.out.println(" control hello end");
         return true;
    }
    
}
