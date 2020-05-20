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
            populateDiv(REQ3.response);
            console.log("here is the list of emperors");
        } else {
            console.log("there was an error in retrieving the data");
        }
    }
}
let buttGetAllEmperors = document.querySelector("#getEmperors");
buttGetAllEmperors.addEventListener("click", getAllEmperors);

function populateDiv(emperors) {

    const div = this.document.getElementById("articleDiv")

    for (let emp of emperors) {

        const article = document.createElement("article");
        const divTwo = document.createElement("div");
        const image = document.createElement("img");
        const divThree = document.createElement("div");
        const divFour = document.createElement("div");
        const header = document.createElement("header");
        const hTwo = document.createElement("h2");
        const aTag = document.createElement("a");
        const pTag = document.createElement("p");



        article.className = "post invert style1 alt";
        article.id = emp.emperorId;
        divTwo.className = "image";
        image.src = "images/Augustus.jpg";
        image.position = "10% center";
        divThree.className = "content";
        divFour.className = "inner";
        hTwo.id = emp.emperorId;
        aTag.href = "profilePage.html";
        aTag.textContent = emp.name;
        pTag.textContent = emp.reignStart + " - " + emp.reignEnd;



        hTwo.appendChild(aTag);
        header.appendChild(hTwo);
        header.appendChild(pTag);
        divFour.appendChild(header);
        divThree.appendChild(divFour);
        divTwo.appendChild(image);
        article.appendChild(divTwo);
        article.appendChild(divThree);
        div.appendChild(article);


    }
}
