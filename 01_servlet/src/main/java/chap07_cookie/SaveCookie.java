package chap07_cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCookie
 */
@WebServlet("/SaveCookie")
public class SaveCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * javax.servlet.http.Cookie
		 * 
		 * 1. 서블릿에서 클라이언트의 브라우저에 저장할 작은 텍스트 데이터(쿠키)를 생성하고 관리하기 위한 클래스
		 * 2. 서버가 클라이언트를 식별하거나 상태 정보를 유지할 때 주로 사용한다
		 * 3. 쿠키는 클라이언트에 저장되기 때문에 보안이 취약하다. 민감한 정보의 저장하을 피해야 한다
		 * 4. 주요 메소드
		 *    1) setMaxAge(int) : 쿠키 유효시간(초) 설정. 0은 쿠키 삭제를 의미. 음수(-1)는 브라우저 종료시 쿠키 삭제를 의미
		 *    2) setPath(String) : 쿠키 유효경로 설정. 해당 경로 이하에서만 쿠키가 유효
		 *    3) setSecure(boolean) : true시 HTTPS 통신에서만 쿠키 전송 허용
		 *    4) setHttpOnly(boolean): true시 자바스크립트로 접근하지 못하도록 쿠키 보호
		 * 
		 * */
	  
	  // 요청 파라미터
	  String name = request.getParameter("name");
	  String email = request.getParameter("email");
	  
	  // 쿠키 생성 (key/value 구조, 영문/숫자/일부 ASCII문자 허용)
	  // 쿠키를 만들때는 인코딩을 해야 한다
	  Cookie nameCookie = new Cookie("name", URLEncoder.encode(name, "UTF-8"));
	  Cookie emailCookie = new Cookie("email", URLEncoder.encode(email, "UTF-8"));
	  
	  // 쿠키 유효시간 
	  nameCookie.setMaxAge(60 * 60 * 24 * 15); // 15일
	  emailCookie.setMaxAge(-1); // 브라우저 종료 시 삭제되는 쿠키 (session cookie) setMaxAge를 생략해도 session cookie가 된다
	  
	  // 쿠키 유효경로(디폴트는 context path)
	  nameCookie.setPath(request.getContextPath()); // /01_servlet 하위 주소는 모두 nameCookie 참조 가능
	  
	  // 쿠키 저장 (클라이언트의 브라우저로 쿠키를 전송)
	  response.addCookie(nameCookie);
	  response.addCookie(emailCookie);
	  
	  // ReadCookie 서블릿으로 이동하기
	  // 응답안에 쿠키를 넣어놓고 특정 서버로 이동할 수 있게 만들어야 한다
	  response.sendRedirect(request.getContextPath() + "/ReadCookie");
	  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
