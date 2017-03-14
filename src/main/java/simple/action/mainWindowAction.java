package simple.action;

import Service.ArticleService;
import Service.FileService;
import Service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Article;
import entity.FileResource;
import entity.NoticeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class mainWindowAction extends ActionSupport{
    @Autowired
    NoticeService noticeService;
    @Autowired
    FileService fileService;
    @Autowired
    ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @Override
    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        List<NoticeResource> recentNotice = noticeService.getRecentNotice(6);
        List<FileResource> recentFile = fileService.getRecentFiles(6);
        List<Article> recentArticle = articleService.getRecentArticles(6);
        actionContext.put("recentNotice",recentNotice);
        actionContext.put("recentFile",recentFile);
        actionContext.put("recentArticle",recentArticle);
        return SUCCESS;
    }
}
