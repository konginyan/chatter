package Service;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SessionService {
    private Map session;

    public void setSession(String key, Object value){
        ActionContext actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.put(key,value);
    }

    public void removeSession(String key){
        ActionContext actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        session.remove(key);
    }

    public Object getSessionValue(String key){
        ActionContext actionContext = ActionContext.getContext();
        session = actionContext.getSession();
        return session.get(key);
    }
}
