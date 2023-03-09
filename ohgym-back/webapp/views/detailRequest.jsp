<%@page import="ohgym.suggest.Suggest"%> <%@page import="java.util.List"%> <%@
page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="./css/framestyle.css" />
    <link rel="stylesheet" type="text/css" href="./css/detailRequest.css" />
  </head>
  <body>
      <header><%@ include file="header.jsp" %></header>
      <main>
        <div id="title">
          <h1>요청사항</h1>
        </div>
        <div class="history">
          <h3><a href="#">받은내역</a></h3>
          <div class="box">
            <div>
              <ul id="detailRequest">
                <c:forEach var="suggest" items="${ detailRequest }">
                  <li>
                    <div id="detailRequest-card">
                      <p>${ suggest.id }</p>
                      <p>💬 ${ suggest.message }</p>
                      <p>💸 ${ suggest.price }</p>
                    </div>
                    <div class="bottom">
                      <button type="button" id="modalopenbtn-${suggest.id}">
                        견적서 보기
                      </button>
                    </div>
                  </li>
                </c:forEach>
              </ul>
            </div>
          </div>
        </div>
      </main>
      <c:forEach var="suggest" items="${ detailRequest }">
      <div id="modal">
          <div class="modal_content">
            <h2>모달 창</h2>
          <p></p>
          <p></p>
           <button type="button" id="modalclosebtn">닫기</button>
          </div>
          <div class="modal_layer"></div>

      </div> 
      </c:forEach>
      <footer><%@ include file="footer.jsp" %></footer>
    </div>
  </body>
  <script>

    const openBtns = document.querySelectorAll('[id^="modalopenbtn-"]');
    // id^ = id 뒤에 어떤게 붙던지간에
    openBtns.forEach((btn) => {
      btn.addEventListener("click", function () {
        const id = btn.id.split("-")[1];
        document.getElementById(`modal`).style.display = "block";
      });
    });
    document.getElementById("modalclosebtn").addEventListener("click", function () {
    document.getElementById("modal").style.display = "none";
  });
</script>

</script>
</html>
