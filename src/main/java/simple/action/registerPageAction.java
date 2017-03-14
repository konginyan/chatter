package simple.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class registerPageAction extends ActionSupport{
    String requestUrl;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
    @Override
    public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        actionContext.put("requestUrl",requestUrl);
        return SUCCESS;
    }
}
