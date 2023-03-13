<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/367bc8d5b8.js" crossorigin="anonymous"></script>
</head>
<body>
	<form action="./find" method="POST">
	<div id="menu">
		<div id="logo">
			<a href="./"><img src="./img/logo.png" alt="logo"></a>
		</div>
		<div id="menu-bar">
			<a href="">근선생매칭</a> <a href="./find">근선생찾기</a> <a href="/">커뮤니티</a> 
			<input type="search" id="search-input" name="search" placeholder="어떤 서비스가 필요하세요?"><input type="submit" style="display: none"></input>
		</div>
		<%
			// session 객체에 memberId라는 session이 있으면,
		if (session.getAttribute("id") != null) {
		%>
		<div id="login">
			<p id="jsessionid" hidden><%= session.getAttribute("id") %></p>
			<a href="">요청보기</a>
			<span id="i" class="alarm">
			<i class="fa-regular fa-bell"></i><span id="num">3</span></span>
			<div class="background">
				<div class="window">
					<div class="popup">
						<h2 id="out">알림</h2>
						<p id="context">받은요청</p>
						<button id="close">끄기</button>
						<br>
					</div>
				</div>
			</div>
		<a id="i" href="./profile"><i class="fa-regular fa-circle-user"></i></a>
		<a href="./logout">로그아웃</a>
	</div>
	</form>
	<%
		} else { // 로그인 상태
	%>
	<div id="login">
		<a href="./login">로그인</a> <a href="./signup">회원가입</a>
		<div id="teacher-join">
			<a href="./signup">근선생가입</a>
		</div>
	</div>
	<%
		}
	%>
	</div>
</body>
<script src="./js/header.js"></script>
</html>