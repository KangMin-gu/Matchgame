package com.match.game.match.controller;

import com.match.game.match.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MatchController {

    @Autowired
    private MatchService matchService;

    //해당팀 대전 신청폼으로 이동
    @RequestMapping(value = "/match/{num}", method = RequestMethod.GET)
    public ModelAndView vsForm(HttpServletRequest request, @PathVariable int num){
        System.out.println("매치컨트롤러들어옴"+num);
        ModelAndView mView = matchService.vsForm(request,num);
        mView.setViewName("match/vs");
        return mView;
    }

    @RequestMapping(value = "/match/info/{teamname}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView teamname(@PathVariable String teamname){
        System.out.println("아작스팀"+teamname);
        return null;
    }
}
