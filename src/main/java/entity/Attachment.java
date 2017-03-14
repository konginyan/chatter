package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Attachment {
    private String fileName;
    private String type;
    private String path;

    public Attachment(){

    }

    public Attachment(String fileName, String type, String path) {
        this.fileName = fileName;
        this.type = type;
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
