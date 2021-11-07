package bytes.qhh.kafkaApp;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "test-topic")
    public void onMessage1(String message) {
        System.out.println("我是第一个消费者:" + message);
    }
    @KafkaListener(topics = "test-topic2")
    public void onMessage2(String message) {
        System.out.println("我是第二个消费者:" + message);
    }
}
