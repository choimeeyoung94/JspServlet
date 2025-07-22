<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL(JavaServerPage Standard Tag Library)에서 제공하는 Core 라이브러리를 사용한다 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  request.setAttribute("today", new Date());  
  
%>

<div><fmt:formatDate value="${today}" pattern="yyyy년 MM월 dd일 E요일"/></div>
<div><fmt:formatDate value="${today}" pattern="a h:mm:ss"/></div>
<div><fmt:formatDate value="${today}" pattern="HH:mm:ss.SSS"/></div>

<%
  request.setAttribute("number", 12345.6789);
%>

<div><fmt:formatNumber value="${number}" pattern="0.00"/></div>
<div><fmt:formatNumber value="${number}" pattern="#,##0"/></div>
<div><fmt:formatNumber value="${number}" pattern="#,##0.00"/></div>

</body>
</html>