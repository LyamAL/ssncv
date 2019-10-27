package com.zaq.ssncv.ssncvapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zaq.ssncv.ssncvapi.config.CustomDateDeserialize;
import lombok.*;

import java.util.Date;

/**
 * @author ZAQ
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {

    private String id;
    private User user;
    private String sid;
    @JsonDeserialize(using = CustomDateDeserialize.class)
    private Date sendtime;
    private String content;

}