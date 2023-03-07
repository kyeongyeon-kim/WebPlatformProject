// 서비스 타입 콤보박스 이벤트
let type = document.getElementById("type");
type.addEventListener("change", choiceType);
function choiceType() {
    let selectType = type.options[type.selectedIndex].text;
	let sectionTag = getElementsByTagName("section");
	sectionTag.style.display = "none";
	/*let profile = document.getElementsByClassName("profile-container");
        if (selectType == profile.class) {
            profile.style.display = "block";
        } else if (selectType == "서비스 선택") {
            profile.style.display = "block";
        } else {
            profile.style.display = "none";
        }
*/
}

// 서비스 지역 콤보박스 이벤트
let area = document.getElementById("area");
area.addEventListener("change", choiceArea);
function choiceArea() {
    let selectArea = area.options[area.selectedIndex].text;
}

// 서비스 검색 이벤트
let searchBtn = document.getElementById("search-btn");
searchBtn.addEventListener("click", searchInput);
function searchInput() {
    let text = getInput();
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

function search(str) {
	fetch("http://localhost:8080/ohgym/find",{
	    method:"POST",
	    headers: {
	        "Content-Type":"text/plain",
	    },
	    body: str,
	    })

}