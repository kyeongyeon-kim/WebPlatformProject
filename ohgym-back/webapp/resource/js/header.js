// 팝업창
function show() {
	document.querySelector(".background").className = "background show";
}
function close() {
	let background = document.querySelector(".background");
	background.className = "background";
	background.style.zIndex = -100;
}
let alarmBtn = document.querySelector(".alarm");
if (alarmBtn != null) {
	alarmBtn.addEventListener("click", show);
}
let closeBtn = document.querySelector("#close");
if (closeBtn != null) {
	closeBtn.addEventListener("click", close);
}

// 검색창
let searchAll = document.getElementById("search-input");
let changePage = document.getElementById("change-page");
searchAll.addEventListener("keypress", searchTeacher);

function searchTeacher() {
  	console.log(searchAll.value);
	let str = searchAll.value;
	if (window.event.keyCode == 13) {
		sessionStorage.setItem("search", str);
		window.location.href = "http://localhost:8080/ohgym/find";
	}
}


