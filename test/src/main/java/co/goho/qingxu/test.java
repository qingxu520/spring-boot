package co.goho.qingxu;

import co.goho.qingxu.bean.User;
import co.goho.qingxu.utils.BeanUtils;

public class test {

    public static void main(String[] args) {
        User user = new User();
        user.setCode(true);
        user.setId("1");
        user.setName("2");
        user.setOoo(5);
        user.setSjhm("");
        //user.setSfzh("4");
        user.setXb("6");
        System.out.println(BeanUtils.getValueString(user));
    }

}
