package com.example.NewsWebSite.controller;

import com.example.NewsWebSite.entity.News;
import com.example.NewsWebSite.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/category/{categoryId}")
    public List<News> getNewsByCategory(@PathVariable Long categoryId) {
        return newsService.getNewsByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        return newsService.getNewsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<News> getAllNews(){
        return newsService.getAllnews();
    }

    @PostMapping
    public ResponseEntity<News> addNews(@RequestBody News news) {
        News createdNews = newsService.addNews(news);
        return ResponseEntity.status(201).body(createdNews); // HTTP 201 for created resource
    }
}
