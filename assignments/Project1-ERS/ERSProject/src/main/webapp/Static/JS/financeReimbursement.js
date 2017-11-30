function searchTable() {
    var input, filter, found, table, tr, td, i, j;
    input = document.getElementById("search");
    filter = input.value.toUpperCase();
    table = document.getElementById("table");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++) {
            if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
                found = true;
            }
        }
        if (found) {
            tr[i].style.display = "";
            found = false;
        } else {
            tr[i].style.display = "none";
        }
    }
}

function getReimbursements() {
    let xhttp = new XMLHttpRequest(); 
    let txt = '';
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            let reimbursement = JSON.parse(xhttp.responseText);
            for (x in reimbursement) {
                let status = '';
                let d = new Date(parseInt(reimbursement[x].submitted));
                reimbursement[x].submitted = d.toLocaleDateString();
                if(reimbursement[x].resolved != null){
                    let rd = new Date(parseInt(reimbursement[x].resolved));
                    reimbursement[x].resolved = rd.toLocaleDateString();
                }
                else {
                    reimbursement[x].resolved = 'Unresolved';
                    reimbursement[x].resolverId = 'Unresolved';
                }

                if(reimbursement[x].status === 1){
                    reimbursement[x].status = 'Pending';
                }
                else if(reimbursement[x].status === 2){
                    reimbursement[x].status = 'Approved';
                    status = 'approved';
                }
                else{
                    reimbursement[x].status = 'Denied';
                    status = 'denied';
                }

                if(reimbursement[x].type === 1){
                    reimbursement[x].type = 'Lodging';
                }
                else if(reimbursement[x].type === 2){
                    reimbursement[x].type = 'Travel';
                }
                 else if(reimbursement[x].type === 3){
                    reimbursement[x].type = 'Food';
                }
                else{
                    reimbursement[x].type = 'Other';
                }

                txt += "<tr class= " + status +">";
                txt += "<td>" + reimbursement[x].id + "</td>";
                txt += "<td>" + "$" + reimbursement[x].amount + "</td>";
                txt += "<td>" + reimbursement[x].submitted + "</td>";
                txt += "<td>" + reimbursement[x].resolved + "</td>";
                txt += "<td>" + reimbursement[x].description + "</td>";
                txt += "<td>" + reimbursement[x].authorId + "</td>";
                txt += "<td>" + reimbursement[x].resolverId + "</td>";
                txt += "<td>" + reimbursement[x].status + "</td>";
                txt += "<td>" + reimbursement[x].type + "</td>";
                txt += "</tr>";
                txt += "</tbody>"
                txt += "</table>"  
                document.getElementById("table").innerHTML = txt;
            }
        }
    }
    xhttp.open('GET', '../reimbursements/all');
    xhttp.send();
}

function submitReimbursement() {
    let type = document.getElementById('type').value;
    let typeId;
    if(type === 'Lodging'){
        typeId = 1;
    }
    else if(type === 'Travel'){
        typeId = 2;
    }
    else if(type === 'Food'){
        typeId = 3;
    }
    else{
        typeId = 4;
    }
    
    let status = 1;
    let resolver = null;
    let amount = document.getElementById('amount').value;
    let description = document.getElementById('description').value;
    let submitted = Date.now();
    let author;
    
    let newReimbursement = {
        "amount": amount,
        "submitted": submitted,
        "resolved": null,
        "description": description,
        "authorId": author,
        "resolverId": resolver,
        "status": status,
        "type": typeId,
    }
    
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if(xhttp.status === 200){
            console.log("showing new view");
            alert('Added new reimbursement');
            window.location = './finance-manager-dash.html';
        }
        else {
            alert('Unable to add the reimbursement');
        }
    }
    
    xhttp.open('POST', '../reimbursements/add');
    xhttp.send(JSON.stringify(newReimbursement)); 
}

function approveDeny() {
    let choice = document.getElementById('status').value;
    let reimbId = document.getElementById('reimbId').value;
    
    let statusId;
    if(choice === 'Approve'){
        statusId = 2;
    }
    else if (choice === 'Deny') {
        statusId = 3;
    }
    
    let reimbursement = {
        "id": reimbId,
        "status": statusId
    }
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            window.location = './finance-manager-dash.html';
        }
        else {
            alert('Unable to change the status. Please try again later.');
        }
    }
    if(statusId === 2){
        xhttp.open('POST', '../reimbursements/approve');
        xhttp.send(JSON.stringify(reimbursement));
    }
    else {
        xhttp.open('POST', '../reimbursements/deny');
        xhttp.send(JSON.stringify(reimbursement));
    }
}

function logout() {
    let xhttp = new XMLHttpRequest();
    
    xhttp.onload = (resp) => {
        if(xhttp.status === 200){
            window.location = './login.html';
        }
        else {
            alert('failed to logout');
        }
    }
    xhttp.open('GET', '../users/logout');
    xhttp.send();
}
