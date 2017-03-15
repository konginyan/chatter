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
}
