package com.match.game.facing.dao;

import com.match.game.facing.dto.FacingDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacingDaoImpl implements FacingDao{

    @Autowired
    private SqlSession session;

    //쪽지함 전체목록
    @Override
    public List<FacingDto> facing(String lolid) {
        List<FacingDto> facinglist = session.selectList("facing.facinglist", lolid);
        return facinglist;
    }

    //쪽지보내기
    @Override
    public void apply(FacingDto facingDto){
        session.insert("facing.apply", facingDto);
    }

    //안읽은 쪽지 갯수 가져오기
    @Override
    public int facingNo(String lolid) {
        int facingNo = session.selectOne("facing.facingNo", lolid);
        return facingNo;
    }

    //쪽지 상세보기
    @Override
    public FacingDto facingContents(int num) {
        FacingDto facingDto = session.selectOne("facing.facingContents", num);
        return facingDto;
    }

    //쪽지 읽음표시
    @Override
    public void facingViewer(FacingDto viewerdto) {
        session.update("facing.facingviewer", viewerdto);
    }
}
