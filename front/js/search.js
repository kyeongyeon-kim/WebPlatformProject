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

let container = document.getElementById("profile-container");
let template = document.getElementById("profile-temp");
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
    let p = document.importNode(template.content, true);
    let pId = p.querySelector("h3");
    pId.innerText = element.id;

    let pAppeal = p.querySelector("#appeal");
    pAppeal.innerText = element.appeal;

    let pIntroduction = p.querySelector("#introduction");
    pIntroduction.innerText = "서비스 소개 : " + element.introduction;

    let pContactTime = p.querySelector("#contactTime");
    pContactTime.innerText = "연락 가능 시간 : " + element.contactTime;

    container.append(p);
}


let type = document.getElementById("type");
type.addEventListener("change", choiceType);

function choiceType() {
    
    console.log("이벤트");
    let selectType = type.options[type.selectedIndex].text;
    console.log(selectType);
    console.log("0" + objArr[0].id);
    console.log("1" + objArr[1].id);
    console.log("2" + objArr[2].id);
    console.log("5" + objArr[5].id);
    console.log(objArr[2]);
    console.log("배열길이" + objArr.length);
    // objArr.forEach(myObj => {
    //     if (selectType === myObj.exercise) {
    //         // template.style.display ='none';
    //         console.log(myObj.id + myObj.exercise);
    //     }
    // })
    
}


// function start() {
//     // objArr = onload();
//     // choiceType(onload());
//     onload().then((arr) => {
//         console.log("여기여깅" + arr.length);
//         choiceType(arr);

//     })
// }
