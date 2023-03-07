<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="../css/detailRequest.css">
    <!-- <link rel="stylesheet" type="text/css" href="../css/mypage.css"> -->
    <!-- <script src="../js/testmodal.js"></script> -->
    <script src="../js/include.js"></script>
    <script src="../js/header.js"></script>
    <script src="https://kit.fontawesome.com/367bc8d5b8.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <div class="container">
      <header><%@ include file="header.jsp" %></header>
      <main>
        <div id="title">
          <h1>요청사항</h1>
        </div>
        <div class="history">
          <h3><a href="#">받은내역</a></h3>
          <div class="box">
            <div>
              <ul id="detailRequest"></ul>
            </div>
          </div>
        </div>
      </main>
      <div id = "modal">
        <div class="modal_content">
              <h2> 모달 창 </h2>
              <p></p>
              <p></p>
              <button type="button" id="modalclosebtn">닫기</button>
        </div>
        <div class="modal_layer"></div>
  </div>
 

  <template id="pick-card-temp" >
        <a href="#">
        <li>
              <div id="pick-card" style="display: flex;">
                    <div>
                    <p></p>
                    <p></p>
                    <div style="display:flex; align-items: flex-start;">
                    <img class="score" src="../img/star.png" alt="">
                    <span id="score">4.8</span>
                    </div>
                     </div>
                    <img id="pick-image" src="../img/health.png" alt="techer-img">
              </div>
        </a>  
        </li>
  </template>
  <template id="detailRequest-card-temp">
        <li>
              <div id="detailRequest-card">
                    <p></p>
                    <p></p>
                    <p></p>
              </div>
              <div class="bottom">
                    <button type="button" id="modalopenbtn"> 견적서 보기</button>
              </div>
        </li>
  </template>
      <footer><%@ include file="footer.jsp" %></footer>
    </div>
  </body>
</html>
