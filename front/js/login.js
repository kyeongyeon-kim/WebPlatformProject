const idInput = document.getElementById("id");
idInput.addEventListener('input', function() {
  const valueId = this.value;
  if (valueId === '') {
    this.setCustomValidity('아이디를 입력해주세요.');
} else if (valueId.length > 15) { 
    this.setCustomValidity('아이디는 16자 이하여야 합니다.');
  } else if (!/^[a-zA-Z0-9_-]{4,16}$/.test(valueId)) {
    this.setCustomValidity('아이디를 잘못 입력했습니다.');
  } else {
    this.setCustomValidity('');
  }
});

const passwordInput = document.getElementById("password");
passwordInput.addEventListener('input', function() {
  const valuePassword = this.value;
  if (valuePassword === '') {
    this.setCustomValidity('비밀번호를 입력해주세요.');
  } else if (valuePassword.length > 15) { 
    this.setCustomValidity('비밀번호는 16자 이하여야 합니다.');
  } else if (!/^[a-zA-Z0-9_-]{4,16}$/.test(valuePassword)) {
    this.setCustomValidity('비밀번호를 잘못 입력했습니다.');
  } else {
    this.setCustomValidity('');
  }
});


const nameInput = document.getElementById("name");
nameInput.addEventListener('input', function() {
  const valueName = this.value;
  if (valueName === '') {
    this.setCustomValidity('이름을 입력해주세요.');
} else if (valueName.length > 4) { 
    this.setCustomValidity('이름은 4자 이하여야 합니다.');
  } else if (!/^[ㄱ-힣]{1,4}$/.test(valueName)) {
    this.setCustomValidity('이름을 잘못 입력했습니다.');
  } else {
    this.setCustomValidity('');
  }
});


const phoneNumInput = document.getElementById("phoneNum");
phoneNumInput.addEventListener('input', function() {
  const valuePhoneNum = this.value;
  if (valuePhoneNum === '') {
    this.setCustomValidity('전화번호를 입력해주세요.');
} else if (valuePhoneNum.length > 15) { 
    this.setCustomValidity('전화번호는 20자 이하여야 합니다.');
  } else if (!/^[0-9]{7,20}$/.test(valuePhoneNum)) {
    this.setCustomValidity('전화번호를 잘못 입력했습니다.');
  } else {
    this.setCustomValidity('');
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




const loginForm = document.querySelector('#login-form');
loginForm.addEventListener('submit', function(event) {
  if (!this.checkValidity()) {
    event.preventDefault();
  }
});





// const signForm = document.querySelector('#sign-form');
// signForm.addEventListener('submit', function(event) {
//   if (!this.checkValidity()) {
//     event.preventDefault();
//   }
// });
// function validateForm() {
//   var password = document.getElementsByName("password")[0].value;
//   var passwordConfirm = document.getElementsByName("password-confirm")[0].value;

//   if (password !== passwordConfirm) {
//     alert("비밀번호가 일치하지 않습니다.");
//     return false;
//   }
//   return true;
// }





// const signForm = document.querySelector('#sign-form');

// function validateForm() {
//   const password = document.getElementsByName('password')[0].value;
//   const passwordConfirm = document.getElementsByName('password-confirm')[0].value;
//   if (password !== passwordConfirm) {
//     alert('비밀번호가 일치하지 않습니다.');
//     return false;
//   }

//   if (!signForm.checkValidity()) {
//     event.preventDefault();
//     return false;
//   }

//   return true;
// }
// signForm.addEventListener('submit', validateForm);






const signForm = document.querySelector('#sign-form');

function validateForm(event) {
    const password = document.getElementsByName('password')[0].value;
    const passwordConfirm = document.getElementsByName('password-confirm')[0].value;
  
    if (password !== passwordConfirm) {
      const passwordConfirmInput = document.getElementsByName('password-confirm')[0];
      passwordConfirmInput.setCustomValidity('비밀번호가 일치하지 않습니다.');
      return false;
    } else {
      const passwordConfirmInput = document.getElementsByName('password-confirm')[0];
      passwordConfirmInput.setCustomValidity('');
    }
  
    if (!signForm.checkValidity()) {
      event.preventDefault();
      return false;
    }
  
    return true;
  }
  signForm.addEventListener('submit', validateForm);