package com.match.game.facing.dto;

public class FacingDto {

    private int num;
    private String who;
    private String writer;
    private String title;
    private String content;
    private String viewer;
    private String regdate;

    public FacingDto(){}

    public FacingDto(int num, String who, String writer, String title, String content, String viewer, String regdate) {
        this.num = num;
        this.who = who;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.viewer = viewer;
        this.regdate = regdate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getViewer() {
        return viewer;
    }

    public void setViewer(String viewer) {
        this.viewer = viewer;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
