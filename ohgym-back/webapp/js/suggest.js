let request;
let requestInfo;
window.addEventListener("load", onload);
function onload(e) {
  console.log("페이지 로딩 후 호출됩니다.");
  fetch("http://localhost:8080/ohgym/requestNo")
    .then((resp) => resp.json())
    .then((text) => {
      request = text[0];
      requestInfo = text[1];
      makeRequest(request);
      makeRequestAnswer(requestInfo);
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

function makeRequestAnswer(element) {
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

function fillRequestAnswer(element) {
  let purpose = document.getElementById("purpose");
  purpose.innerText = element.answer1;
  let lessonStyle = document.getElementById("lessonStyle");
  lessonStyle.innerText = element.answer2;
  let dayOfWeek = document.getElementById("dayOfWeek");
  dayOfWeek.innerText = element.answer3;
  let desiredTime = document.getElementById("desiredTime");
  desiredTime.innerText = element.answer4;
  let gender = document.getElementById("gender");
  gender.innerText = element.answer5;
  let age = document.getElementById("age");
  age.innerText = element.answer6;
  let address = document.getElementById("address");
  address.innerText = element.answer7;
  let message = document.getElementById("message");
  message.innerText = element.message;
}
// java Suggest객체와 동일한 객체
class Suggest {
  no;
  id;
  requestNo;
  price;
  date;
  message;
  constructor(no, id, requestNo, price, date, message) {
    this.no = no;
    this.id = id;
    this.requestNo = requestNo;
    this.price = price;
    this.date = date;
    this.message = message;
  }
}
// 금액, 견적사항 이벤트 처리
let inputCost = document.getElementById("input-cost");
let quote = document.getElementById("quote");
// 견적보내기 버튼 이벤트 처리
let sendSuggest = document.getElementById("send-suggest");
sendSuggest.addEventListener("click", sendSuggestEvent);

function sendSuggestEvent() {
  console.log(inputCost.value);
  console.log(quote.value);
  console.log(request);
  let suggest = new Suggest(
    null,
    "경연",
    request.no,
    inputCost.value,
    "2023-02-22",
    quote.value
  );
  console.log(suggest);

  fetch("http://localhost:8080/ohgym/sendSuggest", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(suggest),
  });
}
