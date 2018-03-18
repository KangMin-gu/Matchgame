package com.match.game.team.dao;

import com.match.game.team.dto.TeamDto;

import java.util.List;

public interface TeamDao {
    public void makeTeam(TeamDto teamDto);
    public List<TeamDto> myteam(String lolid);
    public void teamsecession(TeamDto teamDto);
}
