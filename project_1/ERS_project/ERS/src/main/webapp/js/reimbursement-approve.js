function disableSubmitChangesButton() {
	document.getElementById("submit-changes").disabled = true;
}

function enableSubmitChangesButton() {
	document.getElementById("submit-changes").disabled = false;
}

function hideSubmitChangesButton() {
	document.getElementById('submit-changes').style.display = "none";
}

function showSubmitChangesButton() { 
	document.getElementById('submit-changes').style.display = "block";
}

function approveReimbursements() {
	disableSubmitChangesButton();

	let table = document.getElementById('tb-reimbursements');
	let selection = document.getElementsByName('approve-deny-name');
	
	for (let i = 1; i < table.rows.length; i++) {
		if (table.rows[i].cells.length) {
			let r_id = (table.rows[i].cells[0].textContent.trim());
			let approveDeny = getApproveDenyOption(selection[i-1].value);
			
			let reimbursement = {
					"r_id": r_id,
					"r_status_id": approveDeny
			};
			
			if(approveDeny === 2 || approveDeny === 3) {
				let xhttp = new XMLHttpRequest();
			    
			    xhttp.open('POST', 'http://localhost:8080/ERS/pages/reimbursements/approve');
			    
			    xhttp.onreadystatechange = function () {
				  
				  if(xhttp.getResponseHeader("success") === 'true') {
					  document.getElementById(`info-icon-${i-1}`).innerHTML = 
				    `
						<img src="../../images/icons/check-icon.png" height="30" width="30">
				    `; 
				  }
				  
				  else if(xhttp.getResponseHeader("success") === 'false'){
					  document.getElementById(`info-icon-${i-1}`).innerHTML = 
				    `
						<img src="../../images/icons/error-icon.png" height="30" width="30">
				    `;  
				  }
				};
			    
			    // JSON.stringify converts a JavaScript object to JSON
			    // JSON.parse converts a string to a JavaScript object
			    xhttp.send(JSON.stringify(reimbursement));
			}
		}
	}

	enableSubmitChangesButton();
}

/**
 * Returns status_id based on selected option. 2) Approved | 3) Denied
 * @param option
 * @returns
 */
function getApproveDenyOption(option) {
	switch(option) {
		case 'Approve':
			option = 2;
			break;
			
		case 'Deny':
			option = 3;
			break;
	}
	return option;
}