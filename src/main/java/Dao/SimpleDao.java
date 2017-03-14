package Dao;

import Util.HibernateTemplateExtend;
import entity.SimpleUser;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SimpleDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void createSimple(SimpleUser simpleUser){
        hibernateTemplate.save(simpleUser);
    }

    public List<SimpleUser> queryAllSimple(){
        String hql = " from SimpleUser ";
        return (List<SimpleUser>)hibernateTemplate.find(hql);
    }

    public List<SimpleUser> querySimpleByText(String key){
        String hql = " from SimpleUser a where a.username like ?";
        return  (List<SimpleUser>)hibernateTemplate.find(hql,"%"+key+"%");
    }

    public List<SimpleUser> querySimpleByPage(int page){
        String hql = " from SimpleUser ";
        return (List<SimpleUser>) HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,(page-1)*10,10);
    }

    public List<SimpleUser> querySimpleByPageAndText(int page, String key){
        String hql = " from SimpleUser a where a.username like ? order by a.id asc";
        return (List<SimpleUser>)HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,(page-1)*10,10,key);
    }

    public SimpleUser querySimpleByName(String name){
        String hql = " from SimpleUser a where a.username like ?";
        List<SimpleUser> objectList = (List<SimpleUser>)hibernateTemplate.find(hql,name);
        if(objectList.size()>0) return objectList.get(0);
        else return null;
    }

    public void forbidOrReleaseSimpleUser(Long id){
        SimpleUser simpleUser = hibernateTemplate.get(SimpleUser.class,id);
        if(simpleUser.getStatus()==SimpleUser.NORMAL) simpleUser.setStatus(SimpleUser.FORBID);
        else simpleUser.setStatus(SimpleUser.NORMAL);
        hibernateTemplate.update(simpleUser);
    }

    public boolean isForbidden(String name){
        SimpleUser simpleUser = querySimpleByName(name);
        return simpleUser.getStatus()==SimpleUser.FORBID;
    }
}
