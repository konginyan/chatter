package simple.action;

import Service.SessionService;
import Service.SimpleService;
import com.opensymphony.xwork2.ActionSupport;
import entity.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
public class registerAction extends ActionSupport{
    SimpleUser simpleUser;

    @Autowired
    SimpleService simpleService;

    @Autowired
    SessionService sessionService;

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
        simpleUser.setCreateDate(new Date());
        simpleService.createSimpleUser(simpleUser);
        sessionService.setSession("account",simpleUser.getUsername());
        return SUCCESS;
    }
}
