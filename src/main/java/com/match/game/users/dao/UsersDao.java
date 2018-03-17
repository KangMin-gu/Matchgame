package com.match.game.users.dao;

import com.match.game.users.dto.UsersDto;

public interface UsersDao {

    public void insertSignup(UsersDto usersDto);
    public UsersDto userInfo(String id);
    public void secession(String id);
}
