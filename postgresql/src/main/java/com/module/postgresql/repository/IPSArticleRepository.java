package com.module.postgresql.repository;

import com.module.postgresql.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPSArticleRepository extends PagingAndSortingRepository<Article, Long> {
    /**Pageable:分页参数**/
    Page<Article> findByTitle(String title, Pageable pageable);

}
