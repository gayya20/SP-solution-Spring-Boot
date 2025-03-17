package com.example.NewsWebSite.service;

import com.example.NewsWebSite.entity.News;
import com.example.NewsWebSite.repo.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public List<News> getNewsByCategory(Long categoryId) {
        return newsRepository.findByCategories_Id(categoryId);
    }

    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public News addNews(News news) {
        return newsRepository.save(news);
    }

    public List<News> getAllnews() {
        return newsRepository.findAll();
    }
}
