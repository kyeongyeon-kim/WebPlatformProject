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
			    
			    <p id="reviewquestion">리뷰를 작성해주세요</p>
			    
			    <div id="reviewid">
			      <p id="exercisetype">퍼스널트레이닝</p>
			      <p id="teacherid">ohgym 부산 1호점</p>
			    </div>
			    
				<div class="starpoint_wrap">
					<div class="starpoint_box">
						<label for="starpoint_1" class="label_star" title="0.5"><span class="blind">0.5점</span></label>
						<label for="starpoint_2" class="label_star" title="1"><span class="blind">1점</span></label>
						<label for="starpoint_3" class="label_star" title="1.5"><span class="blind">1.5점</span></label>
						<label for="starpoint_4" class="label_star" title="2"><span class="blind">2점</span></label>
						<label for="starpoint_5" class="label_star" title="2.5"><span class="blind">2.5점</span></label>
						<label for="starpoint_6" class="label_star" title="3"><span class="blind">3점</span></label>
						<label for="starpoint_7" class="label_star" title="3.5"><span class="blind">3.5점</span></label>
						<label for="starpoint_8" class="label_star" title="4"><span class="blind">4점</span></label>
						<label for="starpoint_9" class="label_star" title="4.5"><span class="blind">4.5점</span></label>
						<label for="starpoint_10" class="label_star" title="5"><span class="blind">5점</span></label>
						<input type="radio" name="starpoint" id="starpoint_1" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_2" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_3" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_4" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_5" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_6" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_7" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_8" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_9" class="star_radio">
						<input type="radio" name="starpoint" id="starpoint_10" class="star_radio">
						<span class="starpoint_bg"></span>
					</div>
				</div>
				
			    <div>
			      <textarea id="reviewtext" maxlength="200"></textarea>
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