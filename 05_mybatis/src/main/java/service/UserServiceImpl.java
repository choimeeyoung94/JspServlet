package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import dao.UserDao;
import model.dto.UserDTO;

public class UserServiceImpl implements UserService {

  // 서비스는 Dao를 사용한다
  private UserDao userDao = UserDao.getInstance();
   
  @Override
  public ActionForward login(HttpServletRequest request) {
    
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    UserDTO userDTO = new UserDTO();
    userDTO.setEmail(email);
    userDTO.setPassword(password);
    
    UserDTO foundUser = userDao.getUser(userDTO);
    System.out.println("foundUser: " + foundUser);
    String view = null;
    boolean isRedirect = false;
    // foundUser가 존재하면 로그인 처리 수행, 아니면 로그인 화면(/user/login.jsp)으로 이동 리다이렉트
    if (foundUser != null) {
      // 로그인 성공 (foundUser 객체를 세션에 올려두고 메인 화면(/index.jsp)으로 이동) 리다이렉트
      HttpSession session = request.getSession();
      session.setAttribute("loginUser", foundUser);
      view =  request.getContextPath() + "/main";
      isRedirect = true;
    } else {
      // 로그인 실패 (로그인 화면으로 이동)
      view = "/view/user/login.jsp";
      String msg = "아이디나 비밀번호를 확인하세요";
      request.setAttribute("errorMessage", msg);
    }
    
    return new ActionForward(view, isRedirect);
  }

  @Override
  public ActionForward logout(HttpServletRequest request) {
    // 세션 초기화
    request.getSession().invalidate();
    return new ActionForward(request.getContextPath() + "/main" , true);
  }

}
