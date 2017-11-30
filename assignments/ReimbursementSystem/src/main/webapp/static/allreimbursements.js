//http request to disp
function requestReimbursements() {
    let xhttp = new XMLHttpRequest();
    let reimbursements = document.getElementById('reimbursements');

    xhttp.onload = (resp) => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            //window.location = './reimb.html';
            let jsonObj = JSON.parse(xhttp.responseText);
            console.log(jsonObj);
            for (let i = 0; i < jsonObj.length; i++) {
                console.log(jsonObj[i]);
                addTableRow(jsonObj[i]);
            }
        }
    }

    xhttp.open('POST', '../reimbursements/all-reimbursements');
    xhttp.send();
}

function addTableRow(jsonObject) {
    let reimbTable = document.getElementById('reimbTable');
    if (jsonObject.description == undefined) {
        jsonObject.description = " ";
    }
    if (jsonObject.reimbResolver.firstname == undefined) {
        jsonObject.reimbResolver.firstname = " ";
        jsonObject.reimbResolver.lastname = " ";
    }
    if (jsonObject.reimbResolved == undefined) {
        jsonObject.reimbResolved = " ";
    }
    if (jsonObject.reimbResolver.usersId === 0) {
        jsonObject.reimbResolver.usersId = " ";
    }

    let tr = document.createElement("tr");
    tr.innerHTML = `
    <td>${jsonObject.reimbId}</td>
    <td>${jsonObject.reimbAuthor.firstName} ${jsonObject.reimbAuthor.lastName} </td>
    <td>${jsonObject.reimbAmount}</td>
    <td>${jsonObject.reimbSubmitted}</td>
    <td>${jsonObject.reimbStatusId.status}</td>
    <td>${jsonObject.reimbTypeId.type}</td>
    <td>${jsonObject.reimbResolved}</td>
    <td>${jsonObject.reimbResolver.usersId}</td>
    <td>${jsonObject.description}</td>
    `
    reimbTable.appendChild(tr);
}

let firstTime = 1;
function filter() {

    let typeOptions = document.getElementById('filterBy');
    let filterBy = typeOptions.options[typeOptions.selectedIndex].value;
    
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            let jsonObj = JSON.parse(xhttp.responseText);
            for (let i = 0; i < jsonObj.length; i++) {
                console.log(jsonObj[i]);
                addTableRow(jsonObj[i]);
            }
        }

        let table = document.getElementById('reimbTable');
        let rows = table.getElementsByTagName('tr');

        for (let i = 1; i < rows.length; i++) {
            let status = rows[i].getElementsByTagName('td')[4];
            if (status) {
                if (status.innerHTML.toUpperCase() === filterBy.toUpperCase()) {
                    rows[i].style.display = " ";
                } else {
                    rows[i].style.display = "none";
                }
            }
        }
    }
    xhttp.open('POST', '../reimbursements/all-reimbursements');
    xhttp.send();
}

//////////////////////////////////////////////
function update() {
    window.location="./aprove-deny.html"
}

function changeURL(){
   
    let xhttp = new XMLHttpRequest;
    xhttp.onreadystatechange = (resp) => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            window.location="./aprove-deny.html";
    }
    xhttp.open('GET', '../reimbursements/aprove-deny');
    xhttp.send();
    }   
}
