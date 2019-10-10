package com.zaq.ssncv.ssncvprovidercomment.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Comment;
import com.zaq.ssncv.ssncvprovidercomment.dao.CommentDao;
import com.zaq.ssncv.ssncvprovidercomment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZAQ
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    public CommentServiceImpl(@Autowired CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> listBySpot(String sid) {
        return commentDao.selectBySpot(sid);
    }

    @Override
    public int add(Comment comment) {
        return commentDao.insert(comment);
    }
}
