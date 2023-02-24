// 팝업창
function show() {
    document.querySelector(".background").className = "background show";
}
function close() {
    document.querySelector(".background").className = "background";
}
function out(){
    var user = {
         id: userId.value,
        usercheck: usercheck.value,
        }
    fetch("http://localhost:8080/ohgym/out",{
        method: "POST",
        headers:{
            "Content-Type": "application/json",
        },
        body: JSON.stringify(user)
    })
    .then((resp) => resp.text())
    .then((text)=>{
        console.log(text);
    })

    document.querySelector(".background").className = "background";
    var link = "../html/login.html";
    console.log("탈퇴")
 
    location.href=link;
    location.replace(link);
    window.open(link);
}

document.querySelector("#showOut").addEventListener("click", show);
document.querySelector("#close").addEventListener("click", close);
document.querySelector("#userout").addEventListener("click",out);
