package com.match.game.team.dao;

import com.match.game.team.dto.TeamDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDaoImpl implements TeamDao {

    @Autowired
    private SqlSession session;

    @Override
    public void makeTeam(TeamDto teamDto) {
        session.insert("team.insert", teamDto);
    }
}
