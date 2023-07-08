package ru.summerversion2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.summerversion2.models.News;
import ru.summerversion2.repositories.NewsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public News getNewsById(Long id) {
        return newsRepository.getNewsById(id);
    }

    public void save(News news){
        news.setDate(new Date());
        newsRepository.save(news);
        log.info("saving new {}", news);
    }

    public void delete(Long id){
        newsRepository.deleteById(id);
    }

}
