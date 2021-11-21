package bytes.qhh.kafkaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }


	/*   @Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	
	@Bean
	ApplicationRunner run() {
	    return args -> {
	        new Thread(() -> {
	        	 kafkaTemplate.send("test-topic", "test"+System.currentTimeMillis());
	        }).start();
	
	    };
	}*/
    
    @RequestMapping("/test1")
    public String test() {
        System.out.println("hello world!");
        return "ok";
    }

}
