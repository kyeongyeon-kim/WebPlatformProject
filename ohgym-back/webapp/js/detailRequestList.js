// window.addEventListener("load", (e) => {
//     fetch("http://localhost:8080/ohgym/suggestGo")
//       .then((resp) => resp.json())
//       .then((arr) => {

//         let span = document.createElement("span");
//         span.innerText = `(${arr.length})`;

//         // let history = document.querySelector("#history > h3");
//         // history.append(span);

//         let suggestTest = document.getElementById("detailRequest");
//         console.log(suggestTest);
//         let template = document.getElementById("detailRequest-card-temp");
        
//         arr.forEach((elem) => {
//           let importTemplate = document.importNode(template.content, true);
//           let firstP = importTemplate.querySelector("p");
//           let secondP = firstP.nextElementSibling;
//           let thirdP = secondP.nextElementSibling;
//           firstP.innerText = elem.id;
//           secondP.innerText = "💬  " + elem.message;
//           thirdP.innerText = "💸  " + elem.price;
//           suggestTest.append(importTemplate);  
//         });
//       });
//   });

window.addEventListener("load", (e) => {
  fetch("http://localhost:8080/ohgym/suggestGo")
    .then((resp) => resp.json())
    .then((arr) => {

      let span = document.createElement("span");
      span.innerText = `(${arr.length})`;

      let suggestTest = document.getElementById("detailRequest");
      console.log(suggestTest);
      let template = document.getElementById("detailRequest-card-temp");

      arr.forEach((elem) => {
        let importTemplate = document.importNode(template.content, true);
        let firstP = importTemplate.querySelector("p");
        let secondP = firstP.nextElementSibling;
        let thirdP = secondP.nextElementSibling;
        let viewPriceBtn = importTemplate.querySelector("#modalopenbtn");
        
        firstP.innerText = elem.id;
        secondP.innerText = "💬  " + elem.message;
        thirdP.innerText = "💸  " + elem.price;

        viewPriceBtn.addEventListener("click", function () {
          document.getElementById("modal").style.display = "block";
        });

        suggestTest.append(importTemplate);  
      });
    });
});

document.getElementById("modalclosebtn").addEventListener("click", function() {
          document.getElementById("modal").style.display = "none";
});



// window.addEventListener("load", (e) => {
//   fetch("http://localhost:8080/ohgym/suggestTeacherInfo")
//     .then((resp) => resp.json())
//     .then((arr) => {

//       let span = document.createElement("span");
//       span.innerText = `(${arr.length})`;

//       let suggestTest = document.getElementById("detailRequest");
//       console.log(suggestTest);
//       let template = document.getElementById("detailRequest-card-temp");

//       arr.forEach((elem) => {
//         let importTemplate = document.importNode(template.content, true);
//         let firstP = importTemplate.querySelector("p");
//         let secondP = firstP.nextElementSibling;
//         let thirdP = secondP.nextElementSibling;
//         let viewPriceBtn = importTemplate.querySelector("#modalopenbtn");
        
//         firstP.innerText = elem.id;
//         secondP.innerText = "💬  " + elem.message;
//         thirdP.innerText = "💸  " + elem.price;

//         viewPriceBtn.addEventListener("click", function () {
//           document.getElementById("modal").style.display = "block";
//         });

     
//         suggestTest.append(importTemplate);  
//       });
//     });
// });