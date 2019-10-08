package co.goho.qingxu.bean;


import co.goho.qingxu.annotation.Ignore;
import co.goho.qingxu.annotation.Order;

public class User {
    @Order(order = 1)
    @Ignore
    private String id;

    @Order(order = 2)
    private String name;

    @Order(order = 3)
    private String sjhm;

    @Order(order = 4)
    private String sfzh;

    @Order(order = 6)
    private String xb;

    @Order(order = 5)
    private boolean code;

    private int ooo;

    public int getOoo() {
        return ooo;
    }

    public void setOoo(int ooo) {
        this.ooo = ooo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public boolean getCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }
}
