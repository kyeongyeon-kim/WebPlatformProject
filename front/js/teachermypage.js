// 금액 input 넘버포맷 (미구현)

// 견적서 리스트 로드
window.addEventListener("load", (e) => {
  fetch("http://localhost:8080/ohgym/requestList")
    .then((resp) => resp.json())
    .then((arr) => {
      let requestList = document.getElementById("requestList");
      let requestCard = document.getElementById("request-card");
      let template = document.getElementById("request-card-temp");

      console.log(requestList);
      console.log(requestCard);
      console.log(template);
      // arr.forEach((elem) => {
      //   let importTemplate = document.importNode(
      //     template.contentEditable,
      //     true
      //   );
      //   requestList.append(importTemplate);
      // });
    });
});
