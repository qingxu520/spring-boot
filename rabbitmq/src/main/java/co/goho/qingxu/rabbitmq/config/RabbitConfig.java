package co.goho.qingxu.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Broker:它提供一种传输服务,它的角色就是维护一条从生产者到消费者的路线，保证数据能按照指定的方式进行传输,
 * Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列:
 *      FanoutExchange: 无routingkey的概念,采取广播模式，一个消息进来时，投递到与该交换机绑定的所有队列
 *      HeadersExchange：通过添加属性key-value匹配
 *      DirectExchange:按照routingkey分发到指定队列。，例如，绑定时设置了routing key为”abc”，那么客户端提交的消息，
 *                     只有设置了key为”abc”的才会投递到队列
 *      TopicExchange:对key进行模式匹配后进行投递，符号”#”匹配一个或多个词，符号”*”匹配正好一个词。
 *                    例如”abc.#”匹配”abc.def.ghi”，”abc.*”只匹配”abc.def”。
 * Queue:消息的载体,每个消息都会被投到一个或多个队列。
 * Binding:绑定，它的作用就是把exchange和queue按照路由规则绑定起来.
 * Routing Key:路由关键字,exchange根据这个关键字进行消息投递。
 * vhost:虚拟主机,一个broker里可以有多个vhost，用作不同用户的权限分离。
 * Producer:消息生产者,就是投递消息的程序.
 * Consumer:消息消费者,就是接受消息的程序.
 * Channel:消息通道,在客户端的每个连接里,可建立多个channel，每个channel代表一个会话任务。
 */
@Configuration
public class RabbitConfig {

    // direct模式队列
    @Bean
    public Queue directQueue() {
        return new Queue(RabbitDic.DIRECT_QUEUE, true);
    }
    // topic 订阅者模式队列
    @Bean
    public Queue topicQueueOne() {
        return new Queue(RabbitDic.TOPIC_QUEUE_ONE, true);
    }
    @Bean
    public Queue topicQueueTwo() {
        return new Queue(RabbitDic.TOPIC_QUEUE_TWO, true);
    }
    // fanout 广播者模式队列
    @Bean
    public Queue fanoutQueueOne() {
        return new Queue(RabbitDic.FANOUT_QUEUE_ONE, true);
    }
    @Bean
    public Queue fanoutQueueTwo() {
        return new Queue(RabbitDic.FANOUT_QUEUE_TWO, true);
    }
    // topic 交换器
    @Bean
    public TopicExchange topExchange() {
        return new TopicExchange(RabbitDic.TOPIC_EXCHANGE);
    }
    // fanout 交换器
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitDic.FANOUT_EXCHANGE);
    }

    // 订阅者模式绑定
    @Bean
    public Binding topExchangeBingingOne() {
        return BindingBuilder.bind(topicQueueOne()).to(topExchange()).with(RabbitDic.TOPIC_ROUTINGKEY_ONE);
    }

    @Bean
    public Binding topicExchangeBingingTwo() {
        return BindingBuilder.bind(topicQueueTwo()).to(topExchange()).with(RabbitDic.TOPIC_ROUTINGKEY_TWO);
    }
    // 广播模式绑定
    @Bean
    public Binding fanoutExchangeBingingOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }
    @Bean
    public Binding fanoutExchangeBingingTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }
}