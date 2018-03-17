package com.match.game.users.dao;

import com.match.game.users.dto.UsersDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    private SqlSession session;

    @Override
    public void insertSignup(UsersDto usersDto) {
        session.insert("users.insert", usersDto);
    }

    @Override
    public UsersDto userInfo(String id) {
        return session.selectOne("users.getData" , id);
    }
}
