
// 팝업창
function show() {
    document.querySelector(".background").className = "background show";
}
function close() {
    document.querySelector(".background").className = "background";
}
function out(){
    var user = { id: userId.value }
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

// 페이지 초기 창
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
            usercheck.value = json.usercheck;

            if(json.gender=="남"){
                document.getElementById("man").checked=true;
            }else{
                document.getElementById("woman").checked=true;
            }
        }).catch((tt) => console.log(tt))
    }

    //수정 버튼 눌렸을 때
    const submit_btn = document.querySelector("#submit")
    submit_btn.addEventListener("click",function (e){
      
      const genderNodeList = document.getElementsByName('gender');
      genderNodeList.forEach((node) => {
            if(node.checked)  {
                 usergender = node.value;
            }
      }) 

      var user = {
            id: userId.value,
            name: userName.value,
            pw: userPasswordTest.value,
            phone: userPhone.value,
            birthday: userBirthday.value,
            gender: usergender,
            usercheck: usercheck.value,
      }

        fetch("http://localhost:8080/ohgym/change",{
            method:"POST",
            headers: {
                "Content-Type":"application/json",
            },
            body:JSON.stringify(user),
            })
             .then((resp) => resp.json())
             .then((data)=>{
             console.log(data)
             alert("수정되었습니다.")})
             .catch((tt)=>console.log(tt));
    })




