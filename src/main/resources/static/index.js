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
let buttCreateArticle = document.querySelector("#one");
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
let buttGetAllArticles = document.querySelector("#three");
buttGetAllArticles.addEventListener("click", getAllArticles);


const REQ4 = new XMLHttpRequest();
function getArticleById() {

    REQ4.open("GET", "http://localhost:8181/getArticleById/1");
    REQ4.setRequestHeader("Content-Type", "Application/json");
    REQ4.responseType = "json";
    REQ4.send();

    REQ4.onload = () => {
        if(REQ4.status == 200) {
            console.dir(REQ4);
            console.log(REQ4.response);
            console.log("here is the article");
        } else {
            console.log("there was an error in retrieving the data");
        }
    }
}
let buttGetArticleById = document.querySelector("#ten");
buttGetArticleById.addEventListener("click", getArticleById);


const REQ6 = new XMLHttpRequest();
function updateArticle() {

    let data = `{"id": 1, "text": "this is an article"}`

    REQ6.open("PUT", "http://localhost:8181/updateArticle/1");
    REQ6.setRequestHeader("Content-Type", "Application/json");
    REQ6.send(data);

    REQ6.onload = () => {
        if ( REQ6.status == 200) {
            console.dir(REQ6);
            console.log(REQ6.response)
            console.log("article has been updated");
        } else {
            console.log("handle error")
        }
    }
}
let buttUpdateArticle = document.querySelector("#five");
buttUpdateArticle.addEventListener("click", updateArticle);


const REQ8 =  new XMLHttpRequest();
function deleteArticle() {

    REQ8.open("DELETE", "http://localhost:8181/deleteArticle/1");
    REQ8.setRequestHeader("Content-Type", "Application/json");
    REQ8.responseType = "json";
    REQ8.send();

    REQ8.onload = () => {
        if (REQ8.status == 204) {
            console.log(REQ8.response);
            console.log("article deleted");
        } else {
            console.log("handle error");
        }
    }
}
let buttDeleteArticle = document.querySelector("#seven");
buttDeleteArticle.addEventListener("click", deleteArticle);




