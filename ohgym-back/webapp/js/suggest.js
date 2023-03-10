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
    console.log(dateFormat);

    let suggest = {
      no: null,
      appeal: "경연",
      requestNo: requestNo,
      price: inputCost.value,
      date: dateFormat,
      message: quote.value,
    };

    // fetch("http://localhost:8080/ohgym/sendSuggest", {
    //   method: "POST",
    //   headers: {
    //     "Content-Type": "application/json",
    //   },
    //   body: JSON.stringify(suggest),
    // });
  }
}
console.log(document.cookie);
inputCost.addEventListener("keyup", isInputEmpty);

function isInputEmpty() {
  inputCost.value === ""
    ? (guide.style.display = "block")
    : (guide.style.display = "none");
}
