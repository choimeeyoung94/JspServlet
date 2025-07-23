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
  
   <h1>게시글 조회</h1>
  <h2>제목: ${board.title}</h2>
 
  <p>작성자: ${board.user.nickname}</p>
  <p>작성자번호: ${board.user.uid}</p>
  <p>최초생성일자: ${board.createdAt}</p>
  <p>최종수정일시: ${board.modifiedAt}</p>
  
  <hr>
   <pre>${board.content}</pre>
  
  <hr>
  <button type="button" onclick="list()">목록보기</button>
  <c:if test="${board ne null}">
    <button type="button" onclick="deleteBoard()">삭제하기</button>
  </c:if>
  
  
  <script>
     
  function list() {
    location.href="${contextPath}/board/list.do"
  }
  
  function deleteBoard() {
    if (confirm('현재 게시글을 삭제할까요?')) {
      location.href="${contextPath}/board/remove.do?bid=${board.bid}";
    }
  }
  
  
  
  
  
  
  </script>
  
  
  
  
</body>
</html>