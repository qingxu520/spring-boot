package co.goho.qingxu.shiro.common.utils;

import java.util.UUID;

public class UuIdUtil {

    public static String getUuID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
