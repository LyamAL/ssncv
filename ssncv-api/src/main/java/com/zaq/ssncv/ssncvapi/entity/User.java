package com.zaq.ssncv.ssncvapi.entity;


import lombok.*;

/**
 * @author ZAQ
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int id;

    private String phone;

    private String username;


    private String avatar;


    private String password;
}