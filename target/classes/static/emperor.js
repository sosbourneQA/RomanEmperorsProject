const REQ1 = new XMLHttpRequest();

function createEmperor() {
    let data = `{"id": "1", "reignStart" : "date", "reignEnd" : "date"}`;
    REQ1.open('POST', 'http://localhost:8181/createEmperor');
    REQ1.setRequestHeader('Content-Type', 'Application/json');
    REQ1.setRequestHeader('Access-Control-Allow-Origin', '*');
    REQ.send(data); // what we want to send across

    REQ1.onload = () => {
        if (REQ.status === 201) {
            console.log(REQ.response);
            console.log("article created");
        } else {
            console.log('handle error');
        }
    }
}

let buttCreateArticle = document.querySelector('#four');
buttCreateArticle.addEventListener('click', createEmperor);
