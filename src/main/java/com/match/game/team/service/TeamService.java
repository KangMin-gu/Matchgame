package com.match.game.team.service;


import com.match.game.team.dto.TeamDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface TeamService {
    public ModelAndView makeTeam(HttpServletRequest request, TeamDto teamDto);
    public ModelAndView myteam(HttpServletRequest request);
    public void teamsecession(TeamDto teamDto);
    public void dismantling(int number);
    public ModelAndView teamlist();
    public ModelAndView teamContents(int num);
    public ModelAndView joinForm(HttpServletRequest request, int num);
    public ModelAndView accept(HttpServletRequest request);
}
