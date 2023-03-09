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
            <a href="./"><img src="./img/logo.png" alt="logo"></a>
        </div>
        <div id="menu-bar">
            <a href="">근선생매칭</a> 
            <a href="./find">근선생찾기</a>
            <a href="">커뮤니티</a>
            <input type="search" placeholder="어떤 서비스가 필요하세요?"></input>
        </div>
		<% 		
		// session 객체에 memberId라는 session이 있으면,
		if (session.getAttribute("user") != null) {
		%>
			<div id="login">
                <a href="">알림</a>
                <a href="">요청보기</a>
                <a href="">마이페이지</a>   
            </div>
		<%        	        	
        } else { // 로그인 상태
		%>
        <div id="login">
            <a href="./login">로그인</a>
            <a href="./signup">회원가입</a>
            <div id="teacher-join"><a href="./signup">근선생가입</a></div>
        </div>
		<%        		
        }
		%>
    </div>  
</body>
</html>