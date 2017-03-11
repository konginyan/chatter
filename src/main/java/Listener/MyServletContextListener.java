package Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashSet;

public class MyServletContextListener implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("visitorCount",0);
        context.setAttribute("onlineUserList", new HashSet<String>());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
