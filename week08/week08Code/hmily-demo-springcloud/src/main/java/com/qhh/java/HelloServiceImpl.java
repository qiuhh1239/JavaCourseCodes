package com.qhh.java;

import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	@HmilyTCC(confirmMethod = "sayConfrim", cancelMethod = "sayCancel")
    public void say(String hello) {
         System.out.println("hello world");
    }
    
    public void sayConfrim(String hello) {
         System.out.println(" confirm hello world");
    }

    public void sayCancel(String hello) {
         System.out.println(" cancel hello world");
    }

}
