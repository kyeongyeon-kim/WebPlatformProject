<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../css/framestyle.css">
    <link rel="stylesheet" type="text/css" href="../css/mypage.css">
    <script src="../js/include.js"></script>
    <script src="../js/header.js"></script>
    <script src="https://kit.fontawesome.com/367bc8d5b8.js" crossorigin="anonymous"></script>
</head>
<body>
 <div class="container">
            <header><%@ include file="header.jsp" %></header>
            <main>
                  <div id="title">
                        
                        <h1>마이페이지</h1>
                  </div>
                  <div id="clientName">
                        <p class="name">김도연</p>
                        <p> 회원님</p>
                        <button><a href="./infochange.jsp">정보수정</a></button>
                  </div>
                  <div class="history">
                        <h3><a href="#">요청 내역</a></h3>
                        <div class="box">
                              <div>
                                    <ul id="requestList"></ul>
                              </div>
                        </div>
                  </div>
                  <div class="history">
                        <h3><a href="#">찜한 내역</a></h3>
                        <div class="box">
                              <div>
                                    <ul id="pickList"></ul>
                              </div>
                        </div>
                  </div>
                  <div class="history">
                        <h3><a href="#">이용내역</a></h3>
                  </div>
                  <div class="notice">
                        <h3><a href="#">알림</a></h3>
                        <h3><a href="#">공지사항</a></h3>
                        <h3><a href="#">Oh!GYM 안내</a></h3>
                  </div>

            </main>
            <template id="request-card-temp">
                  <li>
                        <div id="request-card">
                              <p></p>
                              <p></p>
                        </div>
                        <div class="bottom">
                              <a href="#">자세히 보기</a>
                        </div>
                  </li>
            </template>
            <template id="pick-card-temp" >
                  <a href="#">
                  <li>
                        <div id="pick-card" style="display: flex;">
                              <div>
                              <p class="appeal"></p>
                              <p id="time"></p>
                              <div style="display:flex; align-items: flex-start;">
                              <img class="score" src="../img/star.png" alt="">
                              <span id="score">4.8</span>
                              </div>
                               </div>
                              <img id="pick-image" src="../img/health.png" alt="techer-img">
                        </div>
                  </a>
                  </li>
            </template>
            <footer><%@ include file="footer.jsp" %></footer>
      </div>
</body>
<script src="../js/clientmypage.js"></script>
</html>