package com.module.dataaccesser.postgresql.article;

import com.module.dataaccesser.postgresql.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByTitle(String title);
    List<Article> findDistinctByCategory(String category);
    List<Article> findByTitleAndCategory(String title, String category);

}
