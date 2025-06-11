package org.example.java11.entity;

public class Title {
    private int id;
    private int uid;
    private int cid;
    private String title;
    private String createTime;
    private int click;

    public Title() {
    }

    public Title(int id, int uid, int cid, String title, String createTime,
                 int click) {
        super();
        this.id = id;
        this.uid = uid;
        this.cid = cid;
        this.title = title;
        this.createTime = createTime;
        this.click = click;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }
}
