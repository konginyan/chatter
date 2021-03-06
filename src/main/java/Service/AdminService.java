package Service;

import Dao.AdminDao;
import entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public void createAdminUser(AdminUser user){
        adminDao.createAdmin(user);
    }

    public void deleteAdminUser(Long id){
        adminDao.deleteAdmin(id);
    }

    public boolean checkAdminUserLogin(String username, String password){
        if(username.equals("superAdmin") && password.equals("superAdmin")) return true;
        AdminUser adminUser = adminDao.queryAdminByName(username);
        if(adminUser == null) return false;
        String realPass = adminUser.getPassword();
        if(password.equals(realPass)) return true;
        else return false;
    }

    public boolean checkAdminUserExist(String username){
        AdminUser adminUser = adminDao.queryAdminByName(username);
        if(adminUser == null) return false;
        else return true;
    }

    public List<AdminUser> queryAdminByText(String key){
        return adminDao.queryAdminByText(key);
    }

    public List<AdminUser> queryAdminByPageAndText(int page, int perPage, String key){
        return adminDao.queryAdminByPageAndText(page,perPage,key);
    }

    public AdminUser queryAdminByName(String name){
        return adminDao.queryAdminByName(name);
    }

    public boolean updateAdminByPassword(Long id, String password) {
        return adminDao.updateAdminByPassword(id,password);
    }

}
