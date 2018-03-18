package com.match.game.facing.service;

import com.match.game.facing.dao.FacingDao;
import com.match.game.facing.dto.FacingDto;
import com.match.game.team.dao.TeamDao;
import com.match.game.team.dto.TeamDto;
import com.match.game.users.dao.UsersDao;
import com.match.game.users.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacingServiceImpl implements FacingService {

    @Autowired
    private FacingDao facingDao;

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private TeamDao teamDao;

    //내 쪽지함 열기
    @Override
    public ModelAndView facing(HttpServletRequest request) {
        String id = (String) request.getSession().getAttribute("id");
        UsersDto usersDto = usersDao.userInfo(id);
        String lolid = usersDto.getLolid();
        System.out.println("누구아이디"+lolid);
        List<FacingDto> facinglist =facingDao.facing(lolid);
        ModelAndView mView = new ModelAndView();
        mView.addObject("facinglist", facinglist);
        return mView;
    }

    //팀 가입신청
    @Override
    public void apply(HttpServletRequest request, int num){
        String id = (String) request.getSession().getAttribute("id");

        TeamDto teamDto = teamDao.teamContents(num);
        UsersDto usersDto = usersDao.userInfo(id);

        String title = usersDto.getLolid()+"님이 "+teamDto.getTeamname()+"팀에 가입 신청서를 보냈습니다.";

        String contents = "<p>"+usersDto.getLolid()+"님이 "+teamDto.getTeamname()+"팀과 함께 소환사의 협곡에 참여하고 싶어합니다.</p>"
                + "<p>신청을 수락을 눌르시면 "+usersDto.getLolid()+" 님과 소환사의 협곡에 참여하게 됩니다. </p>"
                + "<a href=\"${pageContext.request.contextPath}/team/teamlist\">신청수락</a>";


        FacingDto facingDto = new FacingDto();

        //누구에게 보내기
        facingDto.setWho(teamDto.getMain());
        //보내는이
        facingDto.setWriter(usersDto.getLolid());
        //제목
        facingDto.setTitle(title);
        //내용
        facingDto.setContent(contents);

        facingDao.apply(facingDto);

    }

    @Override
    public Map<String, Object> facingNo(String id) {

       UsersDto usersDto = usersDao.userInfo(id);
       String lolid = usersDto.getLolid();
       int facingNum = facingDao.facingNo(lolid);
       Map<String, Object> facingNo = new HashMap<>();
       facingNo.put("facingNo", facingNum);
       return facingNo;
    }

}
