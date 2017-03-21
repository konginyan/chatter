package entity;

import javax.persistence.Embeddable;

@Embeddable
public class UserSetting {
    private boolean openPersonal;
    private boolean openArticle;
    private boolean openCollection;
    private boolean openFollow;

    public UserSetting() {

    }

    public UserSetting(boolean openPersonal, boolean openArticle, boolean openCollection, boolean openFollow) {
        this.openPersonal = openPersonal;
        this.openArticle = openArticle;
        this.openCollection = openCollection;
        this.openFollow = openFollow;
    }

    public boolean isOpenPersonal() {
        return openPersonal;
    }

    public void setOpenPersonal(boolean openPersonal) {
        this.openPersonal = openPersonal;
    }

    public boolean isOpenArticle() {
        return openArticle;
    }

    public void setOpenArticle(boolean openArticle) {
        this.openArticle = openArticle;
    }

    public boolean isOpenCollection() {
        return openCollection;
    }

    public void setOpenCollection(boolean openCollection) {
        this.openCollection = openCollection;
    }

    public boolean isOpenFollow() {
        return openFollow;
    }

    public void setOpenFollow(boolean openFollow) {
        this.openFollow = openFollow;
    }
}
