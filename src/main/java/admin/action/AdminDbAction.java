package admin.action;

import Service.*;
import com.opensymphony.xwork2.ActionSupport;
import entity.AdminUser;
import entity.NoticeResource;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static Service.ajaxResponse.ajaxResponseText;

@Component
@Scope("prototype")
public class AdminDbAction extends ActionSupport{
    @Autowired
    AdminService adminService;
    @Autowired
    SessionService sessionService;
    @Autowired
    NoticeService noticeService;
    @Autowired
    SimpleService simpleService;

    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String createAdmin() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminUser user = new AdminUser(username,password,new Date());
        adminService.createAdminUser(user);
        ajaxResponseText("Success");
        return null;
    }

    public String deleteAdmin() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        Long id = Long.parseLong(request.getParameter("id"));
        adminService.deleteAdminUser(id);
        ajaxResponseText("Success");
        return null;
    }

    public String checkAdmin() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        if(key == null || key.equals(""))ajaxResponseText("exist");
        else {
            if(adminService.checkAdminUserExist(key)) ajaxResponseText("exist");
            else ajaxResponseText("clear");
        }
        return null;
    }

    public String changePassword() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        Long id = Long.parseLong(request.getParameter("id"));
        String password = request.getParameter("password");
        if(adminService.updateAdminByPassword(id,password)){
            ajaxResponseText("Success");
        }
        else ajaxResponseText("Fail");
        return null;
    }

    public String postNotice() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = sessionService.getSessionValue("username").toString();
        NoticeResource noticeResource = new NoticeResource(title,author,content,new Date());
        noticeService.postNotice(noticeResource);
        return null;
    }

    public String deleteNotice() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        Long id = Long.parseLong(request.getParameter("id"));
        noticeService.deleteNotice(id);
        ajaxResponseText("Success");
        return null;
    }

    public String forbidSimple() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        Long id = Long.parseLong(request.getParameter("id"));
        simpleService.forbidSimpleUser(id);
        ajaxResponseText("Success");
        return null;
    }
}
