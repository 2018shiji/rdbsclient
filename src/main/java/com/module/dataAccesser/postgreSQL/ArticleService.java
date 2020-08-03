package com.module.dataAccesser.postgreSQL;

import com.module.dataAccesser.postgreSQL.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

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
}
