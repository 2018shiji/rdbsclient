package com.module.dataaccesser.postgresql.article;

import com.module.dataaccesser.postgresql.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPSArticleRepository extends PagingAndSortingRepository<Article, Long> {
    /**Pageable:分页参数**/
    Page<Article> findByTitle(String title, Pageable pageable);

}
