window.addEventListener("load", onload);
function onload(e) {
    console.log("페이지 로딩 후 호출됩니다.");
    fetch("http://localhost:8080/ohgym/requestNo") 
    .then((resp) => resp.json())
    .then((text) => {
        var json1 = text[0];
        var json2 = text[1];
        makeRequest(json1);
        makeRequestAnswer(json2);  
    });
}

function makeRequest(element) {
    let myRequest = {}; 
    myRequest.id = element.id;
    myRequest.exerciseType = element.exerciseType;
    myRequest.requestDate = element.requestDate;
    myRequest.deadlineDate = element.deadlineDate;
    myRequest.message = element.message;
    fillRequest(myRequest); 
}

function fillRequest(element) {
    let userInfoId = document.getElementById("user-info-id");
    userInfoId.innerText = element.id;
    let userInfoType = document.getElementById("user-info-type");
    userInfoType.innerText = element.exerciseType;
    let userInfoArea = document.getElementById("user-info-area");
    // userInfoArea.innerText = element.;
}

function makeRequestAnswer(element){
    let myRequestAnswer = {}; 
    myRequestAnswer.answer1 = element.answer1;
    myRequestAnswer.answer2 = element.answer2;
    myRequestAnswer.answer3 = element.answer3;
    myRequestAnswer.answer4 = element.answer4;
    myRequestAnswer.answer5 = element.answer5;
    myRequestAnswer.answer6 = element.answer6;
    myRequestAnswer.answer7 = element.answer7;
    myRequestAnswer.message = element.message;
    fillRequestAnswer(myRequestAnswer);
}

function fillRequestAnswer(element){
let purpose = document.getElementById("purpose")
purpose.innerText = element.answer1;
let lessonStyle = document.getElementById("lessonStyle")
lessonStyle.innerText = element.answer2;
let dayOfWeek = document.getElementById("dayOfWeek")
dayOfWeek.innerText = element.answer3;
let desiredTime = document.getElementById("desiredTime")
desiredTime.innerText = element.answer4;
let gender = document.getElementById("gender")
gender.innerText = element.answer5;
let age = document.getElementById("age")
age.innerText = element.answer6;
let address = document.getElementById("address")
address.innerText = element.answer7;
let message = document.getElementById("message")
message.innerText = element.message;
}
