package Service;

import Dao.FileDao;
import entity.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FileService {
    @Autowired
    FileDao fileDao;

    public void setFileDao(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    public void uploadFile(FileResource fileResource){
        fileDao.uploadFile(fileResource);
    }

    public List<FileResource> queryFileByPageContainName(int page, int perPage, String key){
        return fileDao.queryFileByPageContainName(page,perPage,key);
    }

    public List<FileResource> queryFileContainName(String key){
        return fileDao.queryFileContainName(key);
    }

    public void deleteFile(Long id){
        fileDao.deleteFile(id);
    }

    public FileResource queryFileById(Long id){
        return fileDao.queryFileById(id);
    }

    public void addDownloadCount(Long id){
        fileDao.addDownloadCount(id);
    }

    public List<FileResource> getRecentFiles(int number){
        return fileDao.queryRecentFiles(number);
    }
}
