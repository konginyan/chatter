package admin.action;

import Service.AdminService;
import Service.FileService;
import Service.NoticeService;
import Service.SimpleService;
import entity.AdminUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.FileResource;
import entity.NoticeResource;
import entity.SimpleUser;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Scope("prototype")
public class tableAction extends ActionSupport{
    @Autowired
    AdminService adminService;
    @Autowired
    SimpleService simpleService;
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

    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String adminTable(){
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));
        List<AdminUser> objectList = adminService.queryAdminByPageAndText(page+1,10,key);
        //得到总页数
        List<AdminUser> totalList = adminService.queryAdminByText(key);
        actionContext.put("adminTotalRecord",totalList.size());
        actionContext.put("adminUserList",objectList);
        actionContext.put("adminCurrentPage",page);

        return "admin";
    }

    public String simpleTable(){
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));
        List<SimpleUser> objectList = simpleService.querySimpleByPageAndText(page+1,10,key);
        //得到总页数
        List<SimpleUser> totalList = simpleService.querySimpleByText(key);
        actionContext.put("simpleTotalRecord",totalList.size());
        actionContext.put("simpleUserList",objectList);
        actionContext.put("simpleCurrentPage",page);
        return "simple";
    }

    public String noticeTable(){
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));
        List<NoticeResource> objectList = noticeService.queryNoticeByPageContainTitle(page+1,10,key);
        //得到总页数
        List<NoticeResource> totalList = noticeService.queryNoticeContainTitle(key);
        actionContext.put("noticeTotalRecord",totalList.size());
        actionContext.put("noticeList",objectList);
        actionContext.put("noticeCurrentPage",page);
        return "notice";
    }

    public String fileTable(){
        ActionContext actionContext = ActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        int page = Integer.parseInt(request.getParameter("page"));
        List<FileResource> objectList = fileService.queryFileByPageContainName(page+1,10,key);
        //得到总页数
        List<FileResource> totalList = fileService.queryFileContainName(key);
        actionContext.put("fileTotalRecord",totalList.size());
        actionContext.put("fileList",objectList);
        actionContext.put("fileCurrentPage",page);
        return "file";
    }
}
