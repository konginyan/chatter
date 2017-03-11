package Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashSet;

public class MySessionAttrListener implements HttpSessionAttributeListener{

    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        ServletContext context = session.getServletContext();
        HashSet<String> set = (HashSet<String>)context.getAttribute("onlineUserList");
        if (session.getAttribute("account")!=null)
            set.add(session.getAttribute("account").toString());
    }

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        ServletContext context = session.getServletContext();
        HashSet<String> set = (HashSet<String>)context.getAttribute("onlineUserList");
        if (session.getAttribute("accountRemove")!=null)
            set.remove(session.getAttribute("accountRemove").toString());
    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
