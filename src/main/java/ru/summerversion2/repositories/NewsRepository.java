package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findNewsByTitle(String title);

    News getNewsById(Long id);

    List<News> findTop3ByOrderByDateDesc();
}
