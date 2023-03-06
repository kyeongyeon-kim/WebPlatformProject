const idInput = document.getElementById("id");
const alertMessage = document.getElementById("alert-message");
const checkBtn = document.getElementById("checkid");

checkBtn.addEventListener('click', function () {
  const valueCheckId = idInput.value;
  let param = new URLSearchParams()
  param.append("id", valueCheckId);
  
  fetch("http://localhost:8080/ohgym/checkid", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: param.toString(),
    }
  ).then(function (resp) {
    return resp.text();
  }).then(function (bodyText) {
    console.log(bodyText);
    if (bodyText === true) {
      alertMessage.innerHTML = "중복된 아이디";
    } else {
      alertMessage.innerHTML = "중복안된 아이디";
    }
  });
})

idInput.addEventListener("input", function () {
  const valueId = this.value;
  if (valueId === "") {
    this.setCustomValidity("아이디를 입력해주세요.");
    alertMessage.innerHTML = "아이디를 입력해주세요.";
  } else if (valueId.length > 10) {
    this.setCustomValidity("아이디는 10자 이하여야 합니다.");
    alertMessage.innerHTML = "아이디는 10자 이하여야 합니다.";
  } else if (!/^[a-zA-Z0-9_-]{1,10}$/.test(valueId)) {
    this.setCustomValidity("아이디를 잘못 입력했습니다.");
    alertMessage.innerHTML = "아이디를 잘못 입력했습니다.";
  } else {
    this.setCustomValidity("문제없음");
    alertMessage.innerHTML = "문제없음";
  }
});




// const ds = {
//   host: "192.168.0.104",
//   port: "3306",
//   user: "ohgym",
//   password: "root",
//   database: "ohgym"
// };

// const conn = mysql.createConnection(ds);

// const checkBtn = document.getElementById("checkid");

// checkBtn.addEventListener('click', function () {
//   const valueCheckId = idInput.value;

//   // SELECT 쿼리 실행
//   conn.query(`SELECT id FROM user WHERE id='${valueCheckId}'`, function (err, result, fields) {
//     if (err) throw err;
//     if (result.length > 0) {
//       alert("중복입니다.");
//     } else {
//       alert("중복이 아닙니다.");
//     }
//   });
// });


const passwordInput = document.getElementById("password");
passwordInput.addEventListener("input", function () {
  const valuePassword = this.value;
  if (valuePassword === "") {
    this.setCustomValidity("비밀번호를 입력해주세요.");
  } else if (valuePassword.length > 10) {
    this.setCustomValidity("비밀번호는 10자 이하여야 합니다.");
  } else if (!/^[a-zA-Z0-9_-]{4,16}$/.test(valuePassword)) {
    this.setCustomValidity("비밀번호를 잘못 입력했습니다.");
  } else {
    this.setCustomValidity("");
  }
});

const nameInput = document.getElementById("name");
nameInput.addEventListener("input", function () {
  const valueName = this.value;
  if (valueName === "") {
    this.setCustomValidity("이름을 입력해주세요.");
  } else if (valueName.length > 10) {
    this.setCustomValidity("이름은 10자 이하여야 합니다.");
  } else if (!/^[ㄱ-힣]{1,4}$/.test(valueName)) {
    this.setCustomValidity("이름을 잘못 입력했습니다.");
  } else {
    this.setCustomValidity("");
  }
});

const phoneNumInput = document.getElementById("phoneNum");
phoneNumInput.addEventListener("input", function () {
  const valuePhoneNum = this.value;
  if (valuePhoneNum === "") {
    this.setCustomValidity("전화번호를 입력해주세요.");
  } else if (valuePhoneNum.length > 11) {
    this.setCustomValidity("전화번호는 11자 이하여야 합니다.");
  } else if (!/^[0-9]{7,20}$/.test(valuePhoneNum)) {
    this.setCustomValidity("전화번호를 잘못 입력했습니다.");
  } else {
    this.setCustomValidity("");
  }
});

const signForm = document.querySelector("#signup-submit");
signForm.addEventListener("submit", function () {
  function validateForm() {
    const password = document.getElementsByName("password")[0].value;
    const passwordConfirm =
      document.getElementsByName("password-confirm")[0].value;

    if (password !== passwordConfirm) {
      const passwordConfirmInput =
        document.getElementsByName("password-confirm")[0];
      passwordConfirmInput.setCustomValidity("비밀번호가 일치하지 않습니다.");
      return false;
    } else {
      const passwordConfirmInput =
        document.getElementsByName("password-confirm")[0];
      passwordConfirmInput.setCustomValidity("");
    }

    if (!signForm.checkValidity()) {
      event.preventDefault();
      return false;
    }
    return true;
  }

  validateForm();
});
