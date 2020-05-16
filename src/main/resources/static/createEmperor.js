// EMPEROR APIs


const REQ1 = new XMLHttpRequest();
function createEmperor() {

    let data = `{"name": "${document.getElementById("empName").value}", "reignStart": "${document.getElementById("reignStart").value}", "reignEnd": "${document.getElementById("reignEnd").value}", "articles": []}`;
    // let data = `{"id": 1, "name": "Trajan", "reignStart": "start", "reignEnd": "end", "articles": []}`

    REQ1.open("POST", `http://localhost:8181/createEmperor`);
    REQ1.setRequestHeader("Content-Type", "Application/json");
    REQ1.setRequestHeader("Access-Control-Allow-Origin", "*");
    REQ1.send(data);

    REQ1.onload = () => {
        if (REQ1.status === 201) {
            console.log(REQ1.response);
            console.log("emperor created");
            // alert("You created the Emperor " + document.getElementById("empName").value);
        } else {
            console.log("handle error");
        }
    }
}
let buttCreateEmperor = document.querySelector("#four");
buttCreateEmperor.addEventListener("click", createEmperor);