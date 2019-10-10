package com.zaq.ssncv.ssncvprovidercomment.dao;

import com.zaq.ssncv.ssncvapi.entity.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> selectBySpot(String sid);

    int insert(Comment comment);

}
