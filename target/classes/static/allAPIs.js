// EMPEROR APIs


const REQ1 = new XMLHttpRequest();
function createEmperor() {

    // let data = `{"name": "${document.getElementById("empName").value}", "reignStart": "${document.getElementById("reignStart").value}", "reignEnd": "${document.getElementById("reignEnd").value}", "articles": []}`;
    let data = `{"id": 1, "name": "Trajan", "reignStart": "start", "reignEnd": "end", "articles": []}`

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





const REQ3 = new XMLHttpRequest();
function getAllEmperors() {

    REQ3.open("GET", "http://localhost:8181/getAllEmperors");
    REQ3.setRequestHeader("Content-Type", "Application/json");
    // REQ3.setRequestHeader("Access-Control-Allow-Origin", "*");
    REQ3.responseType = "json";
    REQ3.send();

    REQ3.onload = () => {
        if (REQ3.status == 200) {
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

    REQ5.open("GET", `http://localhost:8181/getEmperorById/${id}`);
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
let buttGetEmperorById = document.querySelector("#nine");
buttGetEmperorById.addEventListener("click", getEmperorById);





const REQ7 = new XMLHttpRequest();
function updateEmperor() {

    let data = `{"id": 1, "name": "Trajan", "reignStart": "start", "reignEnd": "end"}`

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
let buttUpdateEmperor = document.querySelector("#six");
buttUpdateEmperor.addEventListener("click", updateEmperor);




const REQ9 =  new XMLHttpRequest();
function deleteEmperor() {

    REQ9.open("DELETE", `http://localhost:8181/deleteEmperor/1`);
    REQ9.setRequestHeader("Content-Type", "Application/json");
    REQ9.responseType = "json";
    REQ9.send();

    REQ9.onload = () => {
        if (REQ9.status == 204) {
            console.log(REQ9.response);
            console.log("emperor has been deleted");
        } else {
            console.log("handle error");
        }
    }
}
let buttDeleteEmperor = document.querySelector("#eight");
buttDeleteEmperor.addEventListener("click", deleteEmperor);





// ARTICLE


const REQ = new XMLHttpRequest();
function createArticle() {

    // let data = `{"text": "${document.getElementById("url").value}", "emperor": {"id": 1}}`;
    let data = `{"text": "article url goes here", "emperor": {"id": 1}`;

    REQ.open("POST", `http://localhost:8181/createArticle`);
    REQ.setRequestHeader("Content-Type", "Application/json");
    REQ.setRequestHeader("Access-Control-Allow-Origin", "*");
    REQ.send(data);

    REQ.onload = () => {
        if (REQ.status === 201) {
            console.log(REQ.response);
            console.log("article created");
            // alert("you created an article")
        } else {
            console.log("handle error");
        }
    }
}
// let buttCreateArticle = document.querySelector("#article");
let buttCreateArticle = document.querySelector("#four");
buttCreateArticle.addEventListener("click", createArticle);




const REQ2 = new XMLHttpRequest();
function getAllArticles() {
    REQ2.open("GET", "http://localhost:8181/getAllArticles");
    REQ2.setRequestHeader("Content-Type", "Application/json");
    REQ2.responseType = "json";
    REQ2.send();

    REQ2.onload = () => {
        if (REQ2.status == 200) {
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

    REQ4.open("GET", `http://localhost:8181/getArticleById/1`);
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

    REQ6.open("PUT", `http://localhost:8181/updateArticle/1`);
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

    REQ8.open("DELETE", `http://localhost:8181/deleteArticle/1`);
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




