<%@page import="java.util.ArrayList"%>
<%@page import="ohgym.teacher.TeacherProfile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="./resource/css/framestyle.css">
<link rel="stylesheet" type="text/css" href="./resource/css/searchstyle.css">
<script src="https://kit.fontawesome.com/367bc8d5b8.js"
	crossorigin="anonymous"></script>
</head>
<%
	String area = (String) request.getAttribute("area");
	String[] selectedArr = new String[17];
	for (int i = 0; i < selectedArr.length; i++) {
		selectedArr[i] = "";
	}
if (area != null) {
	switch (area) {
	case "seoul":
		selectedArr[0] = "selected";
		break;
	case "sejong":
		selectedArr[1] = "selected";
		break;
	case "gangwon":
		selectedArr[2] = "selected";
		break;
	case "incheon":
		selectedArr[3] = "selected";
		break;
	case "gyeongi":
		selectedArr[4] = "selected";
		break;
	case "chungbuk":
		selectedArr[5] = "selected";
		break;
	case "chungnam":
		selectedArr[6] = "selected";
		break;
	case "gyeongbuk":
		selectedArr[7] = "selected";
		break;
	case "daejeon":
		selectedArr[8] = "selected";
		break;
	case "daegu":
		selectedArr[9] = "selected";
		break;
	case "jeonbuk":
		selectedArr[10] = "selected";
		break;
	case "gyeongnam":
		selectedArr[11] = "selected";
		break;
	case "ulsan":
		selectedArr[12] = "selected";
		break;
	case "gwangju":
		selectedArr[13] = "selected";
		break;
	case "busan":
		selectedArr[14] = "selected";
		break;
	case "jeonnam":
		selectedArr[15] = "selected";
		break;
	case "jeju":
		selectedArr[16] = "selected";
		break;
	}
}
%>
<body>
	<div class="container">
		<header><%@ include file="header.jsp"%></header>
		<main>
			<h1>근선생 찾기</h1>
			<select id="type" name="type">
				<option value="none">서비스 선택</option>
				<option value="pt">퍼스널트레이닝</option>
				<option value="crossfit">크로스핏</option>
				<option value="pilates">필라테스</option>
				<option value="yoga">요가</option>
				<option value="climing">클라이밍</option>
				<option value="spinning">스피닝</option>
				<option value="ballet">발레</option>
				<option value="swimming">수영</option>
				<option value="health">헬스</option>
				<option value="etc">기타</option>
			</select> <select id="area" name="area">
				<option value="none">지역</option>
				<option value="seoul" <%=selectedArr[0]%>>서울</option>
				<option value="sejong" <%=selectedArr[1]%>>세종</option>
				<option value="gangwon" <%=selectedArr[2]%>>강원</option>
				<option value="incheon" <%=selectedArr[3]%>>인천</option>
				<option value="gyeongi" <%=selectedArr[4]%>>경기</option>
				<option value="chungbuk" <%=selectedArr[5]%>>충북</option>
				<option value="chungnam" <%=selectedArr[6]%>>충남</option>
				<option value="gyeongbuk" <%=selectedArr[7]%>>경북</option>
				<option value="daejeon" <%=selectedArr[8]%>>대전</option>
				<option value="daegu" <%=selectedArr[9]%>>대구</option>
				<option value="jeonbuk" <%=selectedArr[10]%>>전북</option>
				<option value="gyeongnam" <%=selectedArr[11]%>>경남</option>
				<option value="ulsan" <%=selectedArr[12]%>>울산</option>
				<option value="gwangju" <%=selectedArr[13]%>>광주</option>
				<option value="busan" <%=selectedArr[14]%>>부산</option>
				<option value="jeonnam" <%=selectedArr[15]%>>전남</option>
				<option value="jeju" <%=selectedArr[16]%>>제주</option>
			</select>
			<div class="search">
				<input id="search" type="search" placeholder="내 주변 근선생은 누가 있지?" 
       			<% if (request.getAttribute("inputText") != null) { %>value="<%=request.getAttribute("inputText")%>"<%}%> />
				<button id="search-btn">검색</button>
			</div>
			<%
				List<TeacherProfile> list = (List) request.getAttribute("list");
			for (TeacherProfile t : list) {
				String url = "/ohgym/profileId?id=" + t.getId();
				String info = (t.getId() + t.getExercise() + t.getLocation()).replaceAll("\\s", "");
				String address = t.getLocation();
				String[] location = address.split(" ");
			%>
			<section class="profile-container" id=<%=t.getExercise()%>
				data-area=<%=location[0]%> data-info=<%=info%>>
				<article class="profile">
					<a href=<%=url%>>
						<div class="info">
							<h3 id="id"><%=t.getId()%></h3>
							<div class="contents">
								<i class="fa-solid fa-magnifying-glass"></i>
								<p id="exercise"><%=t.getExercise()%></p>
							</div>
							<div class="contents">
								<i class="fa-regular fa-circle-user"></i>
								<p id="appeal"><%=t.getAppeal()%></p>
							</div>
							<div class="contents">
								<i class="fa-regular fa-clock"></i>
								<p id="contactTime"><%=t.getContactTime()%></p>
							</div>
							<div class="contents">
								<i class="fa-regular fa-compass"></i>
								<p id="centerLocation"><%=t.getLocation()%></p>
							</div>
							<div class="score">
								<img src="./resource/img/star.png" alt=""> <span id="score">4.8</span>
							</div>
						</div>
						<div class="profile-img">
							<img id="image" src="<%=t.getImage()%>" alt=" profile-img">
						</div>
					</a>
				</article>
			</section>
			<%
				}
			%>
		</main>
		<footer><%@ include file="footer.jsp"%></footer>
	</div>
</body>
<script src="./resource/js/find.js"></script>
</html>