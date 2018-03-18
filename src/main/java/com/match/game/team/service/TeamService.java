package com.match.game.team.service;


import com.match.game.team.dto.TeamDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface TeamService {
    public void makeTeam(HttpServletRequest request);
    public ModelAndView myteam(String id);
    public void teamsecession(TeamDto teamDto);
}
