<%@page import="ohgym.teacher.TeacherProfile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Oh!gym</title>
    <link rel="stylesheet" type="text/css" href="./css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./css/profilestyle.css" />
  </head>
  <body>
  <%
  TeacherProfile profile = (TeacherProfile) request.getAttribute("profile");
  System.out.println(profile);
  String[] timeArr = profile.getContactTime().split("-");
  String start = timeArr[0];
  String end = timeArr[1];
  
  String[] locationArr = profile.getLocation().split("/");
  String address = locationArr[0];
  String detailedAddress = locationArr[1];
  
  String careerYear = profile.getCareer().substring(0, profile.getCareer().indexOf("년"));
  String careerMonth;
  if((profile.getCareer().indexOf("개") >= 0) && (profile.getCareer().indexOf("년") + 1 >= 0)) {
	  careerMonth = profile.getCareer().substring((profile.getCareer().indexOf("년") + 1), profile.getCareer().indexOf("개")); 
  } else {
	  careerMonth = "0";
  }
  %>
    <div class="container">
      <header><%@ include file="header.jsp" %></header>
      <main>
        <section id="profile-overview">
            <section id="welcome">
              <div id="image-background">
                <img id="profile-image" src="<%= profile.getImage() %>" />
                <label for="image-input" id="image-icon"></label>
                <input type="file" id="image-input" style="display: none;" accept=".jpg,.jpeg,.png"></label>
              </div>
              <div>
                <p id="userId"><%= profile.getId() %> 근선생님</p>
                <p>어서오세요!</p>
              </div>
            </section>
            <section id="teacher-info">
              <ul>
                <li>
                  <section><b>0</b></section>
                  <section>리뷰 평점</section>
                </li>
                <li class="divider"></li>
                <li>
                  <section><b>0</b></section>
                  <section>리뷰수</section>
                </li>
                <li class="divider"></li>
                <li>
                  <section><b>0</b></section>
                  <section>고용수</section>
                </li>
              </ul>
            </section>
          </section>
          <section id="comps">
            <article class="info-comp">
              <div class="heading">
                <div>
                  <h2>한줄소개</h2>
                </div>
                <div class="modify" id="appeal-save">수정</div>
              </div>
              <div class="value" id="appeal"><%= profile.getAppeal() %></div>
            </article>
            <article class="info-comp">
              <div class="heading">
                <div>
                  <h2>연락가능 시간</h2>
                </div>
                <div class="modify" id="time-save">저장</div>
              </div>
              <div class="info-contactTime" id="info-contactTime">
                <input id="start-time" type="time" value="<%= start %>"></input>&nbsp;&nbsp;~&nbsp;&nbsp; 
                <input id="end-time" type="time" value="<%= end %>"></input>
              </div>
            </article>
            <article class="info-comp">
              <div class="heading">
                <div>
                  <h2>대표서비스</h2>
                </div>
              </div>
              <div class="service" id="service">
                <div id="services">
                  <input type="radio" name="service-btn" id="personal-training" checked="true" hidden/><label class="service-btn" for="personal-training">퍼스널트레이닝</label>
                  <input type="radio" name="service-btn" id="Pilates" checked="false" hidden/><label class="service-btn" for="Pilates">필라테스</label>
                  <input type="radio" name="service-btn" id="yoga" checked="false" hidden/><label class="service-btn" for="yoga">요가</label>
                  <input type="radio" name="service-btn" id="climbing" checked="false" hidden/><label class="service-btn" for="climbing">클라이밍</label>
                  <input type="radio" name="service-btn" id="spinning" checked="false" hidden/><label class="service-btn" for="spinning">스피닝</label>
                  <input type="radio" name="service-btn" id="crossfit" checked="false" hidden/><label class="service-btn" for="crossfit">크로스핏</label>
                  <input type="radio" name="service-btn" id="ballet" checked="false" hidden/><label class="service-btn" for="ballet">발레</label>
                  <input type="radio" name="service-btn" id="swimming" checked="false" hidden/><label class="service-btn" for="swimming">수영</label>
                  <input type="radio" name="service-btn" id="health" checked="false" hidden/><label class="service-btn" for="health">헬스</label>
                  <input type="radio" name="service-btn" id="etc" checked="false" hidden/><label class="service-btn" for="etc">기타</label>
                </div>
              </div>
            </article>
            <article class="info-comp">
              <div class="heading">
                <div>
                  <h2>서비스 소개</h2>
                </div>
                <div class="modify" id="introduction-save">수정</div>
              </div>
              <div class="value" id="introduction"><%= profile.getIntroduction() %></div>
            </article>
            <article class="info-comp">
              <div class="heading">
                <div>
                  <h2>센터명</h2>
                </div>
                <div class="modify" id="centerName-save">수정</div>
              </div>
              <div class="value" id="centerName"><%= profile.getCenterName() %></div>
            </article>
            <article class="info-comp">
              <div class="heading">
                <div>
                  <h2>위치</h2>
                </div>
                <div class="modify" id="address-save">저장</div>
              </div>
              <div class="address" id="address">
                <input type="text" class="input-style" id="input-address" value="<%= address %>" placeholder="주소를 입력해주세요" readonly/>
                <input type="text" class="input-style" id="input-detailed-address" value="<%= detailedAddress %>" placeholder="상세 주소"/>
              </div>
            </article>
            <article class="info-comp">
              <div class="heading">
                <div>
                  <h2>경력</h2>
                </div>
                <div class="modify" id="career-save">저장</div>
              </div>
              <div class="career" id="career">
                <input class="input-style" id="input-career" type="number" value="<%= careerYear %>" max="100" min="0" placeholder="경력을 입력해주세요"/><span class="career-text">년</span>
                <input class="input-style" id="input-career-month" type="number" value="<%= careerMonth %>" max="11" min="0" placeholder="경력을 입력해주세요"/><span class="career-text">개월</span>
              </div>
            </article>
          </section>
      </main>
      <footer><%@ include file="footer.jsp" %></footer>
    </div>
  </body>
  <!-- <script src="./js/profile.js"></script> -->
</html>
