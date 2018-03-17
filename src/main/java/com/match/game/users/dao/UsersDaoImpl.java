package com.match.game.users.dao;

import com.match.game.users.dto.UsersDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private SqlSession session;
    //회원가입
    @Override
    public void insertSignup(UsersDto usersDto) {
        session.insert("users.insert", usersDto);
    }
    //회원정보검색
    @Override
    public UsersDto userInfo(String id) {
        return session.selectOne("users.getData" , id);
    }
    //회원탈퇴
    @Override
    public void secession(String id) {
        session.delete("users.delete", id);
    }

    @Override
    public void modified(UsersDto usersDto) {
        session.update("users.update", usersDto);
    }
}
