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
public class UserOnModify {

    private int id;
    private String newPhone;
    private String oldPhone;
    private String newName;
    private String oldName;
    private String newPsw;
    private String oldPsw;
}