package com.zaq.ssncv.ssncvapi.entity;

import lombok.*;

import java.util.Date;

/**
 * @author ZAQ
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notification {
    private Integer id;

    private String title;

    private String content;

    private Date createTime;

    private Long createId;

    private Date updateTime;

    private Long updateId;

    private Long orderNo;

}