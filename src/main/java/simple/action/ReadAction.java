package simple.action;

import Service.ArticleService;
import Service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Article;
import entity.Comment;
import entity.NoticeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class ReadAction extends ActionSupport{
    String id;
    @Autowired
    NoticeService noticeService;
    @Autowired
    ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String Notice() throws Exception {
        NoticeResource noticeResource = noticeService.getNoticeById(Long.parseLong(id));
        noticeService.addClickCount(Long.parseLong(id));
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("title",noticeResource.getTitle());
        actionContext.put("time",noticeResource.getCreateTime());
        actionContext.put("content",noticeResource.getNotice());
        return "Notice";
    }

    public String Article() throws Exception {
        Article article = articleService.queryArticleById(Long.parseLong(id));
        articleService.addClickCount(Long.parseLong(id));
        List<Comment> comments = article.getComments();
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("article",article);
        actionContext.put("comments",comments);
        return "Article";
    }
}
