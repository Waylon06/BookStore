package com.waylon.serverbookstore.utils;

/**
 * @author Waylon
 */
public class Respond {
    private int code;//操作结果代码。一般统一规定成功是200.失败是201
    private String msg;//提示信息
    private Object data;//结果数据

    public Respond() {
    }

    public Respond(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    // 当接受到错误时进行error
    public static Respond error(int code, String msg) {
        Respond r = new Respond();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(null);
        return r;
    }

    //当接受到正确是进行success
    public static Respond success(int code, String msg, Object data) {
        Respond r = new Respond();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}
