<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="menu">
        <div id="logo">
            <a href="index.html"><img src="./img/logo.png" alt="logo"></a>
        </div>
        <div id="menu-bar">
            <a href="">근선생매칭</a> 
            <a href="./search.jsp">근선생찾기</a>
            <a href="">커뮤니티</a>
            <input type="search" placeholder="어떤 서비스가 필요하세요?"></input>
        </div>
<% 
        if(true) { // 로그아웃
%>
        <div id="login">
            <a href="./login.html">로그인</a>
            <a href="./signup.html">회원가입</a>
            <div id="teacher-join"><a href="./signup.html">근선생가입</a></div>
        </div>
<%        	        	
        } else { // 로그인 
%>
            <div id="login">
                <a href="">알림</a>
                <a href="">요청보기</a>
                <a href="">마이페이지</a>
                <div id="teacher-join"><a href="./signup.html">근선생가입</a></div>
            </div>
<%        		
        }
%>
        
    </div>  
</body>
</html>