package com.match.game.users.controller;

import com.match.game.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersservice;

    //회원가입페이지
    @RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
    public String signup() {
        return "auth/signup";
    }

    //회원가입 ajax
    @RequestMapping(value = "/auth/insertSingup", method = RequestMethod.POST)
    @ResponseBody
    public void insertSingup(HttpServletRequest request) {
        usersservice.insertSignup(request);

    }

    //로그인페이지이동
    @RequestMapping(value = "/auth/signin", method = RequestMethod.GET)
    public String signin(){
        return "auth/signin";
    }

    //ajax 로그인 요청
    @RequestMapping(value = "/auth/signinresult", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> signinResult(HttpServletRequest request){
        Map<String, Object> result = usersservice.signinResult(request);
        return result;
    }

    //내정보가져오기
    @RequestMapping(value = "/auth/info/{id}", method = RequestMethod.GET)
    public ModelAndView myInfo(@PathVariable String id){
        ModelAndView mView = usersservice.myInfo(id);
        mView.setViewName("auth/info");
        return mView;
    }

    //로그아웃 ajax 인크루드스크립트구현
    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    @ResponseBody
    public void signout(HttpServletRequest request){
        usersservice.signout(request);
    }

    //회원탈퇴
    @RequestMapping(value = "/auth/info/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> secession(HttpServletRequest request, @PathVariable String id){
        usersservice.secession(request, id);
        System.out.println("삭제아이디"+id);
        Map<String, Object> result = new HashMap<>();
        result.put("result", true);
        return result;
    }
}
