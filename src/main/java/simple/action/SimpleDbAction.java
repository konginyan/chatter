package simple.action;

import Service.SimpleService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

import static Service.ajaxResponse.ajaxResponseText;

@Controller
@Scope("prototype")
public class SimpleDbAction extends ActionSupport{
    @Autowired
    SimpleService simpleService;

    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    public String checkSimple() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        String key = request.getParameter("key");
        if(key == null || key.equals(""))ajaxResponseText("exist");
        else {
            if(simpleService.checkSimpleUserExist(key)) ajaxResponseText("exist");
            else ajaxResponseText("clear");
        }
        return null;
    }
}
