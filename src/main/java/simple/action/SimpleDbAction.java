package simple.action;

import Service.ArticleService;
import Service.SessionService;
import Service.SimpleService;
import Service.ajaxResponse;
import com.opensymphony.xwork2.ActionSupport;
import entity.Article;
import entity.SimpleUser;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import java.util.Set;

import static Service.ajaxResponse.ajaxResponseText;

@Controller
@Scope("prototype")
public class SimpleDbAction extends ActionSupport{
    @Autowired
    SimpleService simpleService;
    @Autowired
    ArticleService articleService;
    @Autowired
    SessionService sessionService;

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    public String checkSimple() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        if(key == null || key.equals(""))ajaxResponseText("exist");
        else {
            if(simpleService.checkSimpleUserExist(key)) ajaxResponseText("exist");
            else ajaxResponseText("clear");
        }
        return null;
    }

    public void collectArticle() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        Long articleId = Long.parseLong(request.getParameter("articleId"));
        Article article = articleService.queryArticleById(articleId);
        String name = sessionService.getSessionValue(SimpleUser.NAME_IN_SESSION).toString();
        SimpleUser user = simpleService.querySimpleByName(name);
        simpleService.collectArticle(user.getId(),article);
        ajaxResponse.ajaxResponseText("clear");
    }
}
