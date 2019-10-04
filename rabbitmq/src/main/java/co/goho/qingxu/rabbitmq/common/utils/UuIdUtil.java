package co.goho.qingxu.rabbitmq.common.utils;

import java.util.UUID;

public class UuIdUtil {

    public static String getUuID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
