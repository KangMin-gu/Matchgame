package com.match.game.team.service;

import com.match.game.team.dao.TeamDao;
import com.match.game.team.dto.TeamDto;
import com.match.game.users.dao.UsersDao;
import com.match.game.users.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;
    @Autowired
    private UsersDao usersDao;

    //팀만들기
    @Override
    public void makeTeam(HttpServletRequest request) {
        String teamname =  request.getParameter("teamname");
        String main = request.getParameter("main");
        String top = request.getParameter("top");
        String mid = request.getParameter("mid");
        String bottom = request.getParameter("bottom");
        String support = request.getParameter("support");
        String jungle = request.getParameter("jungle");

        System.out.println(request.getParameter("teamname"));
        System.out.println("탑"+request.getParameter("top"));
        System.out.println("미드"+request.getParameter("mid"));
        System.out.println("정글"+request.getParameter("jungle"));
        System.out.println("바텀"+request.getParameter("bottom"));
        System.out.println("서폿"+request.getParameter("support"));

        TeamDto teamDto = new TeamDto();

        teamDto.setTeamname(teamname);
        teamDto.setMain(main);

        if(top != null){
            teamDto.setTop(main);
        }else if(mid != null){
            teamDto.setMid(main);
        }else if(bottom != null){
            teamDto.setBottom(main);
        }else if(support != null){
            teamDto.setSupport(main);
        }else{
            teamDto.setJungle(main);
        }

        teamDao.makeTeam(teamDto);

    }

    //나의 팀정보 호출
    @Override
    public ModelAndView myteam(String id) {

        ModelAndView mView= new ModelAndView();

        UsersDto usersDto = usersDao.userInfo(id);
        String lolid = usersDto.getLolid();
        mView.addObject("dto", usersDto);

        List<TeamDto> teamlist = teamDao.myteam(lolid);

        mView.addObject("list", teamlist);
        return mView;
    }

    //팀 탈퇴
    @Override
    public void teamsecession(TeamDto teamDto) {
        teamDao.teamsecession(teamDto);
    }
    //팀 해체
    @Override
    public void dismantling(int number) {
        teamDao.dismantling(number);
    }
    //팀 리스트
    @Override
    public ModelAndView teamlist() {
        List<TeamDto> allList = teamDao.teamlist();
        ModelAndView mView = new ModelAndView();
        mView.addObject("allList", allList);
        return mView;
    }

    @Override
    public ModelAndView teamContents(int num) {
        TeamDto teamDto = teamDao.teamContents(num);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto", teamDto);
        return mView;
    }

    //가입신청서 이동
    @Override
    public ModelAndView joinForm(HttpServletRequest request) {
        String id = (String) request.getSession().getAttribute("id");
        UsersDto usersDto = usersDao.userInfo(id);

        String lolid = usersDto.getLolid();
        String teamname = request.getParameter("teamname");
        String main = request.getParameter("main");
        int num = Integer.parseInt(request.getParameter("num"));

        ModelAndView mView = new ModelAndView();

        mView.addObject("num", num);
        mView.addObject("lolid", lolid);
        mView.addObject("teamname", teamname);
        mView.addObject("main", main);

        return mView;
    }

    //팀 합류
    @Override
    public ModelAndView accept(HttpServletRequest request) {
       int num = Integer.parseInt(request.getParameter("num"));
       String top = request.getParameter("top");
       String mid =request.getParameter("mid");
       String bottom =request.getParameter("bottom");
       String support = request.getParameter("support");
       String jungle =request.getParameter("jungle");
       String lolid = request.getParameter("lolid");

       TeamDto teamDto = new TeamDto();

       teamDto.setNum(num);
       teamDto.setTop(top);
       teamDto.setMid(mid);
       teamDto.setBottom(bottom);
       teamDto.setSupport(support);
       teamDto.setJungle(jungle);

       teamDao.accept(teamDto);
       ModelAndView mView = new ModelAndView();
       mView.addObject("lolid", lolid);

       return mView;

    }


}
