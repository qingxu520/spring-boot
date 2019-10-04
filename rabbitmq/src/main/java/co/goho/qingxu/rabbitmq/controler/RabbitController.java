package co.goho.qingxu.rabbitmq.controler;

import co.goho.qingxu.rabbitmq.rabbit.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    private Producer producer = new Producer();

    @GetMapping("/directSend")
    public void directSend(){
      producer.directSend("directSend");
    }
    @GetMapping("/topicSend")
    public void topicSend(){
        producer.topicSend("topicSend");
    }
    @GetMapping("/fanoutSend")
    public void fanoutSend(){
        producer.fanoutSend("fanoutSend");
    }
}
