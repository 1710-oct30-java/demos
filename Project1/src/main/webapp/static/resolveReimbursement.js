let resolveReimbursement = () => {
	let id = document.getElementById('inputId').value;
	let statusId = document.getElementById('inputStatusId').value;
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onload = (resp) => {
		//resp contains the response body
		if (xhttp.status === 200){
			//alert("reimbursement resolved");
		} else {
			//alert("failed to resolve reimbursement");
		}
	}
	xhttp.onerror = () => {
		alert("failed to resolve reimbursement");
	}
	xhttp.open('PUT', '../reimbursement');
	
	let reimb = {
			"reimb_id":id,
			"reimb_status_id":statusId
	}
	xhttp.send(JSON.stringify(reimb));
}