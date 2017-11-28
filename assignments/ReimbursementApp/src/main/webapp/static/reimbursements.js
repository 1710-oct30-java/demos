let jsonResp = xhttp.responseText;
let jsObj = JSON.parse(jsonResp);

var table = document.querySelector('table');
for (var p in jsObj) {
    let newElement = document.createElement('tr');
    for (var k in jsObj[p] ) {
        // console.log(k + ' = ' + jsObj[p][k]);
        let rowElement = document.createElement('td');
        rowElement.innerText = jsObj[p][k];
        newElement.appendChild(rowElement);
    }
        document.getElementById('fillReimb').appendChild(newElement);
} 