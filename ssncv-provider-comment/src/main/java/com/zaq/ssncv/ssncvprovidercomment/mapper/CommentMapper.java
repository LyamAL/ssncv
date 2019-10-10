package com.zaq.ssncv.ssncvprovidercomment.mapper;

import com.zaq.ssncv.ssncvapi.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> selectBySid(String sid);

    int insert(Comment comment);
}
