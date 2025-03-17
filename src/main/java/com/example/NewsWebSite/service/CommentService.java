package com.example.NewsWebSite.service;

import com.example.NewsWebSite.entity.Comment;
import com.example.NewsWebSite.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getCommentsByNewsId(Long newsId) {
        return commentRepository.findByNewsId(newsId);
    }

    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
