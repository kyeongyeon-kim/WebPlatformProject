//팝업창
function show() {
  document.querySelector(".background").className = "background show";
}
function close() {
  document.querySelector(".background").className = "background";
}
document.querySelector(".alarm").addEventListener("click", show);
document.querySelector("#close").addEventListener("click", close);

// 검색창
let searchInput = document.getElementById("search-input");

searchInput.addEventListener("keypress", searchTeacher);
console.log(searchInput);

function searchTeacher() {
  console.log("TEST");
}
