package com.zaq.ssncv.ssncvprovidercomment.dao.impl;

import com.zaq.ssncv.ssncvapi.entity.Comment;
import com.zaq.ssncv.ssncvprovidercomment.dao.CommentDao;
import com.zaq.ssncv.ssncvprovidercomment.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    private CommentMapper commentMapper;

    public CommentDaoImpl(@Autowired CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> selectBySpot(String sid) {
        return commentMapper.selectBySid(sid);
    }

    @Override
    public int insert(Comment comment) {
        return commentMapper.insert(comment);
    }
}
