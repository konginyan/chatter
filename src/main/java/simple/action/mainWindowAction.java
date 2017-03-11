package simple.action;

import Service.FileService;
import Service.NoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.FileResource;
import entity.NoticeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class mainWindowAction extends ActionSupport{
    @Autowired
    NoticeService noticeService;
    @Autowired
    FileService fileService;

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
        actionContext.put("recentNotice",recentNotice);
        actionContext.put("recentFile",recentFile);
        return SUCCESS;
    }
}
