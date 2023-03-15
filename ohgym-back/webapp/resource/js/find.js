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
area.addEventListener("change", choiceArea);
//window.addEventListener("load", choiceArea);
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
if (area.options[area.selectedIndex].text != "지역") {
	choiceArea();
}

// 서비스 검색 이벤트
let searchBtn = document.getElementById("search-btn");
searchBtn.addEventListener("click", searchInput);
function searchInput() {
  let text = document.getElementById("search").value;
  document.querySelectorAll("section").forEach((section) => {
    let dataAll = section.getAttribute("data-info");
    if (dataAll && dataAll.includes(text)) {
      section.style.display = "block";
    } else if (text === "") {
      section.style.display = "block";
    } else {
      section.style.display = "none";
    }
  });
}
let input = document.getElementById("search");
input.addEventListener("keydown", function () {
  if (window.event.keyCode == 13) {
    searchInput();
  }
});
if (input.value != null && input.value != "") {
	searchInput();	
}