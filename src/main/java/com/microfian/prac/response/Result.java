package com.microfian.prac.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result() {
        super();
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }


    public static Result success() {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static Result failure(Integer resultCode) {
        Result result = new Result();
        result.setCode(resultCode);
        return result;
    }

    public static Result failure(Integer resultCode, Object data) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setData(data);
        return result;
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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}