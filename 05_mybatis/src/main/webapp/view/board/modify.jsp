<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <h1>게시글 수정</h1>
  <form action="${contextPath}/board/modify"
       method="post">
  
    <input type="hidden" name="bid" value="${board.bid}"/>
    <p>작성자: ${board.user.uid}</p>
    <br>
    
    <label for="title">제목</label>
    <input type="text" name="title" id="title" value="${board.title}"/>
    <br>
    <label for="content">내용</label>
    <br>
    <textarea name="content" id="content" rows="5" cols="30">${board.content}</textarea>
    <br>
    <button type="submit">수정하기</button>
    <button type="button" onclick="list()">목록보기</button>
 </form>
  <script type="text/javascript">
    function list() {
      location.href="${contextPath}/board/list"
    }
  </script>
  
  
  
  
  
</body>
</html>