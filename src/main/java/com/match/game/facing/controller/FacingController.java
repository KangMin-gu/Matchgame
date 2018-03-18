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
    @RequestMapping(value = "/facing/list", method = RequestMethod.GET)
    public ModelAndView facing(HttpServletRequest request){
        ModelAndView mView = facingService.facing(request);
        mView.setViewName("facing/list");
        return mView;
    }

    //신청서 쪽지 발송
    @RequestMapping(value = "/team/contents/apply/{num}", method = RequestMethod.POST)
    @ResponseBody
    public void apply(HttpServletRequest request, @PathVariable int num){
        facingService.apply(request, num);
    }

    //서버과부화 막기위해 페이지로딩마다 쪽지 안읽은 쪽지 갯수 확인
    @RequestMapping(value = "/facing/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> facingNo(@PathVariable String id){
        System.out.println(id);
        Map<String, Object> facingNo = facingService.facingNo(id);
        return facingNo;
    }

    //쪽지 상세보기
    @RequestMapping(value = "/facing/contents",method = RequestMethod.GET)
    public ModelAndView facingContents(HttpServletRequest request){
        return null;
    }
}
