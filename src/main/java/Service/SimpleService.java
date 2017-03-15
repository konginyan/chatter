package Service;

import Dao.SimpleDao;
import entity.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public void forbidSimpleUser(Long id){
        simpleDao.forbidOrReleaseSimpleUser(id);
    }

    public boolean isForbidden(String name){
        return simpleDao.isForbidden(name);
    }
}
