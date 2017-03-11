package simple.action;

import Service.CookieService;
import Service.SessionService;
import Service.SimpleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.SimpleUser;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;

@Component
@Scope("prototype")
public class loginAction extends ActionSupport{
    SimpleUser simpleUser;
    String autoLogin;
    @Autowired
    CookieService cookieService;
    @Autowired
    SimpleService simpleService;
    @Autowired
    SessionService sessionService;

    public void setCookieService(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public String getAutoLogin() {
        return autoLogin;
    }

    public void setAutoLogin(String autoLogin) {
        this.autoLogin = autoLogin;
    }

    public SimpleUser getSimpleUser() {
        return simpleUser;
    }

    public void setSimpleUser(SimpleUser simpleUser) {
        this.simpleUser = simpleUser;
    }

    @Override
    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        ServletContext context = ServletActionContext.getServletContext();
        if(simpleService.checkSimpleUserLogin(simpleUser.getUsername(),simpleUser.getPassword())){
            if(simpleService.isForbidden(simpleUser.getUsername())){
                actionContext.put("errorMessage","该帐号已经被封禁");
                actionContext.put("user",simpleUser.getUsername());
                return ERROR;
            }
            if(autoLogin != null){
                Cookie cookie = new Cookie("SimpleUsername",simpleUser.getUsername());
                cookie.setMaxAge(60*60*24*7);
                cookieService.setCookie(cookie);
            }
            sessionService.setSession("account",simpleUser.getUsername());
            return SUCCESS;
        }
        else {
            actionContext.put("errorMessage","用户名或密码错误");
            actionContext.put("user",simpleUser.getUsername());
            return ERROR;
        }
    }
}
