package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class AdminUser implements Serializable{
    public final static String NAME_IN_SESSION = "username";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    Date createDate;

    public AdminUser(){

    }

    @Override
    public String toString() {
        return "id:"+getId()+"\nusername:"+getUsername();
    }

    public AdminUser(String username, String password, Date createDate) {
        this.username = username;
        this.password = password;
        this.createDate = createDate;
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
}
