package com.zaq.ssncv.ssncvprovidercomment.service;

import com.zaq.ssncv.ssncvapi.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listBySpot(String sid);

    int add(Comment comment);

}
