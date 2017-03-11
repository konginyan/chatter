package Service;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieService {
    private HttpServletResponse response;

    public void setCookie(Cookie cookie){
        response = ServletActionContext.getResponse();
        response.addCookie(cookie);
    }

    public void removeCookie(String key){
        Cookie cookie = new Cookie(key,"");
        cookie.setMaxAge(0);
        response = ServletActionContext.getResponse();
        response.addCookie(cookie);
    }
}
