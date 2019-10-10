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
    public Result<List<Comment>> listBySpot(@RequestParam String sid) {
        List<Comment> list = commentService.listBySpot(sid);
        Result<List<Comment>> result = new Result<>();
        result.setMsg(list == null ? "fail" : "success");
        result.setSuccess(list != null);
        result.setData(list);
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> add(@RequestBody Comment comment) {
        Result<String> result = new Result<>();
        int status = commentService.add(comment);
        if (status < 0) {
            result.setMsg("fail");
            result.setData("fail");
            result.setSuccess(false);
            return result;
        }
        result.setSuccess(true);
        result.setData("success");
        result.setMsg("success");
        return result;
    }


}
