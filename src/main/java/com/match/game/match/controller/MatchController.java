package com.match.game.match.controller;

import com.match.game.match.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MatchController {

    @Autowired
    private MatchService matchService;

    //해당팀 대전신청하기
    @RequestMapping(value = "/match/vs/{num}", method = RequestMethod.GET)
    public ModelAndView vsForm(HttpServletRequest request, @PathVariable int num){
        ModelAndView mView = new ModelAndView();
        matchService.vsForm(request, num);
        mView.setViewName("match/vs");
        return mView;
    }
}
