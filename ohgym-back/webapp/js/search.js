window.addEventListener("load", onload);

function onload(e) {
  console.log("페이지 로딩 후 호출됩니다.");

  fetch("http://192.168.0.104:8080/ohgym/find")
    .then((resp) => resp.json())
    .then((arr) => {
      let container = document.getElementById("profile-container");
      let name = document.getElementById("name");
      let introduction = document.getElementById("introduction");
      let template = document.getElementById("profile-temp");
      let myObj = {};
      let objArr = [];

      arr.forEach((element) => {
        myObj.id = element.id;
        myObj.contact_time = element.contact_time;
        myObj.appeal = element.appeal;
        objArr.push(myObj);

        let p = document.importNode(template.content, true);
        let pName = p.querySelector("h3");
        pName.innerText = myObj.id;

        let pIntroduction = pName.nextElementSibling;
        pIntroduction.innerText = myObj.appeal;

        container.append(p);
      });
    });
}
