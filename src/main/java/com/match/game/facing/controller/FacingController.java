package com.match.game.facing.controller;

import com.match.game.facing.service.FacingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class FacingController {

    @Autowired
    private FacingService facingService;

    //쪽지함
    @RequestMapping(value = "/facing", method = RequestMethod.GET)
    public ModelAndView facing(HttpServletRequest request){
        ModelAndView mView = facingService.facing(request);
        mView.setViewName("facing/list");
        return mView;
    }

    //신청서 쪽지 발송
    @RequestMapping(value = "/team/jonin/apply", method = RequestMethod.POST)
    public ModelAndView apply(HttpServletRequest request){
        facingService.apply(request);
        ModelAndView mView = new ModelAndView();
        mView.setViewName("facing/success");
        return mView;
    }

    //서버과부화 막기위해 페이지로딩마다 쪽지 안읽은 쪽지 갯수 확인
    @RequestMapping(value = "/check/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> facingNo(@PathVariable String id){
        System.out.println(id);
        Map<String, Object> facingNo = facingService.facingNo(id);
        return facingNo;
    }

    //쪽지 상세보기
    @RequestMapping(value = "/facing/{num}",method = RequestMethod.GET)
    public ModelAndView facingContents(@PathVariable int num){
        ModelAndView mView = facingService.facingContents(num);
        mView.setViewName("facing/contents");
        return mView;
    }
}
