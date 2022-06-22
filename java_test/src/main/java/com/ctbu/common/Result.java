package com.ctbu.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : TangHao
 * @description :
 * @ClassName :Result
 * @createTime : 2022/6/17 10:54
 * @updateTime : 2022/6/17 10:54
 * @updateRemark : [说明本次修改内容]
 */
@Data
public class Result<T> {

    private String msg;
    private Integer status;
    private T data;
    private Map<String,Object> map=new HashMap<>();

    public static <T> Result<T> success(T t){
        Result<T> result=new Result<>();
        result.status=1;
        result.data=t;
        return result;
    }

    public static <T> Result<T> error(String msg){
        Result<T> result=new Result<>();
        result.status=0;
        result.msg=msg;
        return result;
    }

    public static <T> Result<T> success(T t,String name,Object o){
        Result<T> result=new Result<>();
        result.map.put(name,o);
        result.status=1;
        result.data=t;
        return result;
    }
}
