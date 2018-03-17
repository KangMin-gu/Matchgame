package com.match.game.users.service;

import com.match.game.users.dao.UsersDao;
import com.match.game.users.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private PasswordEncoder encoder;

    //회원가입
    @Override
    public void insertSignup(HttpServletRequest request) {

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String post = request.getParameter("post");
        String addr = request.getParameter("addr");
        String detailaddr = request.getParameter("detailaddr");

        UsersDto usersDto = new UsersDto();
        String hash = encoder.encode(pwd);

        usersDto.setId(id);
        usersDto.setPwd(hash);
        usersDto.setName(name);
        usersDto.setEmail(email);
        usersDto.setPhone(phone);
        usersDto.setPost(post);
        usersDto.setAddr(addr);
        usersDto.setDetailaddr(detailaddr);

        usersDao.insertSignup(usersDto);

    }

    //로그인요청
    @Override
    public Map<String, Object> signinResult(HttpServletRequest request) {

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        UsersDto resultDto = usersDao.userInfo(id);

        boolean isValid = false;

        if(resultDto != null){
            boolean isMatch = encoder.matches(pwd, resultDto.getPwd());
            if(isMatch) {
                isValid = true;
            }
        }

        Map<String, Object> result = new HashMap<>();

        if(isValid){
            request.getSession().setAttribute("id", resultDto.getId());
            result.put("result", isValid);
            result.put("id", resultDto.getId());
        }else{
            result.put("result", isValid);
        }

        return result;

    }

    //내정보가져오기
    @Override
    public ModelAndView myInfo(String id) {
        UsersDto usersDto = usersDao.userInfo(id);
        ModelAndView mView = new ModelAndView();
        mView.addObject("dto",usersDto);
        return mView;
    }

    //로그아웃
    @Override
    public void signout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
    //회원탈퇴
    @Override
    public void secession(HttpServletRequest request, String id) {
        request.getSession().invalidate();
        usersDao.secession(id);
    }

    @Override
    public void modified(HttpServletRequest request, UsersDto usersDto) {
        String pwd = usersDto.getPwd();
        String hash = encoder.encode(pwd);
        usersDto.setPwd(hash);
        usersDao.modified(usersDto);
    }

}
