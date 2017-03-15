package Service;

import Dao.NoticeDao;
import entity.NoticeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    public void setNoticeDao(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    public void postNotice(NoticeResource noticeResource){
        noticeDao.createNotice(noticeResource);
    }

    public void deleteNotice(Long id){
        noticeDao.deleteNotice(id);
    }

    public List<NoticeResource> getRecentNotice(int number){
        return noticeDao.queryRecentNotices(number);
    }

    public NoticeResource getNoticeById(Long id){
        return noticeDao.queryNoticeById(id);
    }

    public List<NoticeResource> queryNoticeContainTitle(String key){
        return noticeDao.queryNoticeContainTitle(key);
    }

    public List<NoticeResource> queryNoticeByPageContainTitle(int page, int perPage, String key){
        return noticeDao.queryNoticeByPageContainTitle(page, perPage, key);
    }

    public void addClickCount(Long id){
        noticeDao.addClickCount(id);
    }
}
