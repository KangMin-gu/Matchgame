package com.match.game.team.controller;

import com.match.game.team.service.TeamService;
import com.match.game.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TeamController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/team/teaminfo", method = RequestMethod.GET)
    public String teaminfo(){
        return "team/teaminfo";
    }

    //팀 만들기페이지 이동하면서 세션아이디 가져가기
    @RequestMapping(value = "/team/make", method = RequestMethod.GET)
    public ModelAndView teammake(HttpServletRequest request){
       String id = (String) request.getSession().getAttribute("id");
       ModelAndView mView= usersService.myInfo(id);
       mView.setViewName("team/make");
       return mView;
    }

    //팀만들기 요청
    @RequestMapping(value = "/team/make/maketeam", method = RequestMethod.POST)
    @ResponseBody
    public void maketeam(HttpServletRequest request){
        teamService.makeTeam(request);
    }




}
