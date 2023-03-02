includeHTML();
window.onload = function(){
    document.getElementById("address_main").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            document.getElementById("address_main").value = data.address; // 주소 넣기
            document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
        }
    }).open();
});
}

var params = new URLSearchParams(window.location.search);
var categorystr = params.get('category');

var category = document.getElementById("category");
var reviewnum = document.getElementById("reviewnum");
var score = document.getElementById("score");
var active = document.getElementById("active");
var accreq = document.getElementById("accreq");

fetch('http://localhost:8080/ohgym/userresp?category=' + categorystr)
.then((resp) => resp.json())
.then((arr) => {
    let bannerimg = document.getElementById("bannerimg");
    if (categorystr.length == 2){
        bannerimg.src = '../img/userrequestimg' + categorystr[1] + '.png';
    } else if (categorystr.length == 3){
        bannerimg.src = '../img/userrequestimg' + categorystr[1] + categorystr[2] + '.png';
    }
    accreq.textContent = arr[0];
    score.textContent = "평점: " + arr[1];
    reviewnum.textContent = arr[2];
    active.textContent = arr[3];
    category.textContent = arr[4];
}); 

var pagenum = 1;

var question = document.getElementById("question");

var page1 = document.getElementById("page1");
var page2 = document.getElementById("page2");
var page3 = document.getElementById("page3");
var page4 = document.getElementById("page4");
var page5 = document.getElementById("page5");
var page6 = document.getElementById("page6");
var page7 = document.getElementById("page7");
var page8 = document.getElementById("page8");

var progress = document.getElementById("progress");
var progresslbl = document.getElementById("progresslbl");

var prev = document.getElementById("prev");
var next = document.getElementById("next");
var pagecheckedtext = document.getElementById("pagecheckedtext");

var textcheckbox = document.getElementById("textcheckbox");
var inputtext = document.getElementById("inputtext");
var inputtextlabel = document.getElementById("inputtextlabel");
textcheckbox.addEventListener("click", function (e){
    if (textcheckbox.checked) {
        inputtext.style.display = "block";
        inputtextlabel.style.display = "block";
    } else if (!textcheckbox.checked) {
        inputtext.style.display = "none";
        inputtextlabel.style.display = "none";
    }
});


var address_main = document.getElementById("address_main");
var address_detail = document.getElementById("address_detail");
address_detail.addEventListener('input', function() {
    let text = this.value;
    if (text.length > 40) {
        this.value = text.slice(0, 40);
    }
    let nottext = /[\\/()\{\}\[\]'"`]/g;
    if (nottext.test(text)) {
        this.value = text.replace(nottext, '');
    }
});

var textcheckbox2 = document.getElementById("textcheckbox2");
var inputtext2 = document.getElementById("inputtext2");
var inputtextlabel2 = document.getElementById("inputtextlabel2");
textcheckbox2.addEventListener("click", function (e){
    if (textcheckbox2.checked) {
        inputtext2.style.display = "block";
        inputtextlabel2.style.display = "block";
    } else if (!textcheckbox2.checked) {
        inputtext2.style.display = "none";
        inputtextlabel2.style.display = "none";
    }
});

inputtext.addEventListener('input', function() {
    let text = this.value;
    if (text.length > 40) {
        this.value = text.slice(0, 40);
    }
    let nottext = /[\\/()\{\}\[\]'"`]/g;
    if (nottext.test(text)) {
        this.value = text.replace(nottext, '');
    }
});

inputtext2.addEventListener('input', function() {
    let text = this.value;
    if (text.length > 40) {
        this.value = text.slice(0, 40);
    }
    let nottext = /[\\/()\{\}\[\]'"`]/g;
    if (nottext.test(text)) {
        this.value = text.replace(nottext, '');
    }
});

var reqtext = document.getElementById("reqtext");
reqtext.addEventListener('input', function() {
    let text = this.value;
    if (text.length > 200) {
        this.value = text.slice(0, 200);
    }
    let nottext = /[\\/()\{\}\[\]'"`]/g;
    if (nottext.test(text)) {
        this.value = text.replace(nottext, '');
    }
});

prev.addEventListener("click", function(e){
    if (pagenum > 1){
        pagecheckedtext.textContent = '한 개 이상의 항목을 선택해주세요. ';
        pagecheckedtext.style.color = "lightgray";
    }
    switch (pagenum) {
        case 1:
            break;
        case 2:
            question.textContent = '레슨을 받는 목적이 무엇인가요?';
            page1.style.display = "block";
            page2.style.display = "none";
            break;
        case 3:
            question.textContent = '어떤 형태의 레슨을 원하시나요?';
            page2.style.display = "block";
            page3.style.display = "none";
            break;
        case 4:
            question.textContent = '가능한 요일을 모두 선택해주세요';
            page3.style.display = "block";
            page4.style.display = "none";
            break;
        case 5:
            question.textContent = '희망하는 시간대를 선택해주세요';
            page4.style.display = "block";
            page5.style.display = "none";
            break;
        case 6:
            question.textContent = '레슨생의 성별을 선택해주세요';
            page5.style.display = "block";
            page6.style.display = "none";
            break;
        case 7:
            question.textContent = '레슨생의 연령대를 선택해주세요';
            page6.style.display = "block";
            page7.style.display = "none";
            break;
        case 8:
            question.textContent = '지역을 선택해주세요';
            pagecheckedtext.textContent = '주소 및 세부 주소를 입력해주세요. ';
            pagecheckedtext.style.display = "block";
            page7.style.display = "block";
            page8.style.display = "none";
            break;
        default:
            break;
    }
    if (pagenum >= 2){
        pagenum--;
        progress.value = pagenum;
        progresslbl.textContent = pagenum + '/8';
    }
});

next.addEventListener("click", function(e){
    let pagecheckboxes = document.querySelectorAll('#page' + pagenum + ' input[type="checkbox"]');
    let isChecked = false;
    for (let i = 0; i < pagecheckboxes.length; i++) {
        if (pagecheckboxes[i].checked) {
            isChecked = true;
            break;
        }
    }

    let page1checkboxes = document.querySelectorAll('#page1 input[type="checkbox"]');
    if (pagenum == 1){
        page1checkboxes.forEach((checkbox) => {
            if (checkbox.checked) {
                if (checkbox.nextElementSibling.textContent == "기타") {
                    if (!inputtext.value > 0) {
                        isChecked = false;
                        pagecheckedtext.textContent = '입력칸에 내용을 입력해주세요. ';
                    }
                }
            }
        });
    }
    let page2checkboxes = document.querySelectorAll('#page2 input[type="checkbox"]');
    if (pagenum == 2){
        page2checkboxes.forEach((checkbox) => {
            if (checkbox.checked) {
                if (checkbox.nextElementSibling.textContent == "기타") {
                    if (!inputtext2.value > 0) {
                        isChecked = false;
                        pagecheckedtext.textContent = '입력칸에 내용을 입력해주세요. ';
                    }
                }
            }
        });
    }

    if (isChecked || (pagenum == 8 || (pagenum == 7 && address_detail.value.length > 0 && address_main.value.length > 0))) {
        pagecheckedtext.textContent = '한 개 이상의 항목을 선택해주세요. ';
        pagecheckedtext.style.color = "lightgray";
        switch (pagenum) {
            case 1:
                question.textContent = '어떤 형태의 레슨을 원하시나요?';
                page1.style.display = "none";
                page2.style.display = "block";
                break;
            case 2:
                question.textContent = '가능한 요일을 모두 선택해주세요';
                page2.style.display = "none";
                page3.style.display = "block";
                break;
            case 3:
                question.textContent = '희망하는 시간대를 선택해주세요';
                page3.style.display = "none";
                page4.style.display = "block";
                break;
            case 4:
                question.textContent = '레슨생의 성별을 선택해주세요';
                page4.style.display = "none";
                page5.style.display = "block";
                break;
            case 5:
                question.textContent = '레슨생의 연령대를 선택해주세요';
                page5.style.display = "none";
                page6.style.display = "block";
                break;
            case 6:
                question.textContent = '지역을 선택해주세요';
                pagecheckedtext.textContent = '주소 및 세부 주소를 입력해주세요. ';
                page6.style.display = "none";
                page7.style.display = "block";
                break;
            case 7:
                question.textContent = '희망사항을 입력해주세요';
                pagecheckedtext.style.display = "none";
                page7.style.display = "none";
                page8.style.display = "block";
                break;
            case 8:
                if (confirm("요청서를 제출하시겠습니까?")) {
                    let reqcheckboxes = document.querySelectorAll('input[type="checkbox"]');
                    let reqarr = [];

                    reqcheckboxes.forEach((checkbox) => {
                        if (checkbox.checked) {
                            if (checkbox.nextElementSibling.textContent == "기타") {
                                if (reqarr.length < 9) {
                                    if (inputtext.value != ('')){
                                        reqarr.push(inputtext.value);
                                    } else {
                                        reqarr.push(null);
                                    }
                                } else {
                                    if (inputtext2.value != ('')){
                                        reqarr.push(inputtext2.value);
                                    } else {
                                        reqarr.push(null);
                                    }
                                }
                            } else {
                                reqarr.push(checkbox.nextElementSibling.textContent);
                            }
                        } else {
                            reqarr.push(null);
                        }
                    });

                    if ((address_main.value + address_detail.value) != ('')){
                        reqarr.push(address_main.value + ' ' + address_detail.value);
                    } else {
                        reqarr.push(null);
                    } 
                    if (reqtext.value != ('')) {
                        reqarr.push(reqtext.value);
                    } else {
                        reqarr.push(null);
                    }

                    reqarr.push(categorystr);

                    let reqdata = JSON.stringify(reqarr);
                    fetch('http://localhost:8080/ohgym/userreq', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: reqdata
                    });
                    console.log(reqarr);
                    for (let i = 0; i < reqarr.length; i++) {
                        console.log(reqarr[i]);
                    }
                    location.href = "http://localhost:5500/front/html/mainPage.html";
                } else {
                }
                break;
            default:
                break;
        }
        if (pagenum <= 7){
            pagenum++;
            progress.value = pagenum;
            progresslbl.textContent = pagenum + '/8';
        }
    } else {
        pagecheckedtext.style.color = "red";
    }
});