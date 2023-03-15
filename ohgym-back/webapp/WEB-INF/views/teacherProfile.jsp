<%@page import="java.util.StringJoiner"%>
<%@page import="ohgym.teacher.TeacherProfile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./css/framestyle.css">
    <link rel="stylesheet" type="text/css" href="./css/teacherProfile.css">
    <script src="https://kit.fontawesome.com/367bc8d5b8.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <header><%@ include file="header.jsp" %></header>
        <main>
        	<%
			List<TeacherProfile> profileById = (List) request.getAttribute("profileById");
        	String exercise = "";
        	String location = "";
			StringJoiner sj = new StringJoiner(", ");
			StringJoiner sj2 = new StringJoiner(", ");
			for (TeacherProfile t : profileById) {
				sj.add(t.getExercise());
				if (!location.contains(t.getLocation())) {
					sj2.add(t.getLocation());
				}
			}
			exercise = sj.toString();
			location = sj2.toString();
			%>
            <div class="teacher-profile">
                <div id="image-background">
                    <img id="profile-image" src="<%= profileById.get(0).getImage() %>" />
                </div>
                <div class="teacher-info">
                    <h1 id="teacherId"><%= profileById.get(0).getId() %>
                    </h1>
                    <p id="main-service"><%= exercise %></p>
                    <p id="area"><i class="fa-regular fa-compass"></i><span id=area-input><%= location %></span></p>
                    <p id="time"><i class="fa-regular fa-clock"></i>연락가능 시간 : <span id="contactTime"><%= profileById.get(0).getContactTime() %></span></p>
                    <p id="appeal">
                     <%= profileById.get(0).getAppeal() %>
                    </p>
                </div>
                <div class="teacher-info2">
                    <div id="review">
                        <button><a href="">리뷰</a></button><br>
                        <p>
                            <img src="./img/star.png" alt="">
                            <span id="score-input">4.8</span>
                        </p>
                    </div>
                    <div id="career">
                        <p id="career-sum">총 경력</p>
                        <p id="career-input"><%= profileById.get(0).getCareer() %></p>
                    </div>
                </div>
                <div id="menu-tab">
                    <ul class="profile-menu">
                        <li><a href="">근선생 정보</a></li>
                        <li><a href="">리뷰</a></li>
                        <li><a href="">질문답변</a></li>
                    </ul>
                </div>
                <div class="profile-content">
                    <h2 id="profile-service">서비스 소개</h2>
                	<% for (int i = 0; i < profileById.size(); i++) { 
                		String introduction = profileById.get(i).getIntroduction().replace("\n","<br>");
                	%>
                	<div class="service-info">
	                	<p class="content-info">
	                		<i class="fa-regular fa-face-smile"></i>
	                		<%= profileById.get(i).getExercise() %>
	               		</p>
	               		<p><%= introduction %>
	               		</p>
               		</div>
               		<%
                	}
                	%>
                </div>
                <div class="review-info">
                    <h2 id="service-introduction">리뷰</h2>
                    <ul class="review-list">
                        <li id="review-content">
                            <p id="review-id">이**</p>
                            <p id="review-service">퍼스널트레이닝</p>
                            <p id="review-score">
                                <img src="./img/star.png" alt="">
                                <span id="review-score">4.8</span>
                            </p>
                            <p id="review-input">
                                어깨 통증이 오래전부터 심해서 운동을 안하게 됐는데 선생님께서 알맞는 운동위주로 퍼스널트레이닝를 진행해주셔서 어깨통증이 훨씬 사라지고 전체적인 근력도 올라간거 같아서 너무 좋아요!!!!:)
                            </p>
                        </li>
                        <li id="review-content">
                            <p id="review-id">김**</p>
                            <p id="review-service">크로스핏</p>
                            <p id="review-score">
                                <img src="./img/star.png" alt="">
                                <span id="review-score">4.8</span>
                            </p>
                            <p id="review-input">
                                어깨 통증이 오래전부터 심해서 운동을 안하게 됐는데 선생님께서 알맞는 운동위주로 퍼스널트레이닝를 진행해주셔서 어깨통증이 훨씬 사라지고 전체적인 근력도 올라간거 같아서 너무 좋아요!!!!:)
                            </p>
                        </li>
                    </ul>
                </div>
            </div>
            <aside class="aside-bar">
                <div class="request">
                    <p id="request-content"><span id="teacher-id"><%= profileById.get(0).getId() %></span> 근선생님에게 원하는 <br>서비스의 견적을 받아보세요</p>
                    <div class="wish-bar">
                        <button id="wish">
                            <i class="fa-solid fa-heart"></i>
                        </button>
                        <button id="request-btn"><a href="">견적 요청</a></button>
                    </div>
                    
                    <div></div>
                </div>
            </aside>
        </main>
        <footer><%@ include file="footer.jsp" %></footer>
    </div>
</body>
<script>
</script>
<!-- <script src="./js/teacherProfile.js"></script> -->
</html>