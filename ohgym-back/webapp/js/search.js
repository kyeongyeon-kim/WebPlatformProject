window.addEventListener("load", onload);
function onload(e) {
    console.log("페이지 로딩 후 호출됩니다.");
    fetch("http://192.168.0.104:8080/ohgym/find") 
    .then((resp) => resp.json())
    .then((arr) => {
        arr.forEach(element => {
            makeObj(element);
            fillProfile(element);
        });             
    });
}

let objArr = [];
function makeObj(element) {
    let myObj = {}; 
    myObj.id = element.id;
    myObj.appeal = element.appeal;
    myObj.contactTime = element.contactTime;
    myObj.exercise = element.exercise;
    myObj.introduction = element.introduction;
    myObj.centerName = element.centerName;
    myObj.location = element.location;
    myObj.career = element.career;
    myObj.image = element.image;
    objArr.push(myObj);
}

function fillProfile(element) {
    let container = document.getElementById("profile-container");
    let template = document.getElementById("profile-temp");
    let p = document.importNode(template.content, true);
    let pId = p.querySelector("h3");
    pId.innerText = element.id;
    let pAppeal = p.querySelector("#appeal");
    pAppeal.innerText = element.appeal;
    let pIntroduction = p.querySelector("#introduction");
    pIntroduction.innerText = element.introduction;
    let pContactTime = p.querySelector("#contactTime");
    pContactTime.innerText = element.contactTime; 
    let pCenterLocation = p.querySelector("#centerLocation");
    pCenterLocation.innerText = element.location; 
    let pImage = p.querySelector("#image");
    pImage.src = element.image;
    let profile = p.querySelector(".profile");
    profile.id = element.id + element.exercise;
    container.append(p);
}

let type = document.getElementById("type");
type.addEventListener("change", choiceType);
function choiceType() {
    let selectType = type.options[type.selectedIndex].text;
    console.log(selectType);
    objArr.forEach(myObj => {
        let profile = document.getElementById(myObj.id + myObj.exercise);
        if (selectType == myObj.exercise) {
            profile.style.display = "block";
        } else if (selectType == "서비스 선택") {
            profile.style.display = "block";
        } else {
            profile.style.display = "none";
        }
    })
}

let area = document.getElementById("area");
area.addEventListener("change", choiceArea);
function choiceArea() {
    let selectArea = area.options[area.selectedIndex].text;
    console.log(selectArea);
    objArr.forEach(myObj => {
        let centerArea = myObj.location;
        let trueArea = centerArea.search(selectArea)
        let profile = document.getElementById(myObj.id + myObj.exercise);
        console.log(trueArea);
        if (trueArea == 0) {
            profile.style.display = "block";
        } else if (selectArea == "지역") {
            profile.style.display = "block";
        } else {
            profile.style.display = "none";
        }
    })
}

let searchBtn = document.getElementById("search-btn");
searchBtn.addEventListener("click", searchInput);
function searchInput() {
    let text = getInput();
    objArr.forEach(myObj => {
        let match = JSON.stringify(myObj).search(text)
        console.log(match);
        let profile = document.getElementById(myObj.id + myObj.exercise);
        if (match == -1) {
            profile.style.display = "none";
        } else {
            profile.style.display = "block";
        }
    })
}
let input = document.getElementById("search");
input.addEventListener("change", getInput);
input.addEventListener("keydown", function(){
    if (window.event.keyCode == 13) {
        searchInput();
    }
});
function getInput() {
    input = document.getElementById("search").value;
    console.log(input);
    return input;
}




