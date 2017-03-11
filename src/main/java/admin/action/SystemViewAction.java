package admin.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.util.HashSet;

public class SystemViewAction extends ActionSupport{
    @Override
    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        ServletContext context = ServletActionContext.getServletContext();
        HashSet<String> set = (HashSet<String>)context.getAttribute("onlineUserList");
        actionContext.put("onlineUserCount",set.size());
        return SUCCESS;
    }
}
