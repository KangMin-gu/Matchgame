package com.match.game.facing.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface FacingService {
    public ModelAndView facing(HttpServletRequest request);
    public void apply(HttpServletRequest request);
    public Map<String, Object> facingNo (String id);
    public ModelAndView facingContents(int num);
}
