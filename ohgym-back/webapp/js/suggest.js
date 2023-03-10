// 입력 안내 텍스트
let guide = document.getElementById("guide");
// 금액, 견적사항 이벤트 처리
let inputCost = document.getElementById("input-cost");
let quote = document.getElementById("quote");
// 견적보내기 버튼 이벤트 처리
let sendSuggest = document.getElementById("send-suggest");
sendSuggest.addEventListener("click", sendSuggestEvent);
const urlParams = new URL(location.href).searchParams;
const requestNo = urlParams.get("no");
function sendSuggestEvent() {
  if (inputCost.value === "") {
    guide.style.display = "block";
  } else {
    let id = sessionStorage.getItem("id");
    guide.style.display = "none";
    let today = new Date(); // 오늘 날짜
    let dateFormat =
      today.getFullYear() +
      "-" +
      (today.getMonth() + 1 < 9
        ? "0" + (today.getMonth() + 1)
        : today.getMonth() + 1) +
      "-" +
      (today.getDate() < 9 ? "0" + today.getDate() : today.getDate());

    let suggest = {
      no: null,
      appeal: id,
      requestNo: requestNo,
      price: inputCost.value,
      date: dateFormat,
      message: quote.value,
    };
    console.log(suggest);
    fetch("http://localhost:8080/ohgym/sendSuggest", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(suggest),
    });
  }
}
inputCost.addEventListener("keyup", isInputEmpty);

function isInputEmpty() {
  inputCost.value === ""
    ? (guide.style.display = "block")
    : (guide.style.display = "none");
}
