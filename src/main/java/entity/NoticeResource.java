package entity;

import org.hibernate.annotations.Type;
import org.hibernate.type.StringClobType;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

@Entity
public class NoticeResource implements Resource,Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String author;

    @Lob
    @Type(type = "text")
    String notice;
    int clickCount;
    Date createTime;

    public NoticeResource(String title, String author, String notice, Date createTime) {
        this.title = title;
        this.author = author;
        this.notice = notice;
        this.clickCount = 0;
        this.createTime = createTime;
    }

    public NoticeResource() {

    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotice() {
        return notice.replaceAll(" ","&nbsp;").replaceAll("\n","<br/>").replaceAll("\r","<br/>");
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
