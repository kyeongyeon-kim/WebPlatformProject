let name = document.getElementById("name");
let introduction = document.getElementById("introduction");
fetch("http://localhost:8080/ohgym-back/find") 
            .then((resp) => resp.text())
            .then((text) => {
                // makeObj(text);
                // console.log(text);
                // const infoStr = text;
                // const infoSplit = infoStr.split(", ");
             
                introduction.innerText = text;
            });


// let teacherInfo {
    
// };
// let makeObj = function(x) {
//     const str = x;
//     const strSplit = str.split("TeacherInfo ");
//     console.log(Array.isArray(strSplit));
//     return strSplit[1];
// };
