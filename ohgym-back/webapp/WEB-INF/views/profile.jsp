<%@page import="ohgym.teacher.TeacherProfile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Oh!gym</title>
    <link rel="stylesheet" type="text/css" href="./resource/css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./resource/css/profilestyle.css" />
  </head>
  <body>
  <%
  TeacherProfile profile = (TeacherProfile) request.getAttribute("profile");
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
  
  String[] checkedArr = {"", "", "", "", "", "", "", "", "", ""};
  switch (profile.getExercise()) {
  	case "퍼스널트레이닝":
  		checkedArr[0] = "checked";
  		break;
  	case "필라테스":
  		checkedArr[1] = "checked";
  		break;
  	case "요가":
  		checkedArr[2] = "checked";
  		break;
  	case "클라이밍":
  		checkedArr[3] = "checked";
  		break;
  	case "스피닝":
  		checkedArr[4] = "checked";
  		break;
  	case "크로스핏":
  		checkedArr[5] = "checked";
  		break;
  	case "발레":
  		checkedArr[6] = "checked";
  		break;
  	case "수영":
  		checkedArr[7] = "checked";
  		break;
  	case "헬스":
  		checkedArr[8] = "checked";
  		break;
  	case "기타":
  		checkedArr[9] = "checked";
  		break;
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
                  <input type="radio" name="service-btn" id="personal-training" <%= checkedArr[0] %> hidden/><label class="service-btn" for="personal-training">퍼스널트레이닝</label>
                  <input type="radio" name="service-btn" id="Pilates" <%= checkedArr[1] %> hidden/><label class="service-btn" for="Pilates">필라테스</label>
                  <input type="radio" name="service-btn" id="yoga" <%= checkedArr[2] %> hidden/><label class="service-btn" for="yoga">요가</label>
                  <input type="radio" name="service-btn" id="climbing" <%= checkedArr[3] %> hidden/><label class="service-btn" for="climbing">클라이밍</label>
                  <input type="radio" name="service-btn" id="spinning" <%= checkedArr[4] %> hidden/><label class="service-btn" for="spinning">스피닝</label>
                  <input type="radio" name="service-btn" id="crossfit" <%= checkedArr[5] %> hidden/><label class="service-btn" for="crossfit">크로스핏</label>
                  <input type="radio" name="service-btn" id="ballet" <%= checkedArr[6] %> hidden/><label class="service-btn" for="ballet">발레</label>
                  <input type="radio" name="service-btn" id="swimming" <%= checkedArr[7] %> hidden/><label class="service-btn" for="swimming">수영</label>
                  <input type="radio" name="service-btn" id="health" <%= checkedArr[8] %> hidden/><label class="service-btn" for="health">헬스</label>
                  <input type="radio" name="service-btn" id="etc" <%= checkedArr[9] %> hidden/><label class="service-btn" for="etc">기타</label>
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
    <template id="input-form">
      <div>
        <input
          type="text"
          class="input-form"
          value=""
          placeholder="내용을 입력해 주세요"
        />
        <p>내용을 입력해 주세요</p>
      </div>
    </template>
  </body>
  <script src="./resource/js/profile.js"></script>
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    window.onload = function() {
        document.getElementById("input-address").addEventListener("click", function() { //주소입력칸을 클릭하면
            //카카오 지도 발생
            new daum.Postcode({
                oncomplete: function(data) { //선택시 입력값 세팅
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                document.getElementById("input-address").value = data.address; // 주소 넣기
                document.getElementById("input-detailed-address").focus(); //상세입력 포커싱
            }
        }).open();
    });
  }
  </script>
</html>
