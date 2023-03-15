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
  
  let arr = [];
  // 값 입력
  arr.push(categorystr); // user_id
  arr.push(categorystr); // teacher_id
  // 요소에서 가져오기
  arr.push(categorystr); // score
  arr.push(exercisetype); // review
  let arrdata = JSON.stringify(arr);
  fetch('http://localhost:8080/ohgym/commentrequest', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json; charset=UTF-8'
      },
      body: arrdata
  });
}
