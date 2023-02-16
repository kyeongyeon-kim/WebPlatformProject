// 로그인 사용자 값 불러오기
let userId = document.getElementById("userId");
userId.innerText = "경연";
window.addEventListener("load", (e) => {
  userId.innerText = userId.innerText + "근선생님!";
  fetch("http://192.168.0.104:8080/ohgym/profile")
    .then((resp) => resp.text())
    .then((text) => {
      console.log(text);
    });
});
function getId() {}

// 수정 버튼 이벤트 처리 파트
let modify = document.querySelectorAll(".heading div:nth-child(2)");
let values = document.querySelectorAll(".value");
let comps = document.querySelectorAll("#comps > .info-comp");
let template = document.getElementById("input-form");
let modifyArr = [...modify];
let valuesArr = [...values];
let compsArr = [...comps];
let value = [];
modifyArr.forEach((elem) => {
  elem.addEventListener("click", function (e) {
    let index = modifyArr.indexOf(elem);
    let modifyStr = modifyArr[index].innerText;
    let valueText = valuesArr[index].innerText;
    if (modifyStr !== "저장") {
      modifyArr[index].innerText = "저장";
      modifyArr[index].style.color = "RED";

      let importTemplate = document.importNode(template.content, true);
      value[index] = valuesArr[index];
      valuesArr[index].remove();
      let input = importTemplate.querySelector("input");
      input.value = valueText;
      comps[index].append(importTemplate);
    } else {
      let article = document.querySelector(
        "#comps > .info-comp:nth-child(" + (index + 1) + ") > article"
      );
      article.remove();
      let className = modifyArr[index].getAttribute("class");

      if (className === "modify") {
        modifyArr[index].innerText = "수정";
      } else {
        modifyArr[index].innerText = "등록하기";
      }

      modifyArr[index].style.color = "#00c7ae";
      compsArr[index].append(value[index]);
    }
  });
});
