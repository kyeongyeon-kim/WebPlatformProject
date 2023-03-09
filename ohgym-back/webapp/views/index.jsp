<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Oh!gym</title>
    <link rel="stylesheet" type="text/css" href="./css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./css/indexstyle.css" />
  </head>
  <body>
    <div class="container">
      <header><%@ include file="header.jsp" %></header>
      <main>
        <section id="banner">
          <section class="container">
            <article id="fields">
              <a href="#"><img src="./img/cpt.png" />PT</a>
              <a href="#"><img src="./img/ccrossfit.png" />크로스핏</a>
              <a href="#"><img src="./img/cpilates.png" />필라테스</a>
              <a href="#"><img src="./img/cyoga.png" />요가</a>
              <a href="#"><img src="./img/cclimbing.png" />클라이밍</a>
              <a href="#"><img src="./img/cbicycle.png" />스피닝</a>
              <a href="#"><img src="./img/cballet.png" />발레</a>
              <a href="#"><img src="./img/cswim.png" />수영</a>
              <a href="#"><img src="./img/chealth.png" />헬스</a>
              <a href="#"><img src="./img/cetc.png" />기타</a>
            </article>
          </section>
        </section>
        <!--//banner-->
        <section id="contents">
          <section id="content1">
            <article class="container">
              <section id="by-region">
                <section id="region-text">
                  <p>
                    <strong>전국 숨은 근선생</strong>
                  </p>
                  <p>믿을 수 있는 전문가를</p>
                  <p>오짐 단 한 곳에서 찾으세요</p>
                </section>
                <section class="region-btns">
                  <ul>
                    <li><a href="" class="region-btn">서울</a></li>
                    <li><a href="" class="region-btn">세종</a></li>
                    <li><a href="" class="region-btn">강원</a></li>
                    <li><a href="" class="region-btn">인천</a></li>
                    <li><a href="" class="region-btn">경기</a></li>
                    <li><a href="" class="region-btn">충북</a></li>
                    <li><a href="" class="region-btn">충남</a></li>
                    <li><a href="" class="region-btn">경북</a></li>
                    <li><a href="" class="region-btn">대전</a></li>
                    <li><a href="" class="region-btn">대구</a></li>
                    <li><a href="" class="region-btn">전북</a></li>
                    <li><a href="" class="region-btn">경남</a></li>
                    <li><a href="" class="region-btn">울산</a></li>
                    <li><a href="" class="region-btn">광주</a></li>
                    <li><a href="" class="region-btn">부산</a></li>
                    <li><a href="" class="region-btn">전남</a></li>
                    <li><a href="" class="region-btn">제주</a></li>
                  </ul>
                </section>
              </section>
            </article>
          </section>
          	<div class="slider" id="sportbanner">
			  <img src="./img/summerbanner.png"/>
              <img src="./img/eventbanner.png" />
              <img src="./img/sportbanner.png"/>
          	</div>
         	<div>	
              <img id="instruction" src="./img/instruction.png"/>
            </div> 
       <%--  <section id="content2">
            <article class="container">
              <div id="tip-page">
              </div>
            </article>
          </section>   --%>
          <section id="content3">
            <section class="container">
              <div>
                <p>전문가로 활동하시나요?</p>
                <p>오짐에서 새로운 고객을 만나보세요</p>
                <a href="#">근선생가입</a>
              <div></div>
              </div>
            </section>
          </section>
        </section>
      </main>
      <footer><%@ include file="./footer.jsp" %></footer>
    </div>
  </body>
  <script src="./js/index.js"></script>
</html>
