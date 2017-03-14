package simple.action;

import Service.ArticleService;
import Service.SessionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Article;
import entity.SimpleUser;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Scope("prototype")
public class myPageAction extends ActionSupport{
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

    public String Page(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String author = request.getParameter("pageMaster");
        sessionService.setSession(SimpleUser.NAME_IN_PAGE, author);
        return "Page";
    }

    public String Personal(){
        return "Personal";
    }

    public String Follow(){
        return "Follow";
    }

    public String Collection(){
        return "Collection";
    }

    public String Article(){
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));
        String author = sessionService.getSessionValue(SimpleUser.NAME_IN_PAGE).toString();
        List<Article> objectList = articleService.queryArticleByPageAndTextAndAuthor(page+1,key,author);
        //得到总页数
        List<Article> totalList = articleService.queryArticleByTextAndAuthor(key,author);
        actionContext.put("articleTotalRecord",totalList.size());
        actionContext.put("articleList",objectList);
        actionContext.put("articleCurrentPage",page);
        return "Article";
    }

    public String Comment(){
        return "Comment";
    }

    public String Setting(){
        return "Setting";
    }

    public String ArticleEdit(){
        return "ArticleEdit";
    }
}
