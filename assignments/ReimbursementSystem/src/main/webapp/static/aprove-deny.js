function pendingReimbursements() {
    let xhttp = new XMLHttpRequest;
    let div = document.getElementById('reimbursements');

    xhttp.onreadystatechange = (resp) => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            //window.location = './aprove-deny.html';
            let jsonObj = JSON.parse(xhttp.responseText);
            console.log(jsonObj);
            for (let i = 0; i < jsonObj.length; i++) {
                
                if (jsonObj[i].reimbStatusId.statusId === 1) {
                    console.log('status id', jsonObj[i].reimbStatusId.statusId);
                    pendingReimb(jsonObj[i]);

                }
            }
        }
    }
    //get all the reimbursements that the manager can approve or deny
    xhttp.open('GET', '../reimbursements/aprove-deny');
    xhttp.send();
}

function updateReimbursement(rowNum) {
    //console.log(rowNum);
    let rowI = rowNum;    
    let t = document.getElementById('pendingRequests');
    let r = document.getElementsByTagName('tr');
    let reimbId = r[rowI].getElementsByTagName('td')[0].innerHTML;
    let tData4 = r[rowI].getElementsByTagName('td')[4];
    let manOpts = tData4.firstChild;
    let selOpts = manOpts.options;//[manOpts.selectedIndex].value;

    //console.log(manOpts);
    //console.log(selOpts);
    let newStatus = selOpts[manOpts.selectedIndex].value;
    
    console.log('reimbId:',reimbId);
    console.log('status:',newStatus);
   
    let reimbursement = {
        "reimbId": reimbId,
        "reimbStatusId":{"statusId":newStatus} 
    }

    let xhttp = new XMLHttpRequest;

    //update the reimbursement
    xhttp.onload = (resp) => {
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            window.location = "./aprove-deny.html";
        }
    }
    //get all the reimbursements that the manager can approve or deny
    xhttp.open('POST', '../reimbursements/update');
    xhttp.send(JSON.stringify(reimbursement));
}

//reimbursement
function pendingReimb(jsonObject) {
    let rTable = document.getElementById('pendingRequests');
    if (jsonObject.description == undefined) {
        jsonObject.description = " ";
    }

    let tRow = document.createElement("tr");
    tRow.innerHTML = `
    <td>${jsonObject.reimbId}</td>
    <td>${jsonObject.reimbAuthor.firstName} ${jsonObject.reimbAuthor.lastName}</td>
    <td>${jsonObject.reimbAmount}</td>
    <td>${jsonObject.reimbSubmitted}</td>
    <td><select id="update">
            <option selected disabled>Update Status</option>
                <option value="2">Approve</option>
                <option value="3">Deny</option> 
            </select></td>
    <td>${jsonObject.reimbTypeId.type}</td>
    <td>${jsonObject.description}</td>
    <td><button onclick="getRow(this);" >Update</button></td>
    `;

    rTable.appendChild(tRow);
}

function getRow(btn){
    console.log(btn.parentNode.parentNode.rowIndex);
    updateReimbursement(btn.parentNode.parentNode.rowIndex);
}




