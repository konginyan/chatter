package simple.action;

import Service.CookieService;
import Service.SessionService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class logoutAction extends ActionSupport{
    String responseUrl;
    @Autowired
    CookieService cookieService;
    @Autowired
    SessionService sessionService;

    public void setCookieService(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public String getResponseUrl() {
        if(responseUrl!=null) return responseUrl;
        else return "index";
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    @Override
    public String execute() throws Exception {
        sessionService.setSession("accountRemove",sessionService.getSessionValue("account"));
        sessionService.removeSession("account");
        cookieService.removeCookie("SimpleUsername");
        return SUCCESS;
    }
}
