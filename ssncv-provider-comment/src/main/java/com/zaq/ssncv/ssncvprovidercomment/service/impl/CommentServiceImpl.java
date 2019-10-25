package com.zaq.ssncv.ssncvprovidercomment.service.impl;

import com.zaq.ssncv.ssncvapi.entity.Comment;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvapi.service.BaseService;
import com.zaq.ssncv.ssncvprovidercomment.dao.CommentDao;
import com.zaq.ssncv.ssncvprovidercomment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZAQ
 */
@Service
public class CommentServiceImpl extends BaseService implements CommentService {

    private CommentDao commentDao;

    public CommentServiceImpl(@Autowired CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Result<List<Comment>> listBySpot(String sid) {
        List<Comment> list = commentDao.selectBySpot(sid);
        Result<List<Comment>> result = new Result<>();
        wrapResponse(result, list);
        return result;
    }

    @Override
    public Result<String> add(Comment comment) {
        Result<String> result = new Result<>();
        int status = commentDao.insert(comment);
        wrapResponse(result, status);
        return result;
    }
}
