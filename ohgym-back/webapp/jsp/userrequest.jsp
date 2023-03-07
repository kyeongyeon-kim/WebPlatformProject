<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../css/framestyle.css">
    <link rel="stylesheet" type="text/css" href="../css/indexstyle.css">
    <link rel="stylesheet" type="text/css" href="../css/userrequest.css">
    <script src="../js/include.js"></script>
    <script src="../js/header.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
</head>
<body>
    <div class="container">
        <header><%@ include file="header.jsp" %></header>
        <main>
            <section id="banner" style="height: 250px;">
            <section class="container">
                <article id="fields">
                    <div style="position: relative; display: flex; justify-content: center; color: white;">
                        <div style="width: 800px; height: 240px; position: absolute; z-index: -2; background-color: rgba(0, 0, 0, 0.3);" ></div>
                        <img src="../img/userrequestimg9.png" id="bannerimg" style="width: 800px; height: 240px; position: absolute; z-index: -3;">
                        <div style="margin-top: 35px; position: absolute; z-index: -1; text-align: center;">
                            <p style="font-size: 50px; font-weight: bold;" id="category"></p>
                            <p style="font-size: 18px; font-weight: bold; margin: 10px 0px 10px 0px;" id="score">평점: 0.0</p>
                            <div style="display: flex;">
                                <div style="text-align: center;">
                                    <p style="font-size: 25px;" id="active">0</p>
                                    <p style="font-size: 14px;">활동 고수</p>
                                </div>
                                <p style="margin: 0px 30px 0px 30px;font-size: 40px; ">ㅣ</p>
                                <div style="text-align: center;">
                                    <p style="font-size: 25px;" id="accreq">0</p>
                                    <p style="font-size: 14px;">누적 요청서</p>
                                </div>
                                <p style="margin: 0px 30px 0px 30px;font-size: 40px;">ㅣ</p>
                                <div style="text-align: center;">
                                    <p style="font-size: 25px;" id="reviewnum">0</p>
                                    <p style="font-size: 14px; ">리뷰 수</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
            </section>
        </section>
        <!--//banner-->
        <section id="contents">
            <section id="content1">
                <article class="container">

                    <div id="contentdiv">
                        <div style="margin-bottom: 50px; text-align: center;">
                            <p>진행상황</p>
                            <progress id="progress" value="1" min="0" max="8"></progress>
                            <label id="progresslbl">1/8</label>
                        </div>      

                        <div style="margin-bottom: 80px;">
                            <p id="question" >레슨을 받는 목적이 무엇인가요?</p>
                        </div>                    

                        <div id="page1">
                            <div class="checkbtndiv">
                                <label for="page1checkbox1" class="checkboxlbl">
                                    <input type='checkbox' id="page1checkbox1"/><label class="checklbl" for="page1checkbox1">다이어트</label>
                                </label>
                                <label for="page1checkbox2" class="checkboxlbl">
                                    <input type='checkbox' id="page1checkbox2"/><label class="checklbl" for="page1checkbox2">근력강화</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page1checkbox3" class="checkboxlbl">
                                    <input type='checkbox' id="page1checkbox3"/><label class="checklbl" for="page1checkbox3">체중증가</label>
                                </label>
                                <label for="page1checkbox4" class="checkboxlbl">
                                    <input type='checkbox' id="page1checkbox4"/><label class="checklbl" for="page1checkbox4">체력증진</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page1checkbox5" class="checkboxlbl">
                                    <input type='checkbox' id="page1checkbox5"/><label class="checklbl" for="page1checkbox5">체형 교정</label>
                                </label>
                                <label for="page1checkbox6" class="checkboxlbl">
                                    <input type='checkbox' id="page1checkbox6"/><label class="checklbl" for="page1checkbox6">재활/통증케어</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page1checkbox7" class="checkboxlbl">
                                    <input type='checkbox' id="page1checkbox7"/><label class="checklbl" for="page1checkbox7">바디프로필</label>
                                </label>
                                <label for="page1checkbox8" class="checkboxlbl">
                                    <input type='checkbox' id="page1checkbox8"/><label class="checklbl" for="page1checkbox8">대회준비</label>
                                </label>
                            </div>
    
                            <div class="checkbtndiv">
                                <label for="textcheckbox" id="textlbl">
                                    <div style="display: flex;">
                                        <input type='checkbox' id="textcheckbox" /><label class="checklbl" for="textcheckbox">기타</label>
                                    </div>
                                    <div style="display: flex; justify-content: center;">
                                        <textarea id="inputtext" class="inputtext" ></textarea>
                                    </div>
                                    <label id="inputtextlabel" style="display: none; color: lightgray; margin-left: 55px; ">일부 특수문자( `'"()[]{}/\ ) 및 최대 40글자 제한</label>
                                </label>
                            </div>
                        </div>

                        <div id="page2" class="page">
                            <div class="checkbtndiv">
                                <label for="page2checkbox1" class="checkboxlbl">
                                    <input type='checkbox' id="page2checkbox1"/><label class="checklbl" for="page2checkbox1">개인 레슨</label>
                                </label>
                                <label for="page2checkbox2" class="checkboxlbl">
                                    <input type='checkbox' id="page2checkbox2"/><label class="checklbl" for="page2checkbox2">그룹 레슨</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page2checkbox3" class="checkboxlbl">
                                    <input type='checkbox' id="page2checkbox3"/><label class="checklbl" for="page2checkbox3">온라인/화상 레슨</label>
                                </label>
                                <label for="page2checkbox4" class="checkboxlbl">
                                    <input type='checkbox' id="page2checkbox4"/><label class="checklbl" for="page2checkbox4">무관</label>
                                </label>
                            </div>
    
                            <div class="checkbtndiv">
                                <label for="textcheckbox2" id="textlbl">
                                    <div style="display: flex;">
                                        <input type='checkbox' id="textcheckbox2" /><label class="checklbl" for="textcheckbox2">기타</label>
                                    </div>
                                    <div style="display: flex; justify-content: center;">
                                        <textarea id="inputtext2" class="inputtext" ></textarea>
                                    </div>
                                    <label id="inputtextlabel2" style="display: none; color: lightgray; margin-left: 55px; ">일부 특수문자( `'"()[]{}/\ ) 및 최대 40글자 제한</label>
                                </label>
                            </div>
                        </div>

                        <div id="page3" class="page">
                            <div class="checkbtndiv">
                                <label for="page3checkbox1" class="checkboxlbl">
                                    <input type='checkbox' id="page3checkbox1"/><label class="checklbl" for="page3checkbox1">월요일</label>
                                </label>
                                <label for="page3checkbox2" class="checkboxlbl">
                                    <input type='checkbox' id="page3checkbox2"/><label class="checklbl" for="page3checkbox2">화요일</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page3checkbox3" class="checkboxlbl">
                                    <input type='checkbox' id="page3checkbox3"/><label class="checklbl" for="page3checkbox3">수요일</label>
                                </label>
                                <label for="page3checkbox4" class="checkboxlbl">
                                    <input type='checkbox' id="page3checkbox4"/><label class="checklbl" for="page3checkbox4">목요일</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page3checkbox5" class="checkboxlbl">
                                    <input type='checkbox' id="page3checkbox5"/><label class="checklbl" for="page3checkbox5">금요일</label>
                                </label>
                                <label for="page3checkbox6" class="checkboxlbl">
                                    <input type='checkbox' id="page3checkbox6"/><label class="checklbl" for="page3checkbox6">토요일</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page3checkbox7" class="checkboxlbl">
                                    <input type='checkbox' id="page3checkbox7"/><label class="checklbl" for="page3checkbox7">일요일</label>
                                </label>
                                <label for="page3checkbox8" class="checkboxlbl">
                                    <input type='checkbox' id="page3checkbox8"/><label class="checklbl" for="page3checkbox8">무관</label>
                                </label>
                            </div>
                        </div>

                        <div id="page4" class="page">
                            <div class="checkbtndiv">
                                <label for="page4checkbox1" class="checkboxlbl">
                                    <input type='checkbox' id="page4checkbox1"/><label class="checklbl" for="page4checkbox1">09시 이전</label>
                                </label>
                                <label for="page4checkbox2" class="checkboxlbl">
                                    <input type='checkbox' id="page4checkbox2"/><label class="checklbl" for="page4checkbox2">09~12시</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page4checkbox3" class="checkboxlbl">
                                    <input type='checkbox' id="page4checkbox3"/><label class="checklbl" for="page4checkbox3">12~15시</label>
                                </label>
                                <label for="page4checkbox4" class="checkboxlbl">
                                    <input type='checkbox' id="page4checkbox4"/><label class="checklbl" for="page4checkbox4">15~18시</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page4checkbox5" class="checkboxlbl">
                                    <input type='checkbox' id="page4checkbox5"/><label class="checklbl" for="page4checkbox5">18~21시</label>
                                </label>
                                <label for="page4checkbox6" class="checkboxlbl">
                                    <input type='checkbox' id="page4checkbox6"/><label class="checklbl" for="page4checkbox6">21시 이후</label>
                                </label>
                            </div>
                        </div>

                        <div id="page5" class="page">
                            <div class="checkbtndiv">
                                <label for="page5checkbox1" class="checkboxlbl">
                                    <input type='checkbox' id="page5checkbox1"/><label class="checklbl" for="page5checkbox1">남자</label>
                                </label>
                                <label for="page5checkbox2" class="checkboxlbl">
                                    <input type='checkbox' id="page5checkbox2"/><label class="checklbl" for="page5checkbox2">여자</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page5checkbox3" class="checkboxlbl">
                                    <input type='checkbox' id="page5checkbox3"/><label class="checklbl" for="page5checkbox3">혼성</label>
                                </label>
                                <label class="checkboxlbl" >
                                </label>
                            </div>
                        </div>

                        <div id="page6" class="page">
                            <div class="checkbtndiv">
                                <label for="page6checkbox1" class="checkboxlbl">
                                    <input type='checkbox' id="page6checkbox1"/><label class="checklbl" for="page6checkbox1">10대 미만</label>
                                </label>
                                <label for="page6checkbox2" class="checkboxlbl">
                                    <input type='checkbox' id="page6checkbox2"/><label class="checklbl" for="page6checkbox2">10대</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page6checkbox3" class="checkboxlbl">
                                    <input type='checkbox' id="page6checkbox3"/><label class="checklbl" for="page6checkbox3">20대</label>
                                </label>
                                <label for="page6checkbox4" class="checkboxlbl">
                                    <input type='checkbox' id="page6checkbox4"/><label class="checklbl" for="page6checkbox4">30대</label>
                                </label>
                            </div>
                            <div class="checkbtndiv">
                                <label for="page6checkbox5" class="checkboxlbl">
                                    <input type='checkbox' id="page6checkbox5"/><label class="checklbl" for="page6checkbox5">40대</label>
                                </label>
                                <label for="page6checkbox6" class="checkboxlbl">
                                    <input type='checkbox' id="page6checkbox6"/><label class="checklbl" for="page6checkbox6">50대 이상</label>
                                </label>
                            </div>
                        </div>

                        <div id="page7" class="page">
                            <div id="adressdiv">
                                <div>
                                    <label class="addresslbl" style="margin-right: 34px;">주소</label><input type="text" class="addresstext" id="address_main" name="address" readonly />
                                </div>
                                <div style="margin-bottom: 30px;">
                                    <label class="addresslbl">상세주소</label><input type="text" class="addresstext" name="address_detail" id="address_detail"/>
                                </div>
                            </div>
                        </div>

                        <div id="page8" class="page">
                            <div style="display: flex;">
                                <label id="textlbl2">
                                    <textarea style="height: 120px; width: 100%; border: 1px solid lightgray; resize: none; " id="reqtext"></textarea>
                                    <label id="inputtextlabel2" style="color: lightgray;">일부 특수문자( `'"()[]{}/\ ) 및 최대 200글자 제한</label>
                                </label>
                            </div>
                        </div>

                        <div class="pagebtn">
                            <button id="prev"></button>
                            <button id="next" style="margin-left: 10px;"></button>
                        </div>
                        <p style="text-align: right; margin-bottom: 50px; color: lightgray;" id="pagecheckedtext">한 개 이상의 항목을 선택해주세요. </p>
                    </div>
                </article>
            </section>
            <section id="content2">
                <article class="container">
                    
                </article>
            </section>
            <section id="content3">
                <article class="container">
                    
                </article>
            </section>
        </section>

        </main>
        <footer><%@ include file="footer.jsp" %></footer>
    </div>
</body>
<script src='../js/userrequest.js'></script>
</html>