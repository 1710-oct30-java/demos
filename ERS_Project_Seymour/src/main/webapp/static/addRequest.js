function createRequest() {
	let amount = document.getElementById('amount').value;
	let description = document.getElementById('description').value;
	let type = document.getElementById('type').value;
	console.log(type);
	
	let reimbursement = {
			"reimbId" : null,
			  "amount" : amount,
			  "timeSubmitted" : null,
			  "timeResolved" : null,
			  "description" : description,
			  "receipt" : null,
			  "author" : 1,
			  "resolver" : 1,
			  "statusId" : 1,
			  "typeId" : type
			} 
	let xhttp = new XMLHttpRequest();
	  xhttp.onload = (resp) => {
			if (xhttp.status ===200) {
				alert("Reimbursement Added");
			}
	}
	xhttp.open('POST', '../reimbursement/add');
	xhttp.send(JSON.stringify(reimbursement));
}