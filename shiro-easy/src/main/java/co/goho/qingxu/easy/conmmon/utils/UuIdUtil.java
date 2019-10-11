package co.goho.qingxu.easy.conmmon.utils;

import java.util.UUID;

public class UuIdUtil {

    public static String getUuID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
