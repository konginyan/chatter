package simple.action;

import Service.ArticleService;
import Service.CommentService;
import Service.SessionService;
import Service.ajaxResponse;
import com.opensymphony.xwork2.ActionSupport;
import entity.Article;
import entity.Comment;
import entity.SimpleUser;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@Scope("prototype")
public class CommentAction extends ActionSupport{
    @Autowired
    private CommentService commentService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public String makeComment() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        String aid = request.getParameter("articleId");
        String content = request.getParameter("content");
        String author = sessionService.getSessionValue(SimpleUser.NAME_IN_SESSION).toString();
        Article article = articleService.queryArticleById(Long.parseLong(aid));
        Comment comment = new Comment(author,content,new Date(),article);
        commentService.createComment(comment);
        ajaxResponse.ajaxResponseText("评论成功");
        return null;
    }

    public String deleteComment() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        commentService.deleteComment(Long.parseLong(id));
        ajaxResponse.ajaxResponseText("删除成功");
        return null;
    }
}
