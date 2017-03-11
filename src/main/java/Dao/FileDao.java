package Dao;

import Util.HibernateTemplateExtend;
import entity.FileResource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class FileDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public FileDao(){

    }

    public void uploadFile(FileResource fileResource){
        hibernateTemplate.save(fileResource);
    }

    public void deleteFile(Long id){
        FileResource fileResource = new FileResource();
        fileResource.setId(id);
        hibernateTemplate.delete(fileResource);
    }

    public List<FileResource> queryFileContainName(String key){
        String hql = " from FileResource a where a.fileName like ?";
        return  (List<FileResource>)hibernateTemplate.find(hql,"%"+key+"%");
    }

    public List<FileResource> queryFileByType(String key){
        String hql = " from FileResource a where a.type like ?";
        return  (List<FileResource>)hibernateTemplate.find(hql,key);
    }

    public List<FileResource> queryFileByPageContainName(int page, String key){
        String hql = " from FileResource a where a.fileName like ? order by a.id asc";
        return (List<FileResource>) HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,(page-1)*10,10,key);
    }

    public FileResource queryFileById(Long id){
        return hibernateTemplate.get(FileResource.class,id);
    }

    public void addDownloadCount(Long id){
        FileResource fileResource = hibernateTemplate.get(FileResource.class,id);
        fileResource.setDownloadCount(fileResource.getDownloadCount()+1);
        hibernateTemplate.update(fileResource);
    }

    public List<FileResource> queryRecentFiles(int number){
        String hql = " from FileResource a order by a.uploadTime desc ";
        return (List<FileResource>) HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,0,number);
    }
}
