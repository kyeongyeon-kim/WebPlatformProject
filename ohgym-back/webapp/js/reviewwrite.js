var teacherid = document.getElementById("teacherid");
var exercisetype = document.getElementById("exercisetype");

var reviewtap = document.getElementById("reviewtap");
window.onclick = function(event) {
  if (event.target == reviewtap) {
    reviewtap.style.display = "none";
  }
}

function reviewwrite() {
  reviewtap.style.display = "block";
  // 값 입력
  teacherid.textContent = "ohgym 부산 2호점";
  exercisetype.textContent = "클라이밍";
}

var closebtn = document.getElementById("closebtn");
closebtn.onclick = function() {
  reviewtap.style.display = "none";
}

var cancelreviewbtn = document.getElementById("cancelreviewbtn");
cancelreviewbtn.onclick = function() {
  reviewtap.style.display = "none";
}

var okreviewbtn = document.getElementById("okreviewbtn");
okreviewbtn.onclick = function() {
  reviewtap.style.display = "none";
}