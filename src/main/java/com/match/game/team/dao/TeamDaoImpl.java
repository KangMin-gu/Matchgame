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

    //팀 등록
    @Override
    public void makeTeam(TeamDto teamDto) {
        session.insert("team.insert", teamDto);
    }

    //나의 팀
    @Override
    public List<TeamDto> myteam(String lolid) {
        List<TeamDto> teamlist = session.selectList("team.myteam", lolid);
        return teamlist;
    }

    //팀 탈퇴
    @Override
    public void teamsecession(TeamDto teamDto) {
        session.update("team.secession", teamDto);
    }

    //팀해체
    @Override
    public void dismantling(int number) {
        session.delete("team.dismantling", number);
    }

    //팀 전체목록
    @Override
    public List<TeamDto> teamlist() {
        List<TeamDto> allList = session.selectList("team.teamlist");
        return allList;
    }

    //팀 자세히보기
    @Override
    public TeamDto teamContents(int num) {
        TeamDto teamDto = session.selectOne("team.contents", num);
        return teamDto;
    }

    @Override
    public void accept(TeamDto teamDto) {
        session.update("team.accept", teamDto);
    }


}
