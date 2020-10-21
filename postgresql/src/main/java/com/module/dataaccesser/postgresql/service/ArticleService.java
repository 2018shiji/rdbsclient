package com.module.dataaccesser.postgresql.service;

import com.module.dataaccesser.postgresql.entity.Article;
import com.module.dataaccesser.postgresql.repository.IArticleRepository;
import com.module.dataaccesser.postgresql.repository.IPSArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private IArticleRepository articleRepository;
    @Autowired
    private IPSArticleRepository psArticleRepository;

    public Article getArticleById(long articleId){
        Article obj = articleRepository.findById(articleId).get();
        return obj;
    }


    public List<Article> getAllArticles(){
        List<Article> list = new ArrayList();
        articleRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    public synchronized boolean addArticle(Article article){
        List<Article> list = articleRepository.findByTitleAndCategory(
                article.getTitle(), article.getCategory());
        if(list.size() > 0)
            return false;
        else{
            articleRepository.save(article);
            return true;
        }
    }

    public void updateArticle(Article article){
        articleRepository.save(article);
    }

    public void deleteArticle(int articleId){
        articleRepository.delete(getArticleById(articleId));
    }

    public List<Article> getAllArticlesPage(){
        Pageable pageable = PageRequest.of(0,10);
        Page<Article> articlePages = psArticleRepository.findAll(pageable);
        List<Article> articleList = articlePages.getContent();
        return articleList;
    }

    public List<Article> getArticlesByTitlePage(String title){
        Pageable pageable = PageRequest.of(1,10);
        Page<Article> articlePages = psArticleRepository.findByTitle(title, pageable);
        List<Article> articleList = articlePages.getContent();
        return articleList;
    }

    public List<Article> getArticlesSort(){
        Iterable<Article> articleIt = psArticleRepository.findAll(Sort.by("title"));
        List<Article> articleList = new ArrayList<>();
        articleIt.forEach(e -> articleList.add(e));
        return articleList;
    }

    public List<Article> getArticlePageAndSort(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("title"));
        Page<Article> articlePages = psArticleRepository.findAll(pageable);
        List<Article> articleList = articlePages.getContent();
        return articleList;
    }
}
