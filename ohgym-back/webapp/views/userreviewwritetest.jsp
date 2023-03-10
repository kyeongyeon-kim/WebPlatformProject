<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
	<link rel="stylesheet" type="text/css" href="./css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./css/reviewwrite.css" />
</head>
<body>
    <div class="container">
      <header><%@ include file="header.jsp" %></header>
	      <main>
			<button onclick="reviewwrite()">리뷰(작성)하기</button>
			<div id="reviewtap">
			  <div id="reviewcontent">
			  
			    <p id="closebtn">&times;</p>
			    
			    <div id="reviewquestiondiv">
			      <p id="reviewquestion1">리뷰 제목</p>
			      <p id="reviewquestion2">강사님의 인상 깊은 점을 적어주세요</p>
			    </div>
			    
			    <div id="reviewid">
			      <span id="teacherid">ohgym 위치 1호점</span>
			      <span>|</span>
			      <span id="exercisetype">헬스장</span>
			    </div>
			    
			    <div>
			      <textarea id="reviewtext" maxlength="200"></textarea>
			    </div>
			    
			    <div id="reviewscorediv">
			      <label id="reviewscore">별점</label>
			    </div>
			    
			    <div id="cancelokdiv">
			      <button id="cancelreviewbtn">취소</button>
			      <button id="okreviewbtn">확인</button>
			    </div>
			    
			  </div>
			</div>
	      </main>
      <footer><%@ include file="footer.jsp" %></footer>
    </div>
</body>
<script src="./js/reviewwrite.js"></script>
</html>