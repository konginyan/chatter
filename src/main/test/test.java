import entity.AdminUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Field;
import java.util.Date;

public class test{

    public test(){
    }

    static public void main(String args[]){
        String a = "a ? b ? c";
        String[] b = {"fff","ddd"};
        for (String c:b){
            a = a.replaceFirst("\\?",c);
        }
        System.out.println(a);
    }
}
