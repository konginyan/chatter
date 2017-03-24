package Service;

import Dao.SimpleDao;
import entity.Article;
import entity.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class SimpleService {
    @Autowired
    private SimpleDao simpleDao;

    public void setSimpleDao(SimpleDao simpleDao) {
        this.simpleDao = simpleDao;
    }

    public void createSimpleUser(SimpleUser user){
        simpleDao.createSimple(user);
    }

    public boolean checkSimpleUserLogin(String username, String password){
        SimpleUser simpleUser = simpleDao.querySimpleByName(username);
        if(simpleUser == null) return false;
        String realPass = simpleUser.getPassword();
        if(password.equals(realPass)) return true;
        else return false;
    }

    public boolean checkSimpleUserExist(String username){
        SimpleUser simpleUser = simpleDao.querySimpleByName(username);
        if(simpleUser == null) return false;
        else return true;
    }

    public List<SimpleUser> querySimpleByText(String key){
        return simpleDao.querySimpleByText(key);
    }

    public List<SimpleUser> querySimpleByPageAndText(int page, int perPage, String key){
        return simpleDao.querySimpleByPageAndText(page, perPage, key);
    }

    public SimpleUser querySimpleByName(String name){
        return simpleDao.querySimpleByName(name);
    }

    public SimpleUser querySimpleById(Long id){
        return simpleDao.querySimpleById(id);
    }

    public void forbidSimpleUser(Long id){
        simpleDao.forbidOrReleaseSimpleUser(id);
    }

    public boolean isForbidden(String name){
        return simpleDao.isForbidden(name);
    }

    public void collectArticle(Long id, Article article){
        simpleDao.collectArticle(id, article);
    }

    public Set<Article> queryCollection(Long id){
        return simpleDao.queryCollection(id);
    }

    public void follow(Long id, SimpleUser follow){
        simpleDao.follow(id, follow);
    }

    public Set<SimpleUser> queryFollows(Long id){
        return simpleDao.queryFollows(id);
    }

    public void changeSetting(Long id, boolean personal, boolean article, boolean collection, boolean follow){
        simpleDao.changeSetting(id, personal, article, collection, follow);
    }

    public boolean setContainArticle(Set<Article> set, Article article){
        return simpleDao.setContainArticle(set, article);
    }

    public boolean setContainSimple(Set<SimpleUser> set, SimpleUser simpleUser){
        return simpleDao.setContainSimple(set,simpleUser);
    }

    public void addFollowerCount(SimpleUser follow){
        simpleDao.addFollowerCount(follow);
    }

    public void decendFollowerCount(SimpleUser follow){
        simpleDao.decendFollowerCount(follow);
    }

    public boolean updateSimpleByPassword(Long id, String oldPassword, String newPassword){
        return simpleDao.updateSimpleByPassword(id, oldPassword, newPassword);
    }
}
