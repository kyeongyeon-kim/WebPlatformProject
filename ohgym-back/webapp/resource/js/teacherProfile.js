window.addEventListener("load", onload);
function onload(e) {
    let teacherProfile = JSON.parse(sessionStorage.getItem("teacherProfile"));
	let profileImage = document.getElementById("profile-image");
	profileImage.src = teacherProfile.image;
	let teacherId = document.getElementById("teacherId");
	teacherId.innerText = teacherProfile.id;
	let mainService = document.getElementById("main-service");
	mainService.innerText = teacherProfile.exercise;
	let area = document.getElementById("area-input");
	area.innerText = teacherProfile.location;
	let time = document.getElementById("contactTime");
	time.innerText = teacherProfile.contactTime;
	let appeal = document.getElementById("appeal");
	appeal.innerText = teacherProfile.appeal;
	
	console.log(teacherProfile.introduction);
	let serviceIntro = document.getElementById("service-introduction").nextElementSibling;
	console.log(serviceIntro);
	serviceIntro.innerText = teacherProfile.introduction;
	
}

