const inputCost = document.getElementById("input-cost");
input.addEventListener("keyup", function (e) {
  let value = e.target.value;
  value = Number(value.replaceAll(",", ""));
  if (isNaN(value)) {
    //NaN인지 판별
    input.value = 0;
  } else {
    //NaN이 아닌 경우
    const formatValue = value.toLocaleString("ko-KR");
    input.value = formatValue;
  }
});
