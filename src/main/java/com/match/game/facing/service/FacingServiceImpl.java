package com.match.game.facing.service;

import com.match.game.facing.dao.FacingDao;
import com.match.game.facing.dto.FacingDto;
import com.match.game.team.dao.TeamDao;
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
    public void apply(HttpServletRequest request){

        String id = (String) request.getSession().getAttribute("id");
        String number = request.getParameter("num");
        String teamname = request.getParameter("teamname");
        String main =request.getParameter("main");
        String top = request.getParameter("top");
        String mid = request.getParameter("mid");
        String bottom = request.getParameter("bottom");
        String support = request.getParameter("support");
        String jungle = request.getParameter("jungle");

        UsersDto usersDto = usersDao.userInfo(id);
        String joinlolid = usersDto.getLolid();

        FacingDto facingDto = new FacingDto();
        String title = joinlolid+" 님이 " +teamname+ " 팀에 합류하고 싶어합니다.";

        if(top != null){
            String content =
                    joinlolid+" 님의 포지션은 Top 입니다."
                            +"<br/>"
                            + "신청을 수락 하시면"+joinlolid+" 님이 "+teamname+" 팀에 합류 합니다."
                            + "<a href=\"team/accept?num="+number+"&lolid="+joinlolid+"&top="+top+"\">신청수락</a>";
            facingDto.setContent(content);
        }else if(mid != null){
            String content =
                    joinlolid+" 님의 포지션은 Mid 입니다."
                            +"<br/>"
                            + "신청을 수락 하시면"+joinlolid+" 님이 "+teamname+" 팀에 합류 합니다."
                            + "<a href=\"team/accept?num="+number+"&lolid="+joinlolid+"&mid="+mid+"\">신청수락</a>";
            facingDto.setContent(content);
        }else if(bottom != null){
            String content =
                    joinlolid+" 님의 포지션은  Dealer 입니다."
                            +"<br/>"
                            + "신청을 수락 하시면"+joinlolid+" 님이 "+teamname+" 팀에 합류 합니다."
                            + "<a href=\"team/accept?num="+number+"&lolid="+joinlolid+"&bottom="+bottom+"\">신청수락</a>";
            facingDto.setContent(content);
        }else if(support != null){
            String content =
                    joinlolid+" 님의 포지션은 Supporter 입니다."
                            +"<br/>"
                            + "신청을 수락 하시면"+joinlolid+" 님이 "+teamname+" 팀에 합류 합니다."
                            + "<a href=\"team/accept?num="+number+"&lolid="+joinlolid+"&support="+support+"\">신청수락</a>";
            facingDto.setContent(content);
        }else{
            String content =
                    joinlolid+" 님의 포지션은 Jungler 입니다."
                            +"<br/>"
                            + "신청을 수락 하시면"+joinlolid+" 님이 "+teamname+" 팀에 합류 합니다."
                            + "<a href=\"team/accept?num="+number+"&lolid="+joinlolid+"&jungle="+jungle+"\">신청수락</a>";
            facingDto.setContent(content);
        }

        facingDto.setTitle(title);
        facingDto.setWho(main);
        facingDto.setWriter(joinlolid);


        facingDao.apply(facingDto);

    }

    //안읽은 쪽지 갯수
    @Override
    public Map<String, Object> facingNo(String id) {

       UsersDto usersDto = usersDao.userInfo(id);
       String lolid = usersDto.getLolid();
       int facingNum = facingDao.facingNo(lolid);
       Map<String, Object> facingNo = new HashMap<>();
       facingNo.put("facingNo", facingNum);
       return facingNo;
    }

    //글 읽기 하면서 읽음표시 Y 로바꾸기
    @Override
    public ModelAndView facingContents(int num) {
        FacingDto viewerdto = new FacingDto();

        viewerdto.setNum(num);
        viewerdto.setViewer("Y");
        facingDao.facingViewer(viewerdto);

        FacingDto facingDto = facingDao.facingContents(num);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto",facingDto);
        return mView;
    }

}
