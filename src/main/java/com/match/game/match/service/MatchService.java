package com.match.game.match.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface MatchService {

    public ModelAndView vsForm(HttpServletRequest request, int num);

}
