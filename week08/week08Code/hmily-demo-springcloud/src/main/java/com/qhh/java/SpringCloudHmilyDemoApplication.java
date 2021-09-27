package com.qhh.java;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@EnableFeignClients
@ImportResource({"classpath:applicationContext.xml"})
public class SpringCloudHmilyDemoApplication {

    /**
     * main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(SpringCloudHmilyDemoApplication.class, args);
    }
}
