package admin.action;

import Service.AdminService;
import entity.AdminUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@Scope("prototype")
public class AdminLoginAction extends ActionSupport{
    @Autowired
    private AdminService adminService;

    private AdminUser adminUser;

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        if(null != adminUser){
            if(adminService.checkAdminUserLogin(adminUser.getUsername(),adminUser.getPassword())){
                session.put("username",adminUser.getUsername());
                return SUCCESS;
            }
            else {
                actionContext.put("errorMessage","用户名或密码错误");
                actionContext.put("user",adminUser.getUsername());
                return ERROR;
            }
        }
        else {
            return ERROR;
        }
    }
}
