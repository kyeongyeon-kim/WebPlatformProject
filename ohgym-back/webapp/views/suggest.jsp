<%@page import="ohgym.request.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="./css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./css/suggest.css" />
    <script src="./js/include.js"></script>
    <script src="./js/header.js"></script>
</head>
<body>
<div class="container">
      <header><%@ include file="header.jsp"%></header>
      <main>
        <aside id="request">
          <h1>받은요청</h1>
          <div id="user-info">
            <p id="user-info-id">${ request.id}</p>
            <p id="user-info-type">${request.exerciseType}</p>
            <p id="user-info-area">${ requestinfo.answer7 }</p>
            <hr />
          </div>
          <h1>요청사항</h1>
          <div id="request-info">
            <ul>
              <li>
                <p>레슨목적</p>
                <p id="purpose">${ requestinfo.answer1 }</p>
              </li>
              <li>
                <p>레슨 스타일</p>
                <p id="lessonStyle">${ requestinfo.answer2 }</p>
              </li>
              <li>
                <p>가능한 요일</p>
                <p id="dayOfWeek">${ requestinfo.answer3 }</p>
              </li>
              <li>
                <p>희망 시간대</p>
                <p id="desiredTime">${ requestinfo.answer4 }</p>
              </li>
              <li>
                <p>회원님 성별</p>
                <p id="gender">${ requestinfo.answer5 }</p>
              </li>
              <li>
                <p>회원님 연령대</p>
                <p id="age">${ requestinfo.answer6 }</p>
              </li>
              <li>
                <p>회원님 계신 지역</p>
                <p id="address">${ requestinfo.answer7 }</p>
              </li>
              <li>
                <p>그 외 희망사항</p>
                <p id="message">${ requestinfo.message }</p>
              </li>
            </ul>
          </div>
        </aside>
        <section id="suggest">
          <h1>견적작성</h1>
          <section>
            <div id="cost-wrap">
              <p class="title">금액</p>
              <input
                type="number"
                id="input-cost"
                value=""
                placeholder="금액을 입력해 주세요"
                required
              />
              <p id="guide" style="display: none">금액은 필수입력사항입니다.</p>
            </div>
            <div id="quote-wrap">
              <p class="title">견적설명</p>
              <textarea
                id="quote"
                maxlength="200"
                rows="8"
                placeholder="요청사항에 대한 답변, 서비스 진행방식, 근선생님만의 강점이나 특징 등을 작성하세요."
              ></textarea>
            </div>
            <a href="#" id="send-suggest">견적보내기</a>
          </section>
        </section>
      </main>
      <footer><%@ include file="footer.jsp"%></footer>
    </div>
</body>
<script src="./js/suggest.js"></script>
</html>