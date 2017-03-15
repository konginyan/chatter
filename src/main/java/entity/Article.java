package entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    @Lob
    @Type(type = "text")
    private String content;
    private int clickCount;
    private Date createTime;

    @Embedded
    private Attachment attachment;

    @OneToMany(mappedBy = "article",fetch = FetchType.EAGER)
    private List<Comment> comments;

    public Article(){

    }

    public Article(String title, String author, String content, Date createTime, Attachment attachment) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.clickCount = 0;
        this.createTime = createTime;
        this.attachment = attachment;
        this.comments = new ArrayList<Comment>();
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content.replaceAll(" ","&nbsp;").replaceAll("\n","<br/>").replaceAll("\r","<br/>");
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
