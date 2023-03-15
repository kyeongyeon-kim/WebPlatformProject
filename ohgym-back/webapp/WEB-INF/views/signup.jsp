<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./css/login.css" />
    <script src="./js/signup.js" defer></script>
  </head>
  <body>
    <div class="container">
      <header><%@ include file="header.jsp" %></header>
      <main style="display: flex; justify-content: center; align-items: center">
        <div class="signup-page" style="align-items: center">
          <h2>회원가입</h2>
          <form
            method="post"
            action="http://localhost:8080/ohgym/checkid"
            id="signup-form"
            onsubmit="return validateForm()"
          >
            <h4>아이디</h4>
            <div class="field id" style="width: 100%; height: 60%">
              <div id="alert-message"></div>
              <button id="checkid" type="button">중복체크</button>
              <div>
                <input
                  type="text"
                  id="id"
                  name="id"
                  placeholder="아이디를 입력하세요"
                  maxlength="13"
                  value="${param.userId}"
                />
              </div>
            </div>

            <h4>비밀번호</h4>
            <input
              type="password"
              id="password"
              name="password"
              placeholder=" 비밀번호를 입력하세요"
              maxlength="10"
              value="${param.userPassword}"
            />

            <h4>비밀번호 재확인</h4>
            <input
              type="password"
              id="password"
              name="password-confirm"
              placeholder=" 비밀번호 재확인"
              maxlength="10"
            />

            <h4>이름</h4>
            <input
              type="text"
              id="name"
              name="userName"
              placeholder=" 이름을 입력하세요"
              maxlength="7"
              value="${param.userName}"
            />

            <h4>전화번호</h4>
            <input
              type="text"
              id="phoneNum"
              name="userPhone"
              placeholder=" 전화번호를 입력하세요"
              maxlength="11"
              value="${param.userPhone}"
            />

            <h4>생년월일</h4>
            <div class="field gender" style="width: 100%; height: 30%">
              <div>
                <label
                  ><input
                    type="radio"
                    name="gender"
                    value="${param.userGender}"
                  />남자</label
                >
                <label
                  ><input
                    type="radio"
                    name="gender"
                    value="${param.userGender}"
                  />여자</label
                >
              </div>
              <div>
                <input
                  type="date"
                  name="userBirthday"
                  placeholder=" 생년월일 6자리를 입력하세요"
                  value="${param.userBirthday}"
                />
              </div>
            </div>
            <input type="submit" id="signup-submit" value="가입하기" />
          </form>
        </div>
      </main>
      <footer><%@ include file="footer.jsp" %></footer>
    </div>
  </body>
</html>
