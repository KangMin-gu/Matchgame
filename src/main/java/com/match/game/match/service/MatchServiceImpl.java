package com.match.game.match.service;

import com.match.game.match.dao.MatchDao;
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
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchDao matchDao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private TeamDao teamDao;

    @Override
    public ModelAndView vsForm(HttpServletRequest request, int num) {
        //어웨이 팀의 롤아이디 가져오기
        String id = (String) request.getSession().getAttribute("id");
        UsersDto usersDto = usersDao.userInfo(id);
        String lolid = usersDto.getLolid();
        //어웨이팀의 메인인 팀정보가져오기
        List<TeamDto> awayList = teamDao.myteam(lolid);

        //홈 팀 정보가져오기
        TeamDto homeTeam = teamDao.teamContents(num);
        System.out.println("홈팀"+homeTeam.getTeamname());

        ModelAndView mView = new ModelAndView();

        mView.addObject("awayList", awayList);
        mView.addObject("homeTeam", homeTeam);

        return mView;
    }
}

































