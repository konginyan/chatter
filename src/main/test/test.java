import entity.AdminUser;
import entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class test{

    public test(){
    }

    static public void main(String args[]){
        Set<Article> set = new HashSet<Article>();
        Article article = new Article();
        Long i = new Long(1);
        article.setId(i);
        set.add(article);
        System.out.println(set.contains(article));
    }
}
