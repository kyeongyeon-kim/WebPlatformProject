// 팝업창
function show() {
  document.querySelector(".background").className = "background show";
}
function close() {
  document.querySelector(".background").className = "background";
}
let alarm = document.querySelector(".alarm");
if (alarm != null) {
	alarm.addEventListener("click", show);
}
let closeBtn = document.querySelector("#close");
if (closeBtn != null) {
	closeBtn.addEventListener("click", close);
}

// 검색창
let searchInput = document.getElementById("search-input");

searchInput.addEventListener("keypress", searchTeacher);
console.log(searchInput.value);

function searchTeacher() {
  	console.log(searchInput.value);
	let str = searchInput.value;
	if (window.event.keyCode == 13) {
		console.log("여기");
		console.log("http://localhost:8080/ohgym/find?search=" + str);
		fetch("http://localhost:8080/ohgym/find");
	}
}


