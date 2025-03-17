package com.example.NewsWebSite.controller;

import com.example.NewsWebSite.entity.Comment;
import com.example.NewsWebSite.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{newsId}")
    public List<Comment> getCommentsByNewsId(@PathVariable Long newsId) {
        return commentService.getCommentsByNewsId(newsId);
    }



    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }
}
