package com.match.game.team.service;

import com.match.game.team.dao.TeamDao;
import com.match.game.team.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDao teamDao;

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
}
