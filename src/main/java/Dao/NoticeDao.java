package Dao;

import Util.HibernateTemplateExtend;
import entity.NoticeResource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class NoticeDao {
    @Resource
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public NoticeDao() {

    }

    public void createNotice(NoticeResource noticeResource){
        hibernateTemplate.save(noticeResource);
    }

    public void deleteNotice(Long id){
        NoticeResource noticeResource = hibernateTemplate.get(NoticeResource.class,id);
        hibernateTemplate.delete(noticeResource);
    }

    public List<NoticeResource> queryNoticeContainTitle(String key){
        String hql = " from NoticeResource a where a.title like ?";
        return  (List<NoticeResource>)hibernateTemplate.find(hql,"%"+key+"%");
    }

    public List<NoticeResource> queryNoticeByPageContainTitle(int page, int perPage, String key){
        String hql = " from NoticeResource a where a.title like ? order by a.createTime desc";
        return (List<NoticeResource>) HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,(page-1)*perPage,perPage,key);
    }

    public NoticeResource queryNoticeById(Long id){
        return hibernateTemplate.get(NoticeResource.class,id);
    }

    public List<NoticeResource> queryRecentNotices(int number){
        String hql = " from NoticeResource a order by a.createTime desc ";
        return (List<NoticeResource>) HibernateTemplateExtend
                .findByPage(hibernateTemplate,hql,0,number);
    }

    public void addClickCount(Long id){
        NoticeResource noticeResource = hibernateTemplate.get(NoticeResource.class,id);
        noticeResource.setClickCount(noticeResource.getClickCount()+1);
        hibernateTemplate.update(noticeResource);
    }
}
