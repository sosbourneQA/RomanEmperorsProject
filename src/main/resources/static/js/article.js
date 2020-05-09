const REQ = new XMLHttpRequest();
function createArticle() {
    let data = `{"text": "this is text", "emp": {id: 1} }`;
    REQ.open('POST', 'http://localhost:8181/createArticle');
    REQ.setRequestHeader('Content-Type', 'Application/json');
    REQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    REQ.send(data);

    REQ.onload = () => {
        if (REQ.status === 201) {
            console.log(REQ.response);
            console.log("article created");
        } else {
            console.log('handle error');
        }
    }
}

let buttCreateArticle = document.querySelector('#three');
buttCreateArticle.addEventListener('click', createArticle);




const REQ2 = new XMLHttpRequest();
function getAllArticles() {}


const REQ4 = new XMLHttpRequest();
function getArticleById() {}


const REQ6 = new XMLHttpRequest();
function updateArticle() {}


const REQ8 =  new XMLHttpRequest();
function deleteArticle() {}





