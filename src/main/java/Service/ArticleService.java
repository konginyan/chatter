package Service;

import Dao.ArticleDao;
import entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService {
    @Autowired
    ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void postArticle(Article article){
        articleDao.createArticle(article);
    }

    public void deleteArticle(Long id){
        articleDao.deleteArticle(id);
    }

    public List<Article> queryArticleByText(String key){
        return articleDao.queryArticleByText(key);
    }

    public List<Article> queryArticleByPageAndText(int page, int perPage, String key){
        return articleDao.queryArticleByPageAndText(page, perPage, key);
    }

    public List<Article> queryArticleByTextAndAuthor(String key, String name){
        return articleDao.queryArticleByTextAndAuthor(key,name);
    }

    public List<Article> queryArticleByPageAndTextAndAuthor(int page, int perPage, String key, String name){
        return articleDao.queryArticleByPageAndTextAndAuthor(page, perPage, key, name);
    }

    public List<Article> getRecentArticles(int number){
        return articleDao.queryRecentArticles(number);
    }

    public Article queryArticleById(Long id){
        return articleDao.queryArticleById(id);
    }

    public void addClickCount(Long id){
        articleDao.addClickCount(id);
    }
}
