const REQ7 = new XMLHttpRequest();
function updateEmperor() {

    let data = `{"id": "${parseInt(document.getElementById("empId").value)}","name": "${document.getElementById("empName").value}", "reignStart": "${document.getElementById("reignStart").value}", "reignEnd": "${document.getElementById("reignEnd").value}", "articles": []}`;
    // let data = `{"id": 1, "name": "Trajan", "reignStart": "start", "reignEnd": "end"}`

    REQ7.open("PUT", `http://localhost:8181/updateEmperor/1`);
    REQ7.setRequestHeader("Content-Type", "Application/json");
    REQ7.send(data);

    REQ7.onload = () => {
        if ( REQ7.status == 200) {
            console.dir(REQ7);
            console.log(REQ7.response)
            console.log("emperor has been updated");
        } else {
            console.log("handle error")
        }
    }
}
let buttUpdateEmperor = document.querySelector("#updateEmp");
buttUpdateEmperor.addEventListener("click", updateEmperor);