package simple.action;

import Service.ArticleService;
import Service.NoticeService;
import Service.SessionService;
import Service.SimpleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Article;
import entity.Comment;
import entity.NoticeResource;
import entity.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class ReadAction extends ActionSupport{
    String id;
    String SimpleUsername;
    @Autowired
    NoticeService noticeService;
    @Autowired
    ArticleService articleService;
    @Autowired
    SessionService sessionService;
    @Autowired
    SimpleService simpleService;

    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

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

    public String getSimpleUsername() {
        return SimpleUsername;
    }

    public void setSimpleUsername(String simpleUsername) {
        SimpleUsername = simpleUsername;
    }

    public String Notice() throws Exception {
        checkCookie();
        NoticeResource noticeResource = noticeService.getNoticeById(Long.parseLong(id));
        noticeService.addClickCount(Long.parseLong(id));
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("id",noticeResource.getId());
        actionContext.put("title",noticeResource.getTitle());
        actionContext.put("time",noticeResource.getCreateTime());
        actionContext.put("content",noticeResource.getNotice());
        return "Notice";
    }

    public String Article() throws Exception {
        checkCookie();
        Article article = articleService.queryArticleById(Long.parseLong(id));
        articleService.addClickCount(Long.parseLong(id));
        List<Comment> comments = article.getComments();
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("article",article);
        actionContext.put("comments",comments);
        if(sessionService.getSessionValue(SimpleUser.NAME_IN_SESSION) != null) {
            String name = sessionService.getSessionValue(SimpleUser.NAME_IN_SESSION).toString();
            SimpleUser user = simpleService.querySimpleByName(name);
            if(simpleService.setContainArticle(user.getCollections(),article)) actionContext.put("collected",true);
            else actionContext.put("collected",false);
        }
        return "Article";
    }

    private void checkCookie(){
        if(SimpleUsername != null){
            if(simpleService.checkSimpleUserExist(SimpleUsername)){
                sessionService.setSession("account",SimpleUsername);
            }
        }
    }
}
