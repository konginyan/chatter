package Listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

public class MySessionListener implements HttpSessionListener{

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext context = session.getServletContext();
        context.setAttribute("visitorCount",(Integer)context.getAttribute("visitorCount")+1);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext context = session.getServletContext();
        context.setAttribute("visitorCount",(Integer)context.getAttribute("visitorCount")-1);
        HashSet<String> set = (HashSet<String>)context.getAttribute("onlineUserList");
        set.remove(session.getAttribute("account").toString());
    }
}
