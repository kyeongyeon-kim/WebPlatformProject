const idInput = document.getElementById("id");
idInput.addEventListener("input", function () {
  const valueId = this.value;
  if (valueId === "") {
    this.setCustomValidity("아이디를 입력해주세요.");
  } else if (valueId.length > 10) {
    this.setCustomValidity("아이디는 10자 이하여야 합니다.");
  } else if (!/^[ㄱ-힣a-zA-Z0-9_-]{1,10}$/.test(valueId)) {
    this.setCustomValidity("아이디를 잘못 입력했습니다.");
  } else {
    this.setCustomValidity("");
  }
});

const passwordInput = document.getElementById("password");
passwordInput.addEventListener("input", function () {
  const valuePassword = this.value;
  if (valuePassword === "") {
    this.setCustomValidity("비밀번호를 입력해주세요.");
  } else if (valuePassword.length > 10) {
    this.setCustomValidity("비밀번호는 10자 이하여야 합니다.");
  } else if (!/^[a-zA-Z0-9_-]{1,10}$/.test(valuePassword)) {
    this.setCustomValidity("비밀번호를 잘못 입력했습니다.");
  } else {
    this.setCustomValidity("");
  }
});

const rememberCheck = document.getElementById("remember-check");
const userIdInput = document.getElementById("id");

// 로드 시,  아이디 체크박스 업데이트
window.onload = () => {
  const storedId = localStorage.getItem("userId");
  if (storedId) {
    userIdInput.value = storedId;
    rememberCheck.checked = true;
  }
};

// 클릭할 때마다 아이디 저장 삭제
rememberCheck.addEventListener("click", () => {
  if (rememberCheck.checked) {
    localStorage.setItem("userId", userIdInput.value);
  } else {
    localStorage.removeItem("userId");
  }
});

const loginForm = document.querySelector("#login-form");

loginForm.addEventListener("click", () => {
  if (loginForm.checked) {
    localStorage.setItem("userId", userIdInput.value);
  } else {
    localStorage.removeItem("userId");
  }
});

loginForm.addEventListener("submit", function (event) {
  if (!this.checkValidity()) {
    event.preventDefault();
  }
});
