
  // 견적서 리스트 로드
window.addEventListener("load", (e) => {
    fetch("http://localhost:8080/ohgym/clientRequest")
      .then((resp) => resp.json())
      .then((arr) => {       
        let span = document.createElement("span");
        span.innerText = `(${arr.length})`;
        let history = document.querySelector(".history > h3");
        history.append(span);

        let requestList = document.getElementById("requestList");

        let template = document.getElementById("request-card-temp");
        arr.forEach((elem) => {
          let importTemplate = document.importNode(template.content, true);
          let firstP = importTemplate.querySelector("p");
          let secondP = firstP.nextElementSibling;
          firstP.innerText = elem.exerciseType;
          secondP.innerText = elem.requestDate + " ~ " + elem.deadlineDate;
          requestList.append(importTemplate);
        });
      });
  });

  window.addEventListener("load", (e) => {
    fetch("http://localhost:8080/ohgym/teacherPick")
      .then((resp) => resp.json())
      .then((arr) => {       
        console.log(arr);
        let requestList = document.getElementById("pickList");

        let template = document.getElementById("pick-card-temp");
        arr.forEach((elem) => {
          let importTemplate = document.importNode(template.content, true);
          let firstP = importTemplate.querySelector("p");
          firstP.innerText = elem.appeal;
          let secondP = firstP.nextElementSibling;
          secondP.innerText ="연락가능 시간:  "+ elem.contactTime;
          let pImage = importTemplate.querySelector("#pick-image");
          pImage.src = elem.image;
          requestList.append(importTemplate);
        });
      });
  });