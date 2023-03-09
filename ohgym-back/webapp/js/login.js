const idInput = document.getElementById("id");
idInput.addEventListener("input", function () {
  const valueId = this.value;
  if (valueId === "") {
    this.setCustomValidity("아이디를 입력해주세요.");
  } else if (valueId === null) {
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
  } else if (valuePassword === null) {
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
    return;
  }

  const userId = formData.get("userId");
  const password = formData.get("password");

  if (
    userId.length < 1 ||
    userId.length > 10 ||
    !/^[a-zA-Z0-9_-]+$/.test(userId)
  ) {
    const errorMessage =
      "입력한 사용자 아이디가 유효하지 않습니다. 영문, 한글, 숫자, 밑줄(_) 또는 대시(-) 문자를 사용하여 1자 이상 10자 이하로 입력해주세요.";
    const errorSpan = document.querySelector("#userIdError");
    errorSpan.textContent = errorMessage;
    return;
  }

  if (password.length < 1 || password.length > 20) {
    const errorMessage =
      "입력한 비밀번호가 유효하지 않습니다. 1자 이상 20자 이하로 입력해주세요.";
    const errorSpan = document.querySelector("#passwordError");
    errorSpan.textContent = errorMessage;
    return;
  }

  fetch("/login", {
    method: "POST",
    body: formData,
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        // 로그인에 실패한 경우
        console.log("로그인에 실패했습니다.");
      }
    })
    .then((data) => {
      // 로그인에 성공한 경우 처리할 내용
      if (data) {
        // 로그인에 성공한 경우 메인 페이지로 이동하도록 처리
        window.location.href = "./";
      }
    })
    .catch((error) => {
      console.error("Error:", error);
    });
});
