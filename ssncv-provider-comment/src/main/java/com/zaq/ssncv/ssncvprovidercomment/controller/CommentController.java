package com.zaq.ssncv.ssncvprovidercomment.controller;

import com.zaq.ssncv.ssncvapi.entity.Comment;
import com.zaq.ssncv.ssncvapi.entity.Result;
import com.zaq.ssncv.ssncvprovidercomment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZAQ
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;
    public CommentController(@Autowired CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping("/get")
    public Result<List<Comment>> listBySpot(@RequestParam("sid") String sid) {
        return commentService.listBySpot(sid);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> add(@RequestBody Comment comment) {
        return commentService.add(comment);
    }
}
