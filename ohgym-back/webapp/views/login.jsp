<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./css/login.css" />

    <script src="./js/login.js" defer></script>
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
              <input type="checkbox" id="remember-check" />아이디 저장하기
            </label>
            <input type="submit" value="Login" />
          </form>
          <p>
            ${empty param.userPassword ? "" : "입력한 사용자 비밀번호가 유효하지
            않습니다. 영문, 한글, 숫자, 밑줄(_) 또는 대시(-) 문자를 사용하여 1자
            이상 16자 이하로 입력해주세요."} ${empty param.userId ? "" : "입력한
            사용자 아이디가 유효하지 않습니다. 영문, 한글, 숫자, 밑줄(_) 또는
            대시(-) 문자를 사용하여 1자 이상 16자 이하로 입력해주세요."}
          </p>
        </div>
      </main>
      <footer><%@ include file="footer.jsp" %></footer>

      <% String errorMessage = (String) request.getAttribute("errorMessage"); if
      (errorMessage != null) { %>
      <p><%= errorMessage %></p>
      <% } %>
    </div>
  </body>
</html>
