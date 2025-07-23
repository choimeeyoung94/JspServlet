<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a {
  text-decoration: none;
  color: gray;
}

div {
  box-sizing: border-box;
}

.wrap {
  width: 1024px;
  margin: 0 auto;
}

.title {
  text-align: center;
  color: teal;
}

.regist-form-link {
  display: block;
  text-align: right;
}

.flex-container {
  margin-top: 20px;
  display: flex;
  flex-wrap: wrap; /*여러 줄로 flex-item 감싸기*/
  gap: 15px;
}

.flex-item {
  flex: 0 0 calc(50% - 12px);
  /*flex-grow(공간이 남으면 아이템을 얼마나 늘이나?) flex-shrink(공간이 부족하면 아이템을 얼마나 줄이나) flex-basis(아이템의 기본 크기)*/
  border: 1px solid red;
  border-radius: 5px;
  text-align: center;
  padding-top: 10px;
  transition: transform 0.3s ease;
}

.flex-item:hover {
  transform: scale(1.05);
  background-color: pink;
}
</style>



</head>
<body>


  <div class="wrap">
    <h1 class="title">게시글 목록 보기</h1>

    <a class="regist-form-link"
      href="${contextPath}/board/registForm.do">신규 게시글 작성</a>

    <div class="flex-container">
      <c:forEach var="b" items="${boards}">
        <div class="flex-item" onclick="detail(${b.bid})">
          <div>
            <strong>${b.title}</strong>
          </div>
          <div>${b.user.nickname}</div>
        </div>

      </c:forEach>


    </div>


  </div>
  <script type="text/javascript">
   function detail(bid) {
     location.href=`${contextPath}/board/detail.do?bid=\${bid}&code=detail`;
   }
 </script>




</body>
</html>