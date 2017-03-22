package simple.action;

import Service.CookieService;
import Service.SessionService;
import Service.SimpleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Cookie;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport{
    SimpleUser simpleUser;
    String autoLogin;
    String responseUrl;
    @Autowired
    CookieService cookieService;
    @Autowired
    SimpleService simpleService;
    @Autowired
    SessionService sessionService;

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

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
