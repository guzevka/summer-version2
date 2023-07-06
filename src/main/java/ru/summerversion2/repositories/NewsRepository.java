package ru.summerversion2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.summerversion2.models.News;

public interface NewsRepository extends JpaRepository<News, Long> {
}
