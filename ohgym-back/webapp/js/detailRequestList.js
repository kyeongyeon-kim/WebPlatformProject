
window.addEventListener("load", (e) => {
    fetch("http://localhost:8080/ohgym/suggestTest")
      .then((resp) => resp.json())
      .then((arr) => {

        let span = document.createElement("span");
        span.innerText = `(${arr.length})`;

        let history = document.querySelector("#history > h3");
        history.append(span);

        let requestList = document.getElementById("suggestTest");

        let template = document.getElementById("request-card-temp")
        ;
        arr.forEach((elem) => {
          let importTemplate = document.importNode(template.content, true);
          let firstP = importTemplate.querySelector("p");
          let secondP = firstP.nextElementSibling;
          let thirdP = secondP.nextElementSibling;
          firstP.innerText = elem.exerciseType;
          secondP.innerText = elem.id;
          thirdP.innerText = elem.requestDate + " ~ " + elem.deadlineDate;
          requestList.append(importTemplate);
        });
      });
  });
  