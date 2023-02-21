window.addEventListener("load", onload);
function onload(e) {
    console.log("페이지 로딩 후 호출됩니다.");
    fetch("http://192.168.0.104:8080/ohgym/requestNo") 
    .then((resp) => resp.json())
    .then((text) => {
        makeRequest(text);
          
    });
}

let reqArr = [];
function makeRequest(element) {
    let myRequest = {}; 
    myRequest.id = element.id;
    myRequest.exerciseType = element.exerciseType;
    myRequest.requestDate = element.requestDate;
    myRequest.deadlineDate = element.deadlineDate;
    myRequest.message = element.message;
    // reqArr.push(myRequest);
    console.log(myRequest);
    fillRequest(myRequest); 
}

function fillRequest(element) {
    let userInfo = document.getElementById("user-info");
    let name = userInfo.firstChild;
    console.log(name);
    name.innerText = element.id;

}
