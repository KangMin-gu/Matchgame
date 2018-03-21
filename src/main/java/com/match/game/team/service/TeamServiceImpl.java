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
    public ModelAndView makeTeam(HttpServletRequest request, TeamDto teamDto) {
        teamDao.makeTeam(teamDto);
        System.out.println(teamDto.getTeamname());
        ModelAndView mView = new ModelAndView();
        mView.addObject("msg", teamDto.getTeamname()+"팀이 창설되었습니다.");
        return mView;
    }

    //나의 팀정보 호출
    @Override
    public ModelAndView myteam(HttpServletRequest request) {
        String id = (String) request.getSession().getAttribute("id");
        UsersDto usersDto = usersDao.userInfo(id);
        String lolid = usersDto.getLolid();
        ModelAndView mView= new ModelAndView();
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
    public ModelAndView joinForm(HttpServletRequest request, int num) {
        String id = (String) request.getSession().getAttribute("id");
        UsersDto usersDto = usersDao.userInfo(id);
        //신청자 롤 아이디
        String lolid = usersDto.getLolid();

        //신청할 팀의 정보가져오기
        TeamDto teamDto = teamDao.teamContents(num);

        ModelAndView mView = new ModelAndView();

        mView.addObject("dto", teamDto);
        mView.addObject("lolid", lolid);

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
