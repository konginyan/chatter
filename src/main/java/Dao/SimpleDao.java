package Dao;

import Util.HibernateTemplateExtend;
import entity.Article;
import entity.SimpleUser;
import entity.UserSetting;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

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

    public List<SimpleUser> querySimpleByText(String key){
        String hql = " from SimpleUser a where a.username like ?";
        return  (List<SimpleUser>)hibernateTemplate.find(hql,"%"+key+"%");
    }

    public List<SimpleUser> querySimpleByPageAndText(int page, int perPage, String key){
        String hql = " from SimpleUser a where a.username like ? order by a.id asc";
        return (List<SimpleUser>)HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,(page-1)*perPage,perPage,key);
    }

    public SimpleUser querySimpleByName(String name){
        String hql = " from SimpleUser a where a.username like ?";
        List<SimpleUser> objectList = (List<SimpleUser>)hibernateTemplate.find(hql,name);
        if(objectList.size()>0) return objectList.get(0);
        else return null;
    }

    public SimpleUser querySimpleById(Long id){
        return hibernateTemplate.get(SimpleUser.class,id);
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

    public void collectArticle(Long id, Article article){
        SimpleUser simpleUser = hibernateTemplate.get(SimpleUser.class,id);
        Set<Article> collections = simpleUser.getCollections();
        if(setContainArticle(collections,article)){
            removeArticleFromSet(collections,article);
        }
        else collections.add(article);
    }

    public Set<Article> queryCollection(Long id){
        SimpleUser simpleUser = hibernateTemplate.get(SimpleUser.class,id);
        return simpleUser.getCollections();
    }

    public void follow(Long id, SimpleUser follow){
        SimpleUser simpleUser = hibernateTemplate.get(SimpleUser.class,id);
        Set<SimpleUser> follows = simpleUser.getFollows();
        if(setContainSimple(follows,follow)){
            removeSimpleFromSet(follows,follow);
        }
        else {
            follows.add(follow);
        }
    }

    public Set<SimpleUser> queryFollows(Long id){
        SimpleUser simpleUser = hibernateTemplate.get(SimpleUser.class,id);
        return simpleUser.getFollows();
    }

    public void changeSetting(Long id, boolean personal, boolean article, boolean collection, boolean follow){
        SimpleUser simpleUser = hibernateTemplate.get(SimpleUser.class,id);
        UserSetting setting = simpleUser.getUserSetting();
        setting.setOpenPersonal(personal);
        setting.setOpenArticle(article);
        setting.setOpenCollection(collection);
        setting.setOpenFollow(follow);
        hibernateTemplate.update(simpleUser);
    }

    public boolean setContainArticle(Set<Article> set, Article article) {
        for(Article a:set){
            if(a.getId().equals(article.getId())){
                return true;
            }
        }
        return false;
    }

    public boolean setContainSimple(Set<SimpleUser> set, SimpleUser simpleUser) {
        for(SimpleUser a:set){
            if(a.getId().equals(simpleUser.getId())){
                return true;
            }
        }
        return false;
    }

    private void removeArticleFromSet(Set<Article> set, Article article){
        for(Article a:set){
            if(a.getId().equals(article.getId())){
                set.remove(a);
            }
        }
    }

    private void removeSimpleFromSet(Set<SimpleUser> set, SimpleUser simpleUser){
        for(SimpleUser a:set){
            if(a.getId().equals(simpleUser.getId())){
                set.remove(a);
            }
        }
    }

    public void addFollowerCount(SimpleUser follow){
        follow.setFollowerCount(follow.getFollowerCount()+1);
        hibernateTemplate.update(follow);
    }

    public void decendFollowerCount(SimpleUser follow){
        follow.setFollowerCount(follow.getFollowerCount()-1);
        hibernateTemplate.update(follow);
    }

    public boolean updateSimpleByPassword(Long id, String oldPassword, String newPassword){
        SimpleUser simpleUser = hibernateTemplate.get(SimpleUser.class,id);
        if(simpleUser != null){
            if(simpleUser.getPassword().equals(oldPassword)){
                simpleUser.setPassword(newPassword);
                hibernateTemplate.update(simpleUser);
                return true;
            }
        }
        return false;
    }
}
