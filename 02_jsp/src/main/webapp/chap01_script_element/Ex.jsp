<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="javax.servlet.ServletException, 
                 javax.servlet.annotation.WebServlet,
                 javax.servlet.http.HttpServlet, 
                 javax.servlet.http.HttpServletRequest, 
                 javax.servlet.http.HttpServletResponse, 
                 javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%-- 1. 화면을 새로 고침 할 때마다 변수 count값을 1 증가시켜서 화면에 출력하세요 --%>
  <%
  
  int count = (int) session.getAttribute("count");
 
  count++;
  session.setAttribute("count", count);
    
  %>
  <%= count %>
  
  <%-- 2. "일",..."토" 요일 정보를 배열에 저장하고 현재 요일 정보를 화면에 출력하세요 --%>
  <%
    String[] days = {"일", "월", "화", "수", "목", "금", "토"};
    Calendar cal = Calendar.getInstance();
    System.out.println(cal);
    int dayIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
  %>
  <h1><%=days[dayIndex] %>요일</h1>
  
  <%-- 3. List<String> fruits에 과일명을 3개 저장하고 화면에 <ul> 태그로 출력하세요 --%>
  <%!
  static List<String> fruits = new ArrayList<String>();
  static {
     fruits.add("망고");
     fruits.add("복숭아");
     fruits.add("자두");
  }
  %>
  <ul>
  <%
   for(String fruit : fruits) { %>
      <li><%=fruit %></li>
  <% } %> 
  </ul>  
  
  <%-- 4. Map<String, String> members에 nickname과 name을 하나의 Entry로 저장하세요. 멤버는 3명을 만들고 각 회원정보를 <table> 태그로 출력--%>
  <%!
     static Map<String, String> members = new HashMap<String, String>();
     static {
       members.put("tommy", "김길동");
       members.put("eric", "박길동");
       members.put("mickle", "홍길동");  
     }
     
  %>
  
  <table border="1">
   <tr>
      <th>닉네임</th>
      <th>이름</th>
   
   </tr>
   <% for (Map.Entry<String, String> entry : members.entrySet()) { %>
      <tr>
      <td><%=entry.getKey()%></td>
      <td><%=entry.getValue()%></td>
      </tr>
   <% } %> 
  
  </table>
 
  <%-- 5 int age에 임의의 나이를 저장하고, 20세 기준으로 "성인입니다" 또는 미성년자입니다 를 화면에 출력--%>
   <% int age = 25;
   
   if (age >= 20) {  %>
     <h1><%=age%>세, 성인입니다</h1>
   <% } else { %>
     <h1><%=age%>세,미성년자입니다</h1>
  <% } %> 
  
</body>
</html>