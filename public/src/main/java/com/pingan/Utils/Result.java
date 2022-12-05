package com.pingan.Utils;

import com.pingan.Object.R;

public class Result {
    public R success(Object data) {
        R result = new R();
        result.setCode(200);
        result.setMessage("请求成功");
        result.setData(data);
        return result;
    }

    public R fail(String string) {
        R result = new R();
        result.setCode(201);
        result.setMessage(string);
        return result;
    }

    public R tokenExceptions(String string) {
        R result = new R();
        result.setCode(401);
        result.setMessage(string);
        return result;
    }

    public R globalExceptions(String string) {
        R result = new R();
        result.setCode(501);
        result.setMessage(string);
        return result;
    }
}
