<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Oh!gym</title>
    <link rel="stylesheet" type="text/css" href="./resource/css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./resource/css/login.css" />

    <script src="./resource/js/login.js" defer></script>
  </head>
  <body>
    <div class="container">
      <header><%@ include file="header.jsp" %></header>
      <main style="display: flex; justify-content: center; align-items: center">
        <div class="login-page" style="align-items: center">
          <h2>로그인</h2>
          <form
            method="post"
            action="${pageContext.request.contextPath}/login"
            id="login-form"
          >
            <input
              type="text"
              id="id"
              name="userId"
              placeholder=" 아이디를 입력하세요"
              maxlength="12"
              value="${param.userId}"
            />

            <input
              type="password"
              id="password"
              name="userPassword"
              placeholder=" 비밀번호를 입력하세요"
              maxlength="10"
              value="${param.userPassword}"
            />

            <label for="remember-check">
              <input
                type="checkbox"
                id="remember-check"
                style="margin: 6px"
              />아이디 저장하기
            </label>
            <input type="submit" value="Login" id="loginbtn" />
          </form>
          <span class="errorMessage">
            ${not empty errorMessage ? errorMessage : ""}
          </span>
        </div>
      </main>
      <footer><%@ include file="footer.jsp" %></footer>
    </div>
  </body>
</html>
