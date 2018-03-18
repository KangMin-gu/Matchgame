package com.match.game.users.dto;

public class UsersDto {

    private int num;
    private String id;
    private String pwd;
    private String name;
    private String email;
    private String lolid;
    private String phone;
    private String post;
    private String addr;
    private String detailaddr;
    private String regdate;

    public UsersDto(){}

    public UsersDto(int num, String id, String pwd, String name, String email, String lolid, String phone, String post, String addr, String detailaddr, String regdate) {
        this.num = num;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.lolid = lolid;
        this.phone = phone;
        this.post = post;
        this.addr = addr;
        this.detailaddr = detailaddr;
        this.regdate = regdate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLolid() {
        return lolid;
    }

    public void setLolid(String lolid) {
        this.lolid = lolid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDetailaddr() {
        return detailaddr;
    }

    public void setDetailaddr(String detailaddr) {
        this.detailaddr = detailaddr;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
