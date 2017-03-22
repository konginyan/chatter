package simple.action;

import Service.ArticleService;
import Service.SessionService;
import Service.ajaxResponse;
import entity.Article;
import entity.Attachment;
import entity.FileResource;
import entity.SimpleUser;
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
public class articleOpAction {
    @Autowired
    ArticleService articleService;
    @Autowired
    SessionService sessionService;

    private String articleId;

    private File file; // 上传的文件
    private String fileContentType;// 文件的类型
    private String fileFileName;// 文件的名称
    private String articleTitle;
    private String articleContent;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public String getRealPath(String savePath) {
        ServletContext context = ServletActionContext.getServletContext();
        return context.getRealPath(savePath);
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

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String postArticle() throws Exception{
        Article article;
        String author = sessionService.getSessionValue(SimpleUser.NAME_IN_SESSION).toString();
        if(file != null){
            String path = getRealPath(FileResource.defaultSavePath);
            File destDir = new File(path+'/'+author);
            if(!destDir.exists()){
                destDir.mkdir();
            }
            File destFile = new File(path+'/'+author, fileFileName);
            destFile.createNewFile();
            FileUtils.copyFile(file, destFile);
            Attachment attachment = new Attachment(fileFileName,fileContentType,path+'/'+author);
            article = new Article(articleTitle,author,articleContent,new Date(),attachment);
        }
        else {
            article = new Article(articleTitle,author,articleContent,new Date(),null);
        }
        articleService.postArticle(article);
        ajaxResponse.ajaxResponseText("post success <a href='index'>back to index</a>");
        return null;
    }

    public String deleteArticle() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
        Long id = Long.parseLong(request.getParameter("id"));
        Article article = articleService.queryArticleById(id);
        String path = getRealPath(FileResource.defaultSavePath);
        if(article.getAttachment()!=null){
            File destFile = new File(article.getAttachment().getPath()+"/"+article.getAttachment().getFileName());
            if (destFile.exists()){
                destFile.delete();
            }
        }
        articleService.deleteArticle(id);
        ajaxResponse.ajaxResponseText("success");
        return null;
    }

    public String downloadFile() throws Exception{
        return SUCCESS;
    }

    private InputStream inputStream;
    private String downloadFileName;

    public InputStream getInputStream() throws Exception{
        Article article = articleService.queryArticleById(Long.parseLong(articleId));
        String fileName = article.getAttachment().getFileName();
        String author = article.getAuthor();
        return ServletActionContext.getServletContext().getResourceAsStream("file/"+author+"/"+fileName);
    }

    public String getDownloadFileName() throws Exception{
        Article article = articleService.queryArticleById(Long.parseLong(articleId));
        String fileName = article.getAttachment().getFileName();
        return new String(fileName.getBytes("utf-8"), "ISO8859-1");
    }
}
