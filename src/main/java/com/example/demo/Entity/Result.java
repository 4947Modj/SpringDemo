package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public static Result success(){
        return new Result(1,"success",null);
    }

    public static Result success(Object obj){
        return new Result(1,"success",obj);
    }


    public static Result error(String message){
        return new Result(0,message,null);
    }
}
