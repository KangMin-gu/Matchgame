package com.match.game.team.dao;

import com.match.game.team.dto.TeamDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDaoImpl implements TeamDao {

    @Autowired
    private SqlSession session;

    @Override
    public void makeTeam(TeamDto teamDto) {
        session.insert("team.insert", teamDto);
    }

    @Override
    public List<TeamDto> myteam(String lolid) {
        List<TeamDto> teamlist = session.selectList("team.myteam", lolid);
        return teamlist;
    }

    @Override
    public void teamsecession(TeamDto teamDto) {
        session.update("team.secession", teamDto);
    }


}
