package Util;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;
import java.util.StringTokenizer;

public class HibernateTemplateExtend {

    public static List findByPage(HibernateTemplate hibernateTemplate, final String queryString, final int firstResult, final int maxResult){
        List list = hibernateTemplate.execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(queryString);
                query.setFirstResult(firstResult);
                query.setMaxResults(maxResult);
                return query.list();
            }
        });
        return list;
    }

    public static List findByPage(HibernateTemplate hibernateTemplate, final String queryString, final int firstResult, final int maxResult, final Object... values){
        List list = hibernateTemplate.execute(new HibernateCallback<List>() {
            public List doInHibernate(Session session) throws HibernateException {
                String qs = queryString;
                int i = 1;
                for(Object value:values){
                    if(i==2){
                        qs = qs.replaceFirst("\\?","'"+value.toString()+"'");
                    }
                    qs = qs.replaceFirst("\\?","'%"+value.toString()+"%'");
                    i++;
                }
                Query query = session.createQuery(qs);
                query.setFirstResult(firstResult);
                query.setMaxResults(maxResult);
                return query.list();
            }
        });
        return list;
    }
}
