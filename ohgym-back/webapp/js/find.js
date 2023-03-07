// 서비스 타입 콤보박스 이벤트
let type = document.getElementById("type");
type.addEventListener("change", choiceType);
function choiceType() {
	let selectType = type.options[type.selectedIndex].text;
	document.querySelectorAll("section").forEach((section) => {
		if (selectType == section.id) {
			section.style.display = "block";
		} else if (selectType == "서비스 선택") {
			section.style.display = "block";
		} else {
			section.style.display = "none";
		}
	});
}

// 서비스 지역 콤보박스 이벤트
let area = document.getElementById("area");
console.log(area);
area.addEventListener("change", choiceArea);
function choiceArea() {
    let selectArea = area.options[area.selectedIndex].text;
	document.querySelectorAll("section").forEach((section) => {
		let dataArea = section.getAttribute("data-area");
		if (dataArea && dataArea.includes(selectArea)) {
     		section.style.display = "block";
    	} else if (selectArea === "지역") {
			section.style.display = "block";
		} else {
			section.style.display = "none";
		}
	});
}

// 서비스 검색 이벤트
let searchBtn = document.getElementById("search-btn");
searchBtn.addEventListener("click", searchInput);
function searchInput() {
    let text = getInput();
	document.querySelectorAll("section").forEach((section) => {
		let dataAll = section.getAttribute("data-info");
		if (dataAll && dataAll.includes(text)) {
     		section.style.display = "block";
    	} else {
			section.style.display = "none";
		}
	});
}
let input = document.getElementById("search");
input.addEventListener("change", getInput);
input.addEventListener("keydown", function(){
    if (window.event.keyCode == 13) {
        searchInput();
    }
});
function getInput() {
    input = document.getElementById("search").value;
    console.log(input);
    return input;
}
