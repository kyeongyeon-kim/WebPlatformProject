var user;
window.addEventListener("load", onload);
let container = document.getElementById("profile-container");

function onload(e) {
    console.log("페이지 로딩 후 호출됩니다.");

    fetch("http://localhost:8080/ohgym/change")
        .then((resp) => resp.json())
        .then((json) => {
        //    user = json;
        //    let{
        //     id,pw,name,phone,birthday,gender,usercheck
        //    } = user;
          
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

function show() {
    document.querySelector(".background").className = "background show";
}
function close() {
    document.querySelector(".background").className = "background";
}
function out(){
    console.log("눌렷어");
    fetch("http://localhost:8080/ohgym/out")
    .then((resp) => resp.text())
    .then((text)=>{
        console.log(text);
    })
    document.querySelector(".background").className = "background";
    var link = "../html/login.html";
 
    location.href=link;
    location.replace(link);
    window.open(link);
}

document.querySelector("#showOut").addEventListener("click", show);
document.querySelector("#close").addEventListener("click", close);
document.querySelector("#userout").addEventListener("click",out);


// var user;

// window.addEventListener("load", onload);
// let container = document.getElementById("profile-container");

// function onload(e) {
//     console.log("페이지 로딩 후 호출됩니다.");

//     fetch("http://localhost:8080/ohgym/change")
//         .then((resp) => resp.json())
//         .then((json) => {
//            this.user = json;
//            let{
//             id,pw,name,phone,birthday,gender,usercheck
//            } = user;
//            console.log(user)
//             userId.value=json.id;
//             userPassword.value=json.pw; 
//             userPasswordTest.value=json.pw;
//             userName.value=json.name;
//             userPhone.value=json.phone;
//             userBirthday.value=json.birthday;

//             if(json.gender=="남"){
//                 document.getElementById("man").checked=true;
//             }else{
//                 document.getElementById("woman").checked=true;
//             }
//         }).catch((tt) => console.log(tt))
//     }
    console.log("출력")
    console.log(user);

     const submit_btn = document.querySelector("#submit")

    submit_btn.addEventListener("click",function (e){
  
        console.log(userId.value);
        console.log(userName.value);
        console.log(userPassword.value);
        console.log(userBirthday.value);
       const genderNodeList = document.getElementsByName('gender');
       genderNodeList.forEach((node) => {
        if(node.checked)  {
          console.log(node.value);
        }
      }) 


        // if(man.checked=true){
        //     console.log()
        // }

        // var user = {
        //     id:userid.value,
        //     name:userName.value,
        //     pw:userPassword.value,
        //     birthday:userBirthday.value,
        //     gender:gender.value,
        // }
        console.log(user);

        // fetch("http://localhost:8080/ohgym/change",{
        //     method:"POST",
        //     headers:{
        //         "Content-Type":"application/json",
        //     },
        //     body:JSON.stringify(json),
        // })
        // .then((resp) => resp.json())
        // .then(())
    })

    