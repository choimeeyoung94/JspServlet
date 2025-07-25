package chap07_cookie;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿠키 가져오기 (전체 쿠키 )
	  Cookie[] cookies = request.getCookies();
	  
	  // 쿠키 확인하기
	  if (cookies != null) {
	    for (Cookie cookie : cookies) {
	      System.out.println("cookie name: " + cookie.getName());
	      System.out.println("Cookie Value: " + URLDecoder.decode(cookie.getValue(), "UTF-8"));
	      
	      // 쿠키 삭제 후 다시 ReadCookie
	      if (cookie.getName().equals("email")) {
	        // 같은 이름(email)을 가진 쿠키를 새로 생성 후 쿠키 유효시간을 0으로 설정 후 쿠키 저장
	        Cookie ck = new Cookie("email", "'"); // 삭제할 쿠키의 값("")은 의미가 없다
	        ck.setMaxAge(0);
	        response.addCookie(ck);
	        response.sendRedirect(request.getContextPath() + "/ReadCookie");
	      }
	    }
	  }
	  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
