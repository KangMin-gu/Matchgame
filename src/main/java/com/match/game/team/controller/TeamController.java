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

    //나의 팀 정보가져오기
    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    public ModelAndView myteam(HttpServletRequest request){
        System.out.println("팀들어옴");
        ModelAndView mView =  teamService.myteam(request);
        mView.setViewName("team/myteam");
        return mView;
    }

    //팀 탈퇴
    @RequestMapping(value = "/team/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void teamsecsstion(@RequestBody TeamDto teamDto){
        teamService.teamsecession(teamDto);
    }

    //팀 리스트
    @RequestMapping(value = "/team/list", method = RequestMethod.GET)
    public ModelAndView teamlist(){
        ModelAndView mView = teamService.teamlist();
        mView.setViewName("team/teamlist");
        return mView;
    }

    //팀 만들기페이지 이동하면서 세션아이디 가져가기
    @RequestMapping(value = "/team/make", method = RequestMethod.GET)
    public ModelAndView teammake(HttpServletRequest request){
       String id = (String) request.getSession().getAttribute("id");
       ModelAndView mView= usersService.myInfo(request, id);
       mView.setViewName("team/make");
       return mView;
    }

    //팀 만들기 요청
    @RequestMapping(value = "/team/make", method = RequestMethod.POST)
    public ModelAndView maketeam(HttpServletRequest request, @ModelAttribute TeamDto teamDto){
        System.out.println(teamDto.getTeamname());
        ModelAndView mView = teamService.makeTeam(request, teamDto);
        mView.setViewName("team/makeresult");
        return mView;
    }

    //팀 해체
    @RequestMapping(value = "/team/{num}", method = RequestMethod.DELETE)
    @ResponseBody
    public void Dismantiling(HttpServletRequest request, @PathVariable String num){
        int number = Integer.parseInt(num);
        teamService.dismantling(number);
    }

    //팀 정보상세보기
    @RequestMapping(value = "/team/contents/{num}", method = RequestMethod.GET)
    public ModelAndView teamcontents(@PathVariable int num) {
        System.out.println(num);
        ModelAndView mView = teamService.teamContents(num);
        mView.setViewName("team/contents");
        return mView;
    }

    //팀신청폼
    @RequestMapping(value = "/team/join/{num}", method = RequestMethod.GET)
    public ModelAndView joinForm (HttpServletRequest request,@PathVariable int num){
        System.out.println("가입신청서폼 번호"+num);
        ModelAndView mView = teamService.joinForm(request, num);
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
