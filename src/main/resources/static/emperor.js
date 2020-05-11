const REQ1 = new XMLHttpRequest();
function createEmperor() {

    let data = `{"name": "Augustus", "reignStart": "date", "reignEnd": "date"}`;

    REQ1.open("POST", `http://localhost:8181/createEmperor`);
    REQ1.setRequestHeader("Content-Type", "Application/json");
    REQ1.setRequestHeader("Access-Control-Allow-Origin", "*");
    REQ1.send(data);

    REQ1.onload = () => {
        if (REQ1.status === 201) {
            console.log(REQ1.response);
            console.log("emperor created");
        } else {
            console.log("handle error");
        }
    }
}
let buttCreateEmperor = document.querySelector("#four");
buttCreateEmperor.addEventListener("click", createEmperor);





const REQ3 = new XMLHttpRequest();
function getAllEmperors() {

    REQ3.open("GET", "http://localhost:8181/getAllEmperors");
    REQ3.setRequestHeader("Content-Type", "Application/json");
    // REQ3.setRequestHeader("Access-Control-Allow-Origin", "*");
    REQ3.responseType = "json";
    REQ3.send();

    REQ3.onload = () => {
        if (REQ3.status == 200) {
            // console.dir(REQ3);
            console.log(REQ3.response);
            console.log("here is the list of emperors");
        } else {
            console.log("there was an error in retrieving the data");
        }
    }
}
let buttGetAllEmperors = document.querySelector("#two");
buttGetAllEmperors.addEventListener("click", getAllEmperors);





const REQ5 = new XMLHttpRequest();
function getEmperorById() {

    REQ5.open("GET", "http://localhost:8181/getEmperorById/{id}");
    REQ5.setRequestHeader("Content-Type", "Application/json");
    REQ5.responseType = "json";

    REQ5.onload = () => {
        if(REQ5.status == 200) {
            console.dir(REQ5);
            console.log(REQ5.response);
            console.log("here is the emperor");
        } else {
            console.log("there was an error in retrieving the data");
        }
    }
}
let buttGetEmperorById = document.querySelector("#nine");
buttGetEmperorById.addEventListener("click", getEmperorById);





const REQ7 = new XMLHttpRequest();
function updateEmperor() {

    let data = `{"id": 1, "name": "Trajan", "date": "date", "date": "date"}`

    REQ7.open("PUT", "http://localhost:8181/updateEmperor/{id}");
    REQ7.setRequestHeader("Content-Type", "Application/json");
    REQ7.send(data);

    REQ7.onload = () => {
        if ( REQ7.status == 200) {
            console.dir(REQ7);
            console.log(REQ7.response)
            console.log("emperor has been updates");
        } else {
            console.log("handle error")
        }
    }
}
let buttUpdateEmperor = document.querySelector("#six");
buttUpdateEmperor.addEventListener("click", updateEmperor);
S



const REQ9 =  new XMLHttpRequest();
function deleteEmperor() {

    REQ9.open("DELETE", "http://localhost:8181/deleteEmperor/{id}");
    REQ9.setRequestHeader("Content-Type", "Application/json");
    REQ9.responseType = "json";

    REQ9.onload = () => {
        if (REQ9.status == 204) {
            console.log(REQ9.response);
        } else {
            console.log("handle error");
        }
    }
}
let buttDeleteEmperor = document.querySelector("#eight");
buttDeleteEmperor.addEventListener("click", deleteEmperor);


