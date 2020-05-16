const REQ = new XMLHttpRequest();
function createArticle() {

    let data = `{"id": 2, "text": "${document.getElementById("url").value}", "emperor": {"id": 1}}`;
    // let data = `{"id": 2, "text": "article url goes here", "emperor": {"id": 1}}`;

    REQ.open("POST", `http://localhost:8181/createArticle`);
    REQ.setRequestHeader("Content-Type", "Application/json");
    REQ.setRequestHeader("Access-Control-Allow-Origin", "*");
    REQ.send(data);

    REQ.onload = () => {
        if (REQ.status === 201) {
            console.log(REQ.response);
            console.log("article created");
            alert("you created an article")
        } else {
            console.log("handle error");
        }
    }
}
let buttCreateArticle = document.querySelector("#article");
// let buttCreateArticle = document.querySelector("#one");
buttCreateArticle.addEventListener("click", createArticle);