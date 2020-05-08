const REQ = new XMLHttpRequest();
function createArticle() {
    let data = `{"text": "this is text"}`;
    REQ.open('POST', 'http://localhost:8181/createArticle');
    REQ.setRequestHeader('Content-Type', 'Application/json');
    REQ.setRequestHeader('Access-Control-Allow-Origin', '*');
    REQ.send(data); // what we want to send across

    REQ.onload = () => {
        if (REQ.status === 200) {
            console.log(REQ.response);
            console.log("article created");
        } else {
            console.log('handle error');
        }
    }
}

let buttCreateArticle = document.querySelector('#three');
buttCreateArticle.addEventListener('click', createArticle);


