package admin.action;

import entity.AdminUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class loginAction extends ActionSupport{
    private AdminUser adminUser;

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    @Override
    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        if(null != adminUser){
            if(adminUser.getUsername().equals("admin")){
                session.put("username",adminUser.getUsername());
                return SUCCESS;
            }
            else {
                actionContext.put("errmsg","用户名或密码错误");
                actionContext.put("user",adminUser.getUsername());
                return ERROR;
            }
        }
        else {
            return ERROR;
        }
    }
}
