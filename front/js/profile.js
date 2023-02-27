// 로그인 사용자 값 불러오기
var profile;
let profileImage = document.getElementById("profile-image");
window.addEventListener("load", (e) => {
  fetch("http://localhost:8080/ohgym/profile")
    .then((resp) => resp.json())
    .then((profile) => {
      this.profile = profile;
      let { id, appeal, introduction, centerName, career, image } = profile;
      userId.innerText = id + " 근선생님!";
      profileImage.setAttribute("src", image);
      stringToTime();
      let attr = [appeal, introduction, centerName, career, image];
      for (let i = 0; i < valuesArr.length; i++) {
        let elem = valuesArr[i];
        elem.innerText = attr[i];
      }
      serviceInitialValue();
    })
    .catch();
});

// db 저장된 대표서비스 값으로 초기버튼 checked
function serviceInitialValue() {
  let serviceBtns = document.querySelectorAll(".service-btn");
  let serviceBtnsArr = [...serviceBtns];
  for (let i = 0; i < serviceBtnsArr.length; i++) {
    if (serviceBtnsArr[i].innerText == this.profile.exercise) {
      let input = serviceBtnsArr[i].previousSibling;
      input.checked = true;
    }
  }
}

// 수정 버튼 이벤트 처리 파트
let modify = document.querySelectorAll(".heading div:nth-child(2)");
let values = document.querySelectorAll(".value");
let comps = document.querySelectorAll("#comps > .info-comp");
let template = document.getElementById("input-form");
let modifyArr = [...modify];
modifyArr.splice(1, 2);
modifyArr.splice(2, 1);
let valuesArr = [...values];
let compsArr = [...comps];
compsArr.splice(1, 2);
compsArr.splice(3, 1);
let value = [];
let input;
console.log(modifyArr);
console.log(compsArr);
modifyArr.forEach((elem) => {
  elem.addEventListener("click", function (e) {
    let index = modifyArr.indexOf(elem);
    let modifyStr = modifyArr[index].innerText;
    let valueText = valuesArr[index].innerText;
    if (modifyStr !== "저장") {
      // 수정할때
      modifyArr[index].innerText = "저장";
      modifyArr[index].style.color = "RED";

      let importTemplate = document.importNode(template.content, true);
      input = importTemplate.querySelector("input");

      value[index] = valuesArr[index];
      valuesArr[index].remove();
      input.value = valueText;
      compsArr[index].append(importTemplate);
    } else {
      // 저장하기
      let article = compsArr[index].lastElementChild;
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
      });
    }
  });
});

function updateProfile(index) {
  switch (index) {
    case 0:
      profile.appeal = input.value;
      break;
    case 1:
      profile.introduction = input.value;
      break;
    case 2:
      profile.centerName = input.value;
      break;
    case 3:
      profile.career = input.value;
      break;
    case 4:
      profile.image = input.value;
      break;

    default:
      break;
  }
}

// 시간 저장하는 이벤트 처리
let timeSave = document.getElementById("time-save");
timeSave.addEventListener("click", changeTimeSave);

function changeTimeSave() {
  timeSave.innerText = "저장완료";
  profile.contactTime = timeToString();
  fetch("http://localhost:8080/ohgym/profile", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(profile),
  });
}
let infoContactTime = document.getElementById("info-contactTime");
infoContactTime.addEventListener("change", function (e) {
  timeSave.innerText = "저장";
});
// 시간 변환
function timeToString() {
  let startTime = document.getElementById("start-time");
  let endTime = document.getElementById("end-time");
  let profileTime = startTime.value + "-" + endTime.value;
  return profileTime;
}
function stringToTime() {
  let arr = profile.contactTime.split("-");
  let start = arr[0];
  let end = arr[1];
  let startTime = document.getElementById("start-time");
  startTime.value = start;
  let endTime = document.getElementById("end-time");
  endTime.value = end;
}

// 대표서비스 이벤트 처리
let services = document.querySelectorAll(".service-btn");
let servicesArr = [...services];
servicesArr.forEach((elem) => {
  elem.addEventListener("click", selectedService);
});
function selectedService() {
  profile.exercise = this.innerText;
  fetch("http://localhost:8080/ohgym/profile", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(profile),
  });
}
