package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SimpleUser implements Serializable{
    public static final String NAME_IN_SESSION = "account";
    public static final String NAME_IN_PAGE = "pageMaster";
    public static final int NORMAL = 0;
    public static final int FORBID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    Date createDate;
    int status;
    int followerCount;

    @Embedded
    UserSetting userSetting;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name="user_follow",joinColumns={@JoinColumn(name="u_id")},inverseJoinColumns={@JoinColumn(name="f_id")})
    Set<SimpleUser> follows;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name="user_collection",joinColumns={@JoinColumn(name="u_id")},inverseJoinColumns={@JoinColumn(name="c_id")})
    Set<Article> collections;

    public SimpleUser(){

    }

    public SimpleUser(String username, String password, Date createDate) {
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.status = NORMAL;
        this.follows = new HashSet<SimpleUser>();
        this.collections = new HashSet<Article>();
        this.userSetting = new UserSetting(true,true,true,true);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<SimpleUser> getFollows() {
        return follows;
    }

    public void setFollows(Set<SimpleUser> follows) {
        this.follows = follows;
    }

    public Set<Article> getCollections() {
        return collections;
    }

    public void setCollections(Set<Article> collections) {
        this.collections = collections;
    }

    public UserSetting getUserSetting() {
        return userSetting;
    }

    public void setUserSetting(UserSetting userSetting) {
        this.userSetting = userSetting;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }
}
