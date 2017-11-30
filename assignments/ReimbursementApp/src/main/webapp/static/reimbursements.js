let xhttp = new XMLHttpRequest();
xhttp.onload = (resp) => {
    if (xhttp.status === 200) {
        let jsonResp = xhttp.responseText;
        let jsonObj = JSON.parse(jsonResp);
        let table = document.querySelector('table');
        for (let p in jsonObj) {
            let newElement = document.createElement('tr');
            for (let k in jsonObj[p]) {
                let rowElement = document.createElement('td');
                rowElement.innerText = jsonObj[p][k];
                newElement.appendChild(rowElement);
            }
            document.getElementById('fillReimb').appendChild(newElement);
        }
    }
}
xhttp.open('POST', 'http://localhost:8080/ReimbursementApp/history')
xhttp.send();
