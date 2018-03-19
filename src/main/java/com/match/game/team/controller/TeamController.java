package com.match.game.team.controller;

import com.match.game.team.dto.TeamDto;
import com.match.game.team.service.TeamService;
import com.match.game.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TeamController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private TeamService teamService;

    //팀화면
    @RequestMapping(value = "/team/teaminfo", method = RequestMethod.GET)
    public String teaminfo(){
        return "team/teaminfo";
    }

    //팀 만들기페이지 이동하면서 세션아이디 가져가기
    @RequestMapping(value = "/team/make", method = RequestMethod.GET)
    public ModelAndView teammake(HttpServletRequest request){
       String id = (String) request.getSession().getAttribute("id");
       ModelAndView mView= usersService.myInfo(request, id);
       mView.setViewName("team/make");
       return mView;
    }

    //팀만들기 요청
    @RequestMapping(value = "/team/make/maketeam", method = RequestMethod.POST)
    @ResponseBody
    public void maketeam(HttpServletRequest request){
        teamService.makeTeam(request);
    }

    //팀 정보가져오기
    @RequestMapping(value = "/team/myteam/{id}", method = RequestMethod.GET)
    public ModelAndView myteam(@PathVariable String id){
        ModelAndView mView =  teamService.myteam(id);
        mView.setViewName("team/myteam");
        return mView;
    }

    //팀탈퇴
    @RequestMapping(value = "/team/myteam/secession", method = RequestMethod.PUT)
    @ResponseBody
    public void teamsecsstion(@RequestBody TeamDto teamDto){
        System.out.println(teamDto.getNum());
        teamService.teamsecession(teamDto);
    }

    //팀해체
    @RequestMapping(value = "/team/myteam/{num}", method = RequestMethod.DELETE)
    @ResponseBody
    public void Dismantiling(@PathVariable String num){
        int number = Integer.parseInt(num);
        teamService.dismantling(number);
    }

    //팀리스트
    @RequestMapping(value = "/team/teamlist", method = RequestMethod.GET)
    public ModelAndView teamlist(){
        ModelAndView mView = teamService.teamlist();
        mView.setViewName("team/teamlist");
        return mView;
    }

    //팀상세보기
    @RequestMapping(value = "/team/contents/{num}", method = RequestMethod.GET)
    public ModelAndView teamcontents(@PathVariable int num) {
        System.out.println(num);
        ModelAndView mView = teamService.teamContents(num);
        mView.setViewName("team/contents");
        return mView;
    }

    //팀신청
    @RequestMapping(value = "/team/join", method = RequestMethod.GET)
    public ModelAndView joinForm (HttpServletRequest request){
        ModelAndView mView = teamService.joinForm(request);
        mView.setViewName("team/join");
        return mView;
    }

    //팀 합류
    @RequestMapping(value = "/facing/contents/team/accept", method = RequestMethod.GET)
    public ModelAndView accept(HttpServletRequest request){
        ModelAndView mView = teamService.accept(request);
        mView.setViewName("team/accept");
        return mView;
    }

}
