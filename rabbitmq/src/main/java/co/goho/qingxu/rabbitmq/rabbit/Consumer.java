package co.goho.qingxu.rabbitmq.rabbit;

import co.goho.qingxu.rabbitmq.config.DemoException;
import co.goho.qingxu.rabbitmq.config.RabbitDic;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    //@RabbitListener(queues = "myQueue")  这里需要在 rabbitmq 中手动添加 myQueue 队列，不然就会报错
    //如果不存在，自动创建队列
    @RabbitListener(queuesToDeclare = @Queue(RabbitDic.DIRECT_QUEUE))
    public void directReceiver(String msg) {
        log.info("接收到队列消息:{}", msg);
    }

    //如果不存在，自动创建队列和交换器并且绑定
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = RabbitDic.TOPIC_QUEUE_ONE, durable = "true"),
                    exchange = @Exchange(value = RabbitDic.TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = RabbitDic.TOPIC_QUEUE_ONE)})
    public void receiverMqExchage(String msg, Channel channel, Message message) throws IOException {
        Long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("接收到TOPIC_QUEUE_ONE消息:{}", msg);
            channel.basicAck(deliveryTag, false);
            //发生异常
            //log.error("发生异常");
            //int i = 1 / 0;
            //告诉服务器收到这条消息 已经被我消费了 可以在队列删掉 这样以后就不会再发了 否则消息服务器以为这条消息没处理掉 后续还会在发
        } catch (Exception e) {
            log.error("接收消息失败,重新放回队列"+"/n"+e.getMessage());
            // 解决方案，剔除此消息，然后记录到db中去补偿
            //channel.basicNack(deliveryTag, false, true);
            //拒绝消息 requeu，为true，代表重新放入队列多次失败重新放回会导致队列堵塞或死循环问题，
            channel.basicReject(deliveryTag, true);
        }
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = RabbitDic.TOPIC_QUEUE_TWO, durable = "true"),
                    exchange = @Exchange(value = RabbitDic.TOPIC_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = RabbitDic.TOPIC_QUEUE_TWO)})
    public void receiverMqExchageTwo(String msg) {
        log.info("接收到TOPIC_QUEUE_TWO消息:{}", msg);
    }


    @RabbitListener(queuesToDeclare = @Queue(RabbitDic.FANOUT_QUEUE_ONE))
    public void receiverMqFanout(String msg, Channel channel, Message message) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            log.info("接收到队列fanout_queue_one消息:{}", msg);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            e.printStackTrace();
            //多次失败重新放回会导致队列堵塞或死循环问题 丢弃这条消息
//   channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            channel.basicReject(deliveryTag, true);
            log.error("接收消息失败"+e.getMessage());
        }
    }

    @RabbitListener(queuesToDeclare = @Queue(RabbitDic.FANOUT_QUEUE_TWO))
    public void receiverMqFanoutTwo(String msg) {
        log.info("接收到队列fanout_queue_two消息:{}", msg);
    }
}
