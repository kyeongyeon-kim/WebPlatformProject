// 로그인 사용자 값 불러오기
let id = document.getElementById("userId").innerText;
let teacherProfile = {
  id: id,
};
console.log(teacherProfile.id);
let profileImage = document.getElementById("profile-image");
let template = document.getElementById("input-form");

setInitialValue();
function setInitialValue() {
  userId.innerText = profile.id + " 근선생님!";
  profileImage.setAttribute("src", profile.image);
  stringToTime();
  stringToAddress();
  document.getElementById("appeal").innerText = profile.appeal;
  document.getElementById("introduction").innerText = profile.introduction;
  document.getElementById("centerName").innerText = profile.centerName;
  careerToNumber(profile.career);
  serviceInitialValue();
}

// db 저장된 대표서비스 값으로 초기버튼 checked
function serviceInitialValue() {
  let serviceBtns = document.querySelectorAll(".service-btn");
  let serviceBtnsArr = [...serviceBtns];
  for (let i = 0; i < serviceBtnsArr.length; i++) {
    if (serviceBtnsArr[i].innerText == profile.exercise) {
      let input = serviceBtnsArr[i].previousSibling;
      input.checked = true;
    }
  }
}

// 수정 및 저장 이벤트 로직
function returnModifyComp(saveBtn, component) {
  saveBtn.innerText = "저장";
  let importTemplate = document.importNode(template.content, true);
  importTemplate.querySelector("input").value = component.innerText;
  component.style.display = "none";
  return importTemplate;
}

function setModifiedValue(saveBtn, component, componentParent) {
  let div = componentParent.querySelector("div:nth-child(3)");
  let input = div.querySelector("input");
  if (div !== null) {
    saveBtn.innerText = "저장완료";
    setTimeout(() => (saveBtn.innerText = "수정"), 3000);
    component.innerText = input.value;
    profile.component = input.value;
    div.remove();
  }
  component.style.display = "block";
}

// appeal(한줄소개) 이벤트 처리
let appealSave = document.getElementById("appeal-save");
appealSave.addEventListener("click", changeAppealSave);

function changeAppealSave() {
  let appeal = document.getElementById("appeal");
  let infoComp = appeal.parentNode;
  if (appealSave.innerText === "수정") {
    infoComp.append(returnModifyComp(appealSave, appeal));
  } else if (appealSave.innerText === "저장") {
    setModifiedValue(appealSave, appeal, infoComp);
  }
  sendProfile();
}

// 시간 저장하는 이벤트 처리
let timeSave = document.getElementById("time-save");
timeSave.addEventListener("click", changeTimeSave);

function changeTimeSave() {
  timeSave.innerText = "저장완료";
  setTimeout(() => (timeSave.innerText = "저장"), 3000);
  profile.contactTime = timeToString();
  sendProfile();
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
  sendProfile();
}

// introduction 이벤트 처리
let introductionSave = document.getElementById("introduction-save");
introductionSave.addEventListener("click", changeIntroductionSave);

function changeIntroductionSave() {
  let introduction = document.getElementById("introduction");
  let infoComp = introduction.parentNode;
  if (introductionSave.innerText === "수정") {
    infoComp.append(returnModifyComp(introductionSave, introduction));
  } else if (introductionSave.innerText === "저장") {
    setModifiedValue(introductionSave, introduction, infoComp);
  }
  sendProfile();
}

// centerName 이벤트 처리
let centerNameSave = document.getElementById("centerName-save");
centerNameSave.addEventListener("click", changeCenterNameSave);

function changeCenterNameSave() {
  let centerName = document.getElementById("centerName");
  let infoComp = centerName.parentNode;
  if (centerNameSave.innerText === "수정") {
    infoComp.append(returnModifyComp(centerNameSave, centerName));
  } else if (centerNameSave.innerText === "저장") {
    setModifiedValue(centerNameSave, centerName, infoComp);
  }
  sendProfile();
}

// 위치 이벤트 처리
let addressSave = document.getElementById("address-save");
addressSave.addEventListener("click", changeAddressSave);

function changeAddressSave() {
  addressSave.innerText = "저장완료";
  setTimeout(() => (addressSave.innerText = "저장"), 3000);
  profile.location = addressToString();
  sendProfile();
}

// 주소 변환
function addressToString() {
  let address = document.getElementById("input-address");
  let detailedAddress = document.getElementById("input-detailed-address");
  let profileAddress = address.value + "/" + detailedAddress.value;
  return profileAddress;
}

function stringToAddress() {
  let arr = profile.location.split("/");
  let address = arr[0];
  let detailedAddress = arr[1];
  let inputAddress = document.getElementById("input-address");
  inputAddress.value = address;
  let inputDetailedAddress = document.getElementById("input-detailed-address");
  inputDetailedAddress.value = detailedAddress;
}

// 경력 이벤트 처리
let inputCareer = document.getElementById("input-career");
let inputCareerMonth = document.getElementById("input-career-month");
inputCareer.addEventListener("wheel", (event) => {
  let wheel = event.wheelDeltaY;
  console.log("inputCareer" + inputCareer.value);
  if (wheel > 0) {
    console.log("Up!");
  } else {
    // (wheel < 0)
    console.log("Down!");
  }
});

let careerSave = document.getElementById("career-save");
careerSave.addEventListener("click", changeCareerSave);

function changeCareerSave() {
  careerSave.innerText = "저장완료";
  setTimeout(() => (careerSave.innerText = "저장"), 3000);
  profile.career = numberToCareer(inputCareer.value, inputCareerMonth.value);
  sendProfile();
}

function careerToNumber(career) {
  document.getElementById("input-career").value = career.substring(
    0,
    career.indexOf("년")
  );
  document.getElementById("input-career-month").value = career.substring(
    career.indexOf("년") + 1,
    career.indexOf("개")
  );
}

function numberToCareer(yearNumber, monthNumber) {
  console.log(yearNumber + "년" + monthNumber + "개월");
  return yearNumber + "년" + monthNumber + "개월";
}

// 프로필 전송
function sendProfile() {
  fetch("http://localhost:8080/ohgym/profile", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(profile),
  });
}
