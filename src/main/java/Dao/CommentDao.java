package Dao;

import entity.Article;
import entity.Comment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CommentDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void createComment(Comment comment){
        hibernateTemplate.save(comment);
    }

    public void deleteComment(Long id){
        Comment comment = hibernateTemplate.get(Comment.class,id);
        hibernateTemplate.delete(comment);
    }

    public List<Comment> queryCommentByArticle(Article article){
        String hql = " from Comment a where a.article.id = ? order by createTime asc";
        return  (List<Comment>)hibernateTemplate.find(hql,article.getId());
    }

    public List<Comment> queryCommentByAuthor(String name){
        String hql = " from Comment a where a.author like ? order by createTime desc ";
        return  (List<Comment>)hibernateTemplate.find(hql,name);
    }
}
