//http request to disp
function requestIndReimbursements(){
	let xhttp = new XMLHttpRequest();
	//let reimbursements = document.getElementById('reimbursements');

    xhttp.onload= (resp) => {
        if(xhttp.readyState === 4 && xhttp.status === 200){
			//window.location = './reimb.html';
            let jsonObj = JSON.parse(xhttp.responseText);
            console.log(jsonObj);
            for(let i = 0; i < jsonObj.length; i++){
                console.log(`Reimbursement Amount: ${jsonObj[i].reimbAmount}`);
                console.log(`Reimbursement Id: ${jsonObj[i].reimbId}`);
                addTableRowInd(jsonObj[i]);
            }
		}
    }

    xhttp.open('POST', '../reimbursements');
    xhttp.send();
}

function addTableRowInd(jsonObject){
    let reimbTable = document.getElementById('reimbursementTable');
    if(jsonObject.description == undefined){
        jsonObject.description = " ";
    }
    let tr = document.createElement("tr");
    tr.innerHTML =`
    <td>${jsonObject.reimbId}</td>
    <td>${jsonObject.reimbAmount}</td>
    <td>${jsonObject.reimbSubmitted}</td>
    <td>${jsonObject.reimbStatusId.status}</td>
    <td>${jsonObject.reimbTypeId.type}</td>
    <td>${jsonObject.description}</td>
    ` 
    reimbTable.appendChild(tr);
}

function reimb(){
    window.location = "./reimb.html";
}