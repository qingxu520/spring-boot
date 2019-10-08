package co.goho.qingxu.rabbitmq.controler;

import co.goho.qingxu.rabbitmq.common.ResponseApi;
import co.goho.qingxu.rabbitmq.config.DemoException;
import co.goho.qingxu.rabbitmq.rabbit.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    private Producer producer;

    @RequestMapping("/directSend")
    public boolean directSend(){
      return producer.directSend("directSend");
    }
    @RequestMapping("/topicSend")
    public ResponseApi topicSend(){
        producer.topicSend("topicSend");
        return ResponseApi.OK();
    }
    @RequestMapping("/fanoutSend")
    public boolean fanoutSend(){
        return producer.fanoutSend("fanoutSend");
    }
}
