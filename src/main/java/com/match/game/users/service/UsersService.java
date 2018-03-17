package com.match.game.users.service;


import com.match.game.users.dto.UsersDto;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UsersService {

    public void insertSignup(HttpServletRequest request);
    public Map<String, Object> signinResult(HttpServletRequest request);
    public ModelAndView myInfo(String id);
    public void signout(HttpServletRequest request);
    public void secession(HttpServletRequest request, String id);
    public void modified(HttpServletRequest request, UsersDto usersDto);
}