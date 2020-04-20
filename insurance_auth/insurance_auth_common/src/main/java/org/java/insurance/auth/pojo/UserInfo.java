package org.java.insurance.auth.pojo;

/**
 * 载荷对象
 */
public class UserInfo {

    private String id;//编号

    private String username;//姓名

    private String img;//头像

    public UserInfo(String id, String username) {
        this.id = id;
        this.username = username;
    }
    public UserInfo() {
    }
    public UserInfo(String id, String username, String img) {
        this.id = id;
        this.username = username;
        this.img = img;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}