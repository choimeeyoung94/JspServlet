package chap01_request;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestExServlet
 */
@WebServlet("/RequestExServlet")
public class RequestExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // ① 요청 본문 인코딩 설정 (반드시 getParameter 호출 전에!)
    request.setCharacterEncoding("UTF-8");
	  
	  String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		String[] phoneNumber = request.getParameterValues("mobile");
		System.out.println("name: " + name);
		System.out.println("email: " + email);
		System.out.println("gender: " + gender);
		System.out.println("hobbies: " + Arrays.toString(hobbies));
		System.out.println("mobile: " + phoneNumber[0]);
		System.out.println("phoneNumber: " + phoneNumber[1]);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
