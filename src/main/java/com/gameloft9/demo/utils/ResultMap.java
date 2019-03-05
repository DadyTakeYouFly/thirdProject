package com.gameloft9.demo.utils;

public class ResultMap {
    private String msg;
    private Integer code;
    private Object data;
    private Integer count;

    @Override
    public String toString() {
        return "ResultMap{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", count=" + count +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ResultMap() {
    }

    public ResultMap(String msg, Integer code, Object data, Integer count) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.count = count;
    }

    public ResultMap(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public ResultMap(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static ResultMap okData(Object data){
        return new ResultMap("成功",200,data);
    }

    public static ResultMap ok(){
        return new ResultMap("成功",200,null);
    }

    public static ResultMap fail(){
        return new ResultMap("失败，滚蛋",500,null);
    }


}
