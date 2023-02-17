function show() {
    document.querySelector(".background").className = "background show";
}
function close() {
    document.querySelector(".background").className = "background";
}

document.querySelector("#showOut").addEventListener("click", show);
document.querySelector("#close").addEventListener("click", close);

window.addEventListener("load", onload);

let container = document.getElementById("profile-container");

function onload(e) {
    console.log("페이지 로딩 후 호출됩니다.");

    fetch("http://localhost:8080/ohgym/change")
        .then((resp) => resp.json())
        .then((json) => {
            userId.value=json.id;
            userPassword.value=json.pw; 
            userPasswordTest.value=json.pw;
            userName.value=json.name;
            userPhone.value=json.phone;
            userBirthday.value=json.birthday;

            if(json.gender=="남"){
                document.getElementById("man").checked=true;
            }else{
                document.getElementById("woman").checked=true;
            }
        }).catch((tt) => console.log(tt))
    }

    