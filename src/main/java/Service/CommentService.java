package Service;

import Dao.CommentDao;
import entity.Article;
import entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentDao commentDao;

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public void createComment(Comment comment){
        commentDao.createComment(comment);
    }

    public void deleteComment(Long id){
        commentDao.deleteComment(id);
    }
}
