const REQ5 = new XMLHttpRequest();
function getEmperorById() {

    REQ5.open("GET", `http://localhost:8181/getEmperorById/1`);
    REQ5.setRequestHeader("Content-Type", "Application/json");
    REQ5.responseType = "json";
    REQ5.send();

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
let buttGetEmperorById = document.querySelector("#emperorTwo");
buttGetEmperorById.addEventListener("click", getEmperorById);



