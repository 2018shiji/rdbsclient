package com.module.dataAccesser.postgreSQL.article;

import com.module.dataAccesser.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPSArticleRepository extends PagingAndSortingRepository<Article, Long> {
    /**Pageable:分页参数**/
    Page<Article> findByTitle(String title, Pageable pageable);

}
