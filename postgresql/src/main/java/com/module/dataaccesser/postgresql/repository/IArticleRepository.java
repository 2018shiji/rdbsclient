package com.module.dataaccesser.postgresql.repository;

import com.module.dataaccesser.postgresql.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
    List<Article> findDistinctByCategory(String category);
    List<Article> findByTitleAndCategory(String title, String category);

}
