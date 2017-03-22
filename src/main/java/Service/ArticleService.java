package Service;

import Dao.ArticleDao;
import Dao.CommentDao;
import Dao.SimpleDao;
import entity.Article;
import entity.Comment;
import entity.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ArticleService {
    @Autowired
    ArticleDao articleDao;
    @Autowired
    SimpleDao simpleDao;
    @Autowired
    CommentDao commentDao;

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public void setSimpleDao(SimpleDao simpleDao) {
        this.simpleDao = simpleDao;
    }

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void postArticle(Article article){
        articleDao.createArticle(article);
    }

    public void deleteArticle(Long id){
        Article article = articleDao.queryArticleById(id);
        List<Comment> comments = articleDao.queryCommentForArticle(article);
        for(Comment c:comments){
            commentDao.deleteComment(c.getId());
        }

        Set<SimpleUser> collectors = articleDao.querySimpleByArticle(article);
        for(SimpleUser user:collectors){
            simpleDao.collectArticle(user.getId(),article);
        }
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

    public List<Article> queryRecentArticlesByAuthor(String name, int number){
        return articleDao.queryRecentArticlesByAuthor(name, number);
    }

    public int getTotalNumOfArticles(String name){
        return articleDao.getTotalNumOfArticles(name);
    }

    public void addClickCount(Long id){
        articleDao.addClickCount(id);
    }
}
