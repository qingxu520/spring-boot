package co.goho.qingxu.rabbitmq.common;

import java.io.Serializable;

public class ResponseApi<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String SUCCESSCODE="SUCCESS";
    private static final String ERRORCODE="ERROR";
    private String code;
    private String msg;
    private T data;

    public static ResponseApi OK(){
        return new ResponseApi(SUCCESSCODE,"请求成功",null);
    }
    public static ResponseApi OK(Object o){
        return new ResponseApi(SUCCESSCODE,"请求成功",o);
    }

    public static ResponseApi ERROR(String m){
        return new ResponseApi(ERRORCODE,"msg",null);
    }
    public static ResponseApi ERROR(String c,String m){
        return new ResponseApi(c,"msg",null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseApi(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseApi() {
    }
}
