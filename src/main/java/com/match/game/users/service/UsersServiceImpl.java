package com.match.game.users.service;

import com.match.game.users.dao.UsersDao;
import com.match.game.users.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private PasswordEncoder encoder;

    //회원가입
    @Override
    public ModelAndView insertSignup(UsersDto usersdto) {

        String hash = encoder.encode(usersdto.getPwd());

        usersdto.setPwd(hash);

        usersDao.insertSignup(usersdto);

        ModelAndView mView = new ModelAndView();

        mView.addObject("email", usersdto.getEmail());
        return mView;
    }

    //로그인요청
    @Override
    public ModelAndView signinResult(UsersDto usersDto, HttpServletRequest request) {

        UsersDto resultDto = usersDao.userInfo(usersDto.getId());

        boolean isValid = false;

        if(resultDto != null){
            boolean isMatch = encoder.matches(usersDto.getPwd(), resultDto.getPwd());
            if(isMatch) {
                isValid = true;
            }
        }

        String url = request.getParameter("url");
        ModelAndView mView = new ModelAndView();

        if(isValid){
            request.getSession().setAttribute("id", usersDto.getId());
            mView.addObject("msg", usersDto.getId()+"님 환영합니다.");
            mView.addObject("url", url);
        }else{
            String location = "auth/signin?url="+url;
            mView.addObject("msg", "아이디 혹은 비밀번호를 확인해주세요.");
            mView.addObject("url", location);
        }
        return mView;
    }

    //내정보가져오기
    @Override
    public ModelAndView myInfo(HttpServletRequest request, String id) {
        String sessionId = (String) request.getSession().getAttribute("id");
        UsersDto usersDto = usersDao.userInfo(sessionId);
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

    //회원정보수정
    @Override
    public void modified(UsersDto usersDto) {
        String pwd = usersDto.getPwd();
        String hash = encoder.encode(pwd);
        usersDto.setPwd(hash);
        usersDao.modified(usersDto);
    }

}
