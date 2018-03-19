package com.match.game.users.controller;

import com.match.game.users.dto.UsersDto;
import com.match.game.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersservice;

    //회원가입페이지
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String signup() {
        return "auth/signup";
    }

    //회원가입
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView insertSingup(@ModelAttribute UsersDto usersDto) {
        System.out.println(usersDto.getId());
        ModelAndView mView =  usersservice.insertSignup(usersDto);
        mView.setViewName("auth/complete");
        return mView;
    }

    //로그인페이지이동
    @RequestMapping(value = "/auth/signin", method = RequestMethod.GET)
    public String signin(){
        return "auth/signin";
    }

    //로그인
    @RequestMapping(value = "/auth/signin", method = RequestMethod.POST)
    public ModelAndView signinResult(@ModelAttribute UsersDto usersDto, HttpServletRequest request){
       ModelAndView mView = usersservice.signinResult(usersDto, request);
       mView.setViewName("auth/signinresult");
       return mView;
    }

    @RequestMapping(value = "/auth/signout", method = RequestMethod.GET)
    public ModelAndView signout(HttpServletRequest request){

        usersservice.signout(request);
        ModelAndView mView = new ModelAndView();
        mView.setViewName("redirect:/");
        return mView;
    }

    //내정보가져오기
    @RequestMapping(value = "/auth/{id}", method = RequestMethod.GET)
    public ModelAndView myInfo(HttpServletRequest request, @PathVariable String id){
        System.out.println("정보");
        ModelAndView mView = usersservice.myInfo(request, id);
        mView.setViewName("auth/info");
        return mView;
    }

    //회원탈퇴
    @RequestMapping(value = "/auth/{id}", method = RequestMethod.DELETE)
    public ModelAndView deletetest(HttpServletRequest request, @PathVariable String id){
        usersservice.secession(request, id);
        ModelAndView mView = new ModelAndView();
        mView.setViewName("redirect:/");
        return mView;
    }

    //회원수정
    @RequestMapping(value = "/auth/{id}", method = RequestMethod.PUT)
    public String modified(HttpServletRequest request, @ModelAttribute UsersDto usersDto){
        usersservice.modified(usersDto);
        return "redirect:/auth/{id}";
    }

}
