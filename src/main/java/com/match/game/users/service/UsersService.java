package com.match.game.users.service;


import com.match.game.users.dto.UsersDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface UsersService {

    public ModelAndView insertSignup(UsersDto usersDto);
    public ModelAndView signinResult(UsersDto usersDto, HttpServletRequest request);
    public ModelAndView myInfo(HttpServletRequest request, String id);
    public void signout(HttpServletRequest request);
    public void secession(HttpServletRequest request, String id);
    public void modified(UsersDto usersDto);
}
