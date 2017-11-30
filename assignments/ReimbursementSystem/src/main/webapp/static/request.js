function addReimbursement(){
    let amount = document.getElementById('amount').value;
    let description = document.getElementById('description').value;
    let typeOptions = document.getElementById('reimbType');
    let reimbType = typeOptions.options[typeOptions.selectedIndex].value;

    console.log(amount);
    console.log(description);
    console.log(reimbType);

    let reimbursement = {
        "reimbAmount": amount,
        "reimbDescription": description,
        "reimbType": reimbType
    }

    //xhttp request 
    let xhttp = new XMLHttpRequest();
    
    xhttp.onload = (resp) =>{
        if(xhttp.readyState === 4 && xhttp.status === 200){
            //open reimbursement window with new request
            console.log("added reimbursement request");
            //window.location = './reimb.html';
        }

        xhttp.open('POST', '../reimbursements/request');        
        xhttp.send(JSON.stringify(reimbursement));
    }
}


