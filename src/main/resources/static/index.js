const REQ = new XMLHttpRequest();
function createArticle() {
    let data = `{"text": "this is text"}`;
    REQ.open("POST", "http://localhost:8181/createArticle");
    REQ.setRequestHeader("Content-Type", "Application/json");
    REQ.setRequestHeader("Access-Control-Allow-Origin", "*");
    REQ.send(data);

    REQ.onload = () => {
        if (REQ.status === 201) {
            console.log(REQ.response);
            console.log("article created");
        } else {
            console.log("handle error");
        }
    }
}
let buttCreateArticle = document.querySelector("#three");
buttCreateArticle.addEventListener("click", createArticle);




const REQ2 = new XMLHttpRequest();
function getAllArticles() {
    REQ2.open("GET", "http://localhost:8181/getAllArticles");
    REQ2.setRequestHeader("Content-Type", "Application/json");
    // REQ2.setRequestHeader("Access-Control-Allow-Origin", "*");
    REQ2.responseType = "json";
    REQ2.send();

    REQ2.onload = () => {
        if (REQ2.status == 200) {
            // console.dir(REQ3);
            console.log(REQ2.response);
            console.log("here is the list of articles");
        } else {
            console.log("there was an error in retrieving the data");
        }
    }
}
let buttGetAllArticles = document.querySelector("#one");
buttGetAllArticles.addEventListener("click", getAllArticles);


const REQ4 = new XMLHttpRequest();
function getArticleById() {}


const REQ6 = new XMLHttpRequest();
function updateArticle() {}


const REQ8 =  new XMLHttpRequest();
function deleteArticle() {}




