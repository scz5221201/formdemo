package org.hzy.formdemo.vo;

/**
 * @program: formdemo
 * @description
 * @author: hzy
 * @create: 2020-03-13 17:11
 **/
public class RespBean {

    private int code;
    private String msg;
    private Object object;


    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean ok(String msg, Object object) {
        return new RespBean(200, msg, object);
    }

    public static RespBean error(String msg, Object object) {
        return new RespBean(500, msg, object);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }


    public RespBean() {
    }

    public RespBean(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
