package admin.action;

import Service.FileService;
import Service.SessionService;
import Service.ajaxResponse;
import entity.AdminUser;
import entity.FileResource;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.Date;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller
@Scope("prototype")
public class fileDbAction {
    String fileId;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Autowired
    FileService fileService;
    @Autowired
    SessionService sessionService;
    private File file; // 上传的文件
    private String fileContentType;// 文件的类型
    private String fileFileName;// 文件的名称
    private String description;// 文件描述

    //获得当前web应用所在目录下file文件夹的绝对路径
    public String getRealPath(String savePath) {
        ServletContext context = ServletActionContext.getServletContext();
        return context.getRealPath(savePath);
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String uploadFile() throws Exception{
        String path = getRealPath(FileResource.defaultSavePath);
        File destFile = new File(path, fileFileName);
        if (!destFile.exists()) {
            destFile.createNewFile();
            FileUtils.copyFile(file, destFile);
            FileResource fileResource = new FileResource(fileFileName,fileContentType,path,description,
                    sessionService.getSessionValue(AdminUser.NAME_IN_SESSION).toString(),new Date());
            fileService.uploadFile(fileResource);
            ajaxResponse.ajaxResponseText("upload success <a href='main'>back to main</a>");
        }
        else ajaxResponse.ajaxResponseText("the file already exist, upload fail <a href='main'>back to main</a>");
        return null;
    }

    public String deleteFile() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        Long id = Long.parseLong(request.getParameter("id"));
        FileResource fileResource = fileService.queryFileById(id);
        String path = getRealPath(FileResource.defaultSavePath);
        File destFile = new File(path+'/'+fileResource.getFileName());
        if (destFile.exists()){
            destFile.delete();
            fileService.deleteFile(id);
            ajaxResponse.ajaxResponseText("success");
        }
        else {
            fileService.deleteFile(id);
            ajaxResponse.ajaxResponseText("the file isn't exist");
        }
        return null;
    }

    public String downloadFile() throws Exception{
        return SUCCESS;
    }

    private InputStream inputStream;
    private String downloadFileName;

    public InputStream getInputStream() throws Exception{
        FileResource fileResource = fileService.queryFileById(Long.parseLong(fileId));
        fileService.addDownloadCount(Long.parseLong(fileId));
        String fileName = fileResource.getFileName();
        return ServletActionContext.getServletContext().getResourceAsStream("file/"+fileName);
    }

    public String getDownloadFileName() throws Exception{
        FileResource fileResource = fileService.queryFileById(Long.parseLong(fileId));
        String fileName = fileResource.getFileName();
        return new String(fileName.getBytes("utf-8"), "ISO8859-1");
    }
}
