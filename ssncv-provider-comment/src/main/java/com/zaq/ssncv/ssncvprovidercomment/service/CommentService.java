package com.zaq.ssncv.ssncvprovidercomment.service;

import com.zaq.ssncv.ssncvapi.entity.Comment;
import com.zaq.ssncv.ssncvapi.entity.Result;

import java.util.List;

public interface CommentService {
    Result<List<Comment>> listBySpot(String sid);

    Result<String> add(Comment comment);

}
