package com.brian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;//0-success  1-fail
    private String message;
    private T data;//reponse data

    public static <E> Result<E> success(E data) {
        return new Result<>(0, "Success", data);
    }

    public static Result success() {
        return new Result(0, "Success", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
