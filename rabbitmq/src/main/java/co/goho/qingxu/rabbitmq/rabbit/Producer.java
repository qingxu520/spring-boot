package co.goho.qingxu.rabbitmq.rabbit;

import co.goho.qingxu.rabbitmq.common.utils.UuIdUtil;
import co.goho.qingxu.rabbitmq.config.RabbitDic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class Producer implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    // direct模式
    public void directSend(String message) {
        log.info("direct模式->发送消息:"+RabbitDic.DIRECT_QUEUE);
        rabbitTemplate.convertAndSend(RabbitDic.DIRECT_QUEUE, message);
    }

    //发送订阅者模式 topic
    public void topicSend(String massage) {
        CorrelationData cId = new CorrelationData(UuIdUtil.getUuID());
        CorrelationData cId01 = new CorrelationData(UuIdUtil.getUuID());
        log.info("订阅者模式->发送消息:"+RabbitDic.TOPIC_QUEUE_ONE);
        rabbitTemplate.convertSendAndReceive(RabbitDic.TOPIC_EXCHANGE, RabbitDic.TOPIC_QUEUE_ONE, massage, cId);
        log.info("订阅者模式->发送消息:"+RabbitDic.TOPIC_QUEUE_TWO);
        rabbitTemplate.convertSendAndReceive(RabbitDic.TOPIC_EXCHANGE, RabbitDic.TOPIC_QUEUE_TWO, massage, cId01);
    }

    //广播者模式 fanout
    public void fanoutSend(String massage) {
        //回调id
        CorrelationData cId = new CorrelationData(UuIdUtil.getUuID());
        log.info("订阅者模式->发送消息:"+RabbitDic.FANOUT_EXCHANGE);
        rabbitTemplate.convertSendAndReceive(RabbitDic.FANOUT_EXCHANGE, "", massage, cId);
    }

    /**
     * @return
     * @Description 确认消息是否发送到exchange
     * @Param [correlationData, ack, cause]
     **/
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("消息唯一标识id:{}", correlationData);
        log.info("消息确认结果!"+ack);
        log.error("消息失败原因,cause:{}", cause);
    }

    /**
     * @return
     * @Description 消息消费发生异常时返回
     * @Param [message, replyCode, replyText, exchange, routingKey]
     **/
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("消息发送失败id:{}", message.getMessageProperties().getCorrelationId());
        log.info("消息主体 message : ", message);
        log.info("消息主体 message : ", replyCode);
        log.info("描述：" + replyText);
        log.info("消息使用的交换器 exchange : ", exchange);

    }
}
