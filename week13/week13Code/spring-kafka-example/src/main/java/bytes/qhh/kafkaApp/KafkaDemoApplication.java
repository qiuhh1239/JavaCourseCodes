package bytes.qhh.kafkaApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }


    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    

    @Bean
    ApplicationRunner run() {
        return args -> {
            new Thread(() -> {
            	 kafkaTemplate.send("test-topic", "test"+System.currentTimeMillis());
            }).start();

        };
    }

}
