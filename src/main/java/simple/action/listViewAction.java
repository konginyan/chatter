package simple.action;

import Service.ArticleService;
import Service.FileService;
import Service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Article;
import entity.FileResource;
import entity.NoticeResource;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Scope("prototype")
public class listViewAction extends ActionSupport{
    @Autowired
    NoticeService noticeService;
    @Autowired
    FileService fileService;
    @Autowired
    ArticleService articleService;

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public String noticeList(){
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));
        List<NoticeResource> objectList = noticeService.queryNoticeByPageContainTitle(page+1,20,key);
        //得到总页数
        List<NoticeResource> totalList = noticeService.queryNoticeContainTitle(key);
        actionContext.put("TotalRecord",totalList.size());
        actionContext.put("List",objectList);
        actionContext.put("CurrentPage",page);
        actionContext.put("type","notice");
        actionContext.put("key",key);
        return SUCCESS;
    }

    public String fileList(){
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));
        List<FileResource> objectList = fileService.queryFileByPageContainName(page+1,20,key);
        //得到总页数
        List<FileResource> totalList = fileService.queryFileContainName(key);
        actionContext.put("TotalRecord",totalList.size());
        actionContext.put("List",objectList);
        actionContext.put("CurrentPage",page);
        actionContext.put("type","file");
        actionContext.put("key",key);
        return SUCCESS;
    }

    public String articleList(){
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));
        List<Article> objectList = articleService.queryArticleByPageAndText(page+1,20,key);
        //得到总页数
        List<Article> totalList = articleService.queryArticleByText(key);
        actionContext.put("TotalRecord",totalList.size());
        actionContext.put("List",objectList);
        actionContext.put("CurrentPage",page);
        actionContext.put("type","article");
        actionContext.put("key",key);
        return SUCCESS;
    }
}
