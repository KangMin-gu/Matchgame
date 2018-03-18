package com.match.game.team.dto;

public class TeamDto {

    private int num;
    private String teamname;
    private String main;
    private String top;
    private String mid;
    private String bottom;
    private String support;
    private String jungle;
    private int win;
    private int lose;
    private String regdate;

    public TeamDto(){}

    public TeamDto(int num, String teamname, String main, String top, String mid, String bottom, String support, String jungle, int win, int lose, String regdate) {
        this.num = num;
        this.teamname = teamname;
        this.main = main;
        this.top = top;
        this.mid = mid;
        this.bottom = bottom;
        this.support = support;
        this.jungle = jungle;
        this.win = win;
        this.lose = lose;
        this.regdate = regdate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getJungle() {
        return jungle;
    }

    public void setJungle(String jungle) {
        this.jungle = jungle;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
