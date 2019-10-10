package com.zaq.ssncv.ssncvapi.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result<T> {
    private T data;
    private String msg;
    private boolean success;
}
