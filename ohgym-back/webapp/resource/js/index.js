var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document
    .getElementsByClassName("slider")[0]
    .getElementsByTagName("img");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > slides.length) {
    slideIndex = 1;
  }
  slides[slideIndex - 1].style.display = "block";
  setTimeout(showSlides, 3000); // Change image every 3 seconds
}

//JsessionId값
let jSessionId = document.getElementById("jsessionid");
jSessionId !== null
  ? sessionStorage.setItem("id", jSessionId.innerText)
  : sessionStorage.removeItem("id");
