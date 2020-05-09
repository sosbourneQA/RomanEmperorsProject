const REQ1 = new XMLHttpRequest();
let data = `{"name": "Augustus", "reignStart": "date", "reignEnd": "date"}`;

function createEmperor() {
    REQ1.open("POST", `http://localhost:8181/createEmperor`);
    REQ1.setRequestHeader("Content-Type", "Application/json");
    REQ1.setRequestHeader("Access-Control-Allow-Origin", "*");

    REQ1.onload = () => {
        if (REQ1.status === 201) {
            console.log(REQ1.response);
            console.log("emperor created");
        } else {
            console.log("handle error");
        }
    }
    REQ1.send(data);
}
let buttCreateEmperor = document.querySelector("#four");
buttCreateEmperor.addEventListener("click", createEmperor);





// const REQ3 = new XMLHttpRequest();
// function getAllEmperors() {
//
//     REQ3.open("GET", "http://localhost:8181/getAllEmperors")
//     REQ3.setRequestHeader("Content-Type", "Application/json")
//     REQ3.responseType = "json";
//
//     REQ1.onload = () => {
//         if (REQ3.status == 200) {
//             console.dir(REQ3)
//             console.log(REQ3.response)
//             console.log("here is the list of emperors")
//         } else {
//             console.log("there was an error in retrieving the data")
//         }
//     }
// }
// let buttGetAllEmperors = document.querySelector("#two");
// buttGetAllEmperors.addEventListener("click", getAllEmperors);




//
// const REQ5 = new XMLHttpRequest();
// function getEmperorById() {}
//
//
// const REQ7 = new XMLHttpRequest();
// function updateEmperor() {}
//
//
// const REQ9 =  new XMLHttpRequest();
// function deleteEmperor() {}


