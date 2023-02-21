window.addEventListener("load", onload);
function onload(e) {
    console.log("페이지 로딩 후 호출됩니다.");
    fetch("http://192.168.0.104:8080/ohgym/requestNo") 
    .then((resp) => resp.json())
    .then((text) => {
        makeRequest(text);
          
    });
}

function makeRequest(element) {
    let myRequest = {}; 
    myRequest.id = element.id;
    myRequest.exerciseType = element.exerciseType;
    myRequest.requestDate = element.requestDate;
    myRequest.deadlineDate = element.deadlineDate;
    myRequest.message = element.message;
    console.log(myRequest);
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
