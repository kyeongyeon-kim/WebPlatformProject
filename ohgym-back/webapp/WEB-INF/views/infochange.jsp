<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
     <link rel="stylesheet" type="text/css" href="../css/framestyle.css">
     <link rel="stylesheet" type="text/css" href="../css/login.css">
     <link rel="stylesheet" type="text/css" href="../css/userOut.css">
     <script src="../js/include.js"></script>
     <script src="../js/header.js"></script>
</head>
<body>
      <div class="container">
           <header><%@ include file="header.jsp" %></header>
            <main>
                  <main>
                        <div id="userChangeTitle">
                              <h2>회원정보수정</h2>
                        </div>
                        ${ userchange }
                        <form method="get" id="signup-form" action="../html/test.html" class="infochange">
                              <h4> 아이디 </h4>
                              <input type="text" id="userId" value="${userchange.id}" readonly />
                              <h4> 비밀번호 </h4>
                              <input type="text" id="userPassword" value="${userchange.pw}">
                              <h4> 비밀번호 재확인 </h4>
                              <input type="text" id="userPasswordTest" value="${userchange.pw}">
                              <h4> 이름</h4>
                              <input type="text" id="userName" value="${userchange.name}">
                              <h4> 전화번호 </h4>
                              <input type="text" id="userPhone" value="${userchange.phone}">
                              <h4> 생년월일 </h4>
                              <div class="field gender" style="width: 100%; height: 80px;">
                                    <div>
                                          <label><input type="radio" id="man" name="gender" value="남">남자</label>
                                          <label><input type="radio" id="woman" name="gender" value="여">여자</label>
                                    </div>
                                    <div>
                                          <input type="date" id="userBirthday" value="">
                                    </div>
                              </div>
                        </form>
                        
                        <input type="text" id="usercheck" style="display: none;"  value="">
                        <div id="submit">
                              <button>수정</button>
                        </div>
                        <div style="display: flex;justify-content: space-evenly;">
                              <button id="showOut">계정 탈퇴</button>
                        </div>

                        <div class="background">
                              <div class="window">
                                    <div class="popup">
                                          <img id="popupImg" src="../img/logo.png" alt="logo"></a>

                                          <p id="out">떠나실 건가요?</p>
                                          <p id="context">계정 탈퇴 시 모든 개인정보가 삭제되며<br>
                                                	삭제된 데이터는 다시 복구할 수 없습니다. </p>
                                          <button id="close">다시 생각해 볼게요</button><br>
                                          <button id="userout">계정탈퇴</button>

                                    </div>
                                    <div>
                                          <div></div>
                                    </div>
                              </div>
                        </div>
                  </main>
                  <footer><%@ include file="footer.jsp" %></footer>
      </div>
</body>
<script src="../js/infochange.js"></script>
<script src="../js/userOut.js"></script>
</html>