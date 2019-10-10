package com.zaq.ssncv.ssncvapi.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {

    private String id;


//    private Integer uid;

    private User user;
    private String sid;
    private Date sendtime;
    private String content;

}