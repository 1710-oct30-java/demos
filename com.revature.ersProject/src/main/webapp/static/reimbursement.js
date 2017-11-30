function showAddReimbursement() {
    window.location = './addReimbursement.html';
}

function displayByUser() {
    let xhttp = new XMLHttpRequest(); 
    let txt = '';
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                let reimbursement = JSON.parse(xhttp.responseText);
                txt += "<table border='2'>\
                            <thead class='thead-dark'>\
                                <tr>\
                                    <th>ID</th>\
                                    <th>Amount</th>\
                                    <th>Date Submitted</th>\
                                    <th>Time Resolved</th>\
                                    <th>Description</th>\
                                    <th>Author</th>\
                                    <th>Resolver</th>\
                                    <th>Status</th>\
                                    <th>Type</th>\
                                </tr>\
                            </thead>\
                            <tbody>"

                for (x in reimbursement) {
                    let d = new Date(parseInt(reimbursement[x].submitted));
                    reimbursement[x].submitted = d.toLocaleDateString();
                    
                    if(reimbursement[x].status === 1){
                        reimbursement[x].status = 'Pending';
                    }
                    else if(reimbursement[x].status === 2){
                        reimbursement[x].status = 'Approved';
                    }
                    else{
                        reimbursement[x].status = 'Denied';
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
                    txt += "<td>" + reimbursement[x].amount + "</td>";
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
    }
    xhttp.open('GET', '../reimbursements/user');
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
            window.location = './index.html';
        }
        else {
            alert('Unable to add the reimbursement');
        }
    }
    
    xhttp.open('POST', '../reimbursements/add');
    xhttp.send(JSON.stringify(newReimbursement)); 
}