package com.example.demo.entity;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private int code = 200;
    private String msg = "成功";
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public Result(T data, boolean success) {
        this.data = data;
    }

    public static Result<Void> success() {
        return new Result(null, true);
    }

    public static <T> Result<T> success(T data) {
        return new Result(data, true);
    }


    public static <T> Result<T> error(int code, String message) {
        return new Result(code, message);
    }

    public boolean ok() {
        return this.code == 200;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    return other$data == null;
                } else return this$data.equals(other$data);

            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }


    public String toString() {
        return "Result(code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}