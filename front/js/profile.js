// 로그인 사용자 값 불러오기
var profile;
window.addEventListener("load", (e) => {
  fetch("http://localhost:8080/ohgym/profile")
    .then((resp) => resp.json())
    .then((profile) => {
      this.profile = profile;
      let {
        id,
        appeal,
        contactTime,
        exercise,
        introduction,
        centerName,
        location,
        career,
        image,
      } = profile;
      userId.innerText = id + " 근선생님!";

      let attr = [
        appeal,
        contactTime,
        exercise,
        introduction,
        centerName,
        location,
        career,
        image,
      ];

      for (let i = 0; i < valuesArr.length; i++) {
        let elem = valuesArr[i];
        let attrItem = attr[i];
        elem.innerText = attrItem;
      }
    })
    .catch();
});

// 수정 버튼 이벤트 처리 파트
let modify = document.querySelectorAll(".heading div:nth-child(2)");
let values = document.querySelectorAll(".value");
let comps = document.querySelectorAll("#comps > .info-comp");
let template = document.getElementById("input-form");
let modifyArr = [...modify];
let valuesArr = [...values];
let keys = [
  "appeal",
  "contactTime",
  "exercise",
  "introduction",
  "centerName",
  "location",
  "career",
  "image",
];
let compsArr = [...comps];
let value = [];
let input;

modifyArr.forEach((elem) => {
  elem.addEventListener("click", function (e) {
    let index = modifyArr.indexOf(elem);
    let modifyStr = modifyArr[index].innerText;
    let valueText = valuesArr[index].innerText;
    if (modifyStr !== "저장") {
      modifyArr[index].innerText = "저장";
      modifyArr[index].style.color = "RED";

      let importTemplate = document.importNode(template.content, true);
      input = importTemplate.querySelector("input");

      value[index] = valuesArr[index];
      valuesArr[index].remove();
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

      // input요소 값 프로필 삽입
      updateProfile(index);

      let temp = value[index];
      temp.innerText = input.value;
      compsArr[index].append(temp);
      console.log(profile);
      console.log(JSON.stringify(profile));

      fetch("http://localhost:8080/ohgym/profile", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(profile),
      })
        .then((resp) => resp.json())
        .then((profile) => console.log(profile))
        .catch((error) => console.log(error));
    }
  });
});

function updateProfile(index) {
  switch (index) {
    case 0:
      profile.appeal = input.value;
      break;
    case 1:
      profile.contactTime = input.value;
      break;
    case 2:
      profile.exercise = input.value;
      break;
    case 3:
      profile.introduction = input.value;
      break;
    case 4:
      profile.centerName = input.value;
      break;
    case 5:
      profile.location = input.value;
      break;
    case 6:
      profile.career = input.value;
      break;
    case 7:
      profile.image = input.value;
      break;

    default:
      break;
  }
}
