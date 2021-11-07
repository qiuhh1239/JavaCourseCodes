package bytes.qhh.kafka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/kafka/")
public class KafkaProducerController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    
    @RequestMapping("send")
    @ResponseBody
    public boolean send(@RequestParam String message) {
        try {
            kafkaTemplate.send("test-topic", message);
            kafkaTemplate.send("test-topic2", message);
            System.out.println("消息发送成功...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    @RequestMapping("test")
    @ResponseBody
    public String test() {
        System.out.println("hello world!");
        return "ok";
    }
}