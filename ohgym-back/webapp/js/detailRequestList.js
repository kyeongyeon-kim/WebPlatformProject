// <!-- <template id="pick-card-temp" >
// <a href="#">
// <li>
//       <div id="pick-card" style="display: flex;">
//             <div>
//             <p></p>
//             <p></p>
//             <div style="display:flex; align-items: flex-start;">
//             <img class="score" src="../img/star.png" alt="">
//             <span id="score">4.8</span>
//             </div>
//              </div>
//             <img id="pick-image" src="../img/health.png" alt="techer-img">
//       </div>
// </a>
// </li>
// </template> -->

// <!-- <template id="detailRequest-card-temp">
// <li>
//       <div id="detailRequest-card">
//             <p></p>
//             <p></p>
//             <p> </p>
//       </div>
//       <div class="bottom">
//             <button type="button" id="modalopenbtn"> 견적서 보기</button>
//       </div>
// </li>
// </template> -->

// window.addEventListener("load", (e) => {
//   fetch("http://localhost:8080/ohgym/suggestGo")
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

// document.getElementById("modalclosebtn").addEventListener("click", function () {
//   document.getElementById("modal").style.display = "none";
// });
