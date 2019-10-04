package co.goho.qingxu.rabbitmq.config;

public interface RabbitDic {
    
    String DIRECT_QUEUE = "directQueue";
    String TOPIC_QUEUE_ONE = "topic_queue_one";
    String TOPIC_QUEUE_TWO = "topic_queue_two";
    String FANOUT_QUEUE_ONE = "fanout_queue_one";
    String FANOUT_QUEUE_TWO = "fanout_queue_two";

    String TOPIC_EXCHANGE = "topic_exchange";
    String FANOUT_EXCHANGE = "fanout_exchange";

    String TOPIC_ROUTINGKEY_ONE = "common_key";
    String TOPIC_ROUTINGKEY_TWO = "*.key";
}
