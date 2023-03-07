<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Oh!gym</title>
    <link rel="stylesheet" type="text/css" href="./css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./css/teachermypage.css" />
  </head>
  <body>
    <div class="container">
      <header><%@ include file="header.jsp"%></header>
      <main>
        <div id="title">
          <h1>마이페이지</h1>
        </div>
        <div id="clientName">
          <p class="name">김경연</p>
          <p>선생님</p>
          <button>정보수정</button>
        </div>
        <div class="notice">
          <h3>
            <a href="#">프로필</a>
          </h3>
        </div>
        <div id="history">
          <h3>
            <a href="#">받은 요청</a>
          </h3>
          <div class="box">
            <div>
              <ul id="requestList">
                <c:forEach var="request" items="${ list }">
                  <li>
                    <div id="request-card">
                      <p>${ request.exerciseType }</p>
                      <p>${ request.id }</p>
                      <p>
                        ${ request.requestDate } ~ ${ request.deadlineDate }
                      </p>
                    </div>
                    <div class="bottom">
                    <%String str="/ohgym/requestNo?id=도연"; %>
                      <a href=<%= str %> id="bottom">자세히 보기</a>
                    </div>
                  </li>
                </c:forEach>
              </ul>
            </div>
          </div>
          <h3>
            <a href="#">이용 내역</a>
          </h3>
        </div>
        <div class="notice">
          <h3>
            <a href="#">알림</a>
          </h3>
          <h3>
            <a href="#">공지사항</a>
          </h3>
          <h3>
            <a href="#">Oh!GYM 안내</a>
          </h3>
        </div>
      </main>
      <footer><%@ include file="footer.jsp"%></footer>
    </div>
  </body>
  <script src="./js/teachermypage.js"></script>
</html>
