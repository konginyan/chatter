package simple.action;

import Service.SessionService;
import Service.SimpleService;
import com.opensymphony.xwork2.ActionSupport;
import entity.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Scope("prototype")
public class registerAction extends ActionSupport{
    SimpleUser simpleUser;
    String responseUrl;

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

    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public SimpleUser getSimpleUser() {
        return simpleUser;
    }

    public void setSimpleUser(SimpleUser simpleUser) {
        this.simpleUser = simpleUser;
    }

    @Override
    public String execute() throws Exception {
        SimpleUser newUser = new SimpleUser(simpleUser.getUsername(),simpleUser.getPassword(),new Date());
        simpleService.createSimpleUser(newUser);
        sessionService.setSession("account",simpleUser.getUsername());
        return SUCCESS;
    }
}
