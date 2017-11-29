let xhttp = new XMLHttpRequest();
let jsonResp = xhttp.responseText;
console.log(jsonResp);
let jsonObj = JSON.parse(jsonResp);

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


xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        var myArr = JSON.parse(this.responseText);
        document.getElementById("demo").innerHTML = myArr[0];
    }
};
xmlhttp.open("GET", "json_demo_array.txt", true);
xmlhttp.send();