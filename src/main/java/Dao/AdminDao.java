package Dao;

import Util.HibernateTemplateExtend;
import entity.AdminUser;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AdminDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public AdminDao() {

    }

    public void createAdmin(AdminUser adminUser){
        hibernateTemplate.save(adminUser);
    }

    public void deleteAdmin(Long id){
        AdminUser adminUser = hibernateTemplate.get(AdminUser.class,id);
        hibernateTemplate.delete(adminUser);
    }

    public List<AdminUser> queryAdminByText(String key){
        String hql = " from AdminUser a where a.username like ?";
        return  (List<AdminUser>)hibernateTemplate.find(hql,"%"+key+"%");
    }

    public List<AdminUser> queryAdminByPageAndText(int page, int perPage, String key){
        String hql = " from AdminUser a where a.username like ? order by a.id asc";
        return (List<AdminUser>)HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,(page-1)*perPage,perPage,key);
    }

    public AdminUser queryAdminByName(String name){
        String hql = " from AdminUser a where a.username like ?";
        List<AdminUser> objectList = (List<AdminUser>)hibernateTemplate.find(hql,name);
        if(objectList.size()>0) return objectList.get(0);
        else return null;
    }

    public boolean updateAdminByPassword(Long id, String password){
        AdminUser adminUser = hibernateTemplate.get(AdminUser.class,id);
        if(adminUser != null){
            adminUser.setPassword(password);
            hibernateTemplate.update(adminUser);
            return true;
        }
        else return false;
    }
}
