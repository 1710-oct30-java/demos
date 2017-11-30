let addReimbursement = () => {
	let amount = document.getElementById('inputAmount').value;
	let description = document.getElementById('inputDescription').value;
	let typeId = document.getElementById('inputTypeId').value;
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onload = (resp) => {
		//resp contains the response body
		if (xhttp.status === 200){
			
		} else {
			
		}
	}
	xhttp.onerror = () => {
		alert("failed to add reimbursement");
	}
	xhttp.open('POST', '../reimbursement');
	
	let reimb = {
			"reimb_amount":amount,
			"reimb_description":description,
			"reimb_type_id":typeId
	}
	xhttp.send(JSON.stringify(reimb));
}