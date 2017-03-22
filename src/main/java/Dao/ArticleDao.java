package Dao;

import Util.HibernateTemplateExtend;
import entity.Article;
import entity.Comment;
import entity.SimpleUser;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Repository
public class ArticleDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public ArticleDao(){

    }

    public void createArticle(Article article){
        hibernateTemplate.save(article);
    }

    public void deleteArticle(Long id){
        Article article = hibernateTemplate.get(Article.class,id);
        hibernateTemplate.delete(article);
    }

    public List<Article> queryArticleByText(String key){
        String hql = " from Article a where a.title like ?";
        return  (List<Article>)hibernateTemplate.find(hql,"%"+key+"%");
    }

    public List<Article> queryArticleByPageAndText(int page, int perPage, String key){
        String hql = " from Article a where a.title like ? order by a.id asc";
        return (List<Article>)HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,(page-1)*perPage,perPage,key);
    }

    public List<Article> queryArticleByTextAndAuthor(String key, String name){
        String hql = " from Article a where a.title like ? and a.author like ?";
        return (List<Article>)hibernateTemplate.find(hql,"%"+key+"%",name);
    }

    public List<Article> queryArticleByPageAndTextAndAuthor(int page, int perPage, String key, String name){
        String hql = " from Article a where a.title like ? and author like ? order by a.id asc";
        return (List<Article>)HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,(page-1)*perPage,perPage,key,name);
    }

    public List<Article> queryRecentArticles(int number){
        String hql = " from Article a order by a.createTime desc ";
        return (List<Article>) HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,0,number);
    }

    public List<Article> queryRecentArticlesByAuthor(String name, int number){
        String hql = " from Article a where a.title like ? and a.author like ? order by a.createTime desc ";
        return (List<Article>) HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,0,number,"",name);
    }

    public int getTotalNumOfArticles(String name){
        String hql = " from Article a where a.author like ?";
        return ((List<Article>)hibernateTemplate.find(hql,name)).size();
    }

    public Article queryArticleById(Long id){
        return hibernateTemplate.get(Article.class,id);
    }

    public void addClickCount(Long id){
        Article article = hibernateTemplate.get(Article.class,id);
        article.setClickCount(article.getClickCount()+1);
        hibernateTemplate.update(article);
    }

    public List<Comment> queryCommentForArticle(Article article){
        return article.getComments();
    }

    public Set<SimpleUser> querySimpleByArticle(Article article){
        return article.getCollectors();
    }
}
