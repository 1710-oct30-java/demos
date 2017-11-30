function addReimbursement() {
	hideAddButton();
	showLoader();
	
	let amount = document.getElementById('r_amount').value;
    let type = getType();
    let description = document.getElementById('r_description').value;
	
    let reimbursement = {
    	"r_amount" : amount,
    	"r_type_id" : type,
    	"r_description": description
    }
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.open('POST', '../../pages/reimbursements/add');
    
    xhttp.onreadystatechange = function () {
	  
	  if(xhttp.getResponseHeader("success") === 'true') {
		  console.log(xhttp.getResponseHeader("success"));
	    document.getElementById('info').innerHTML = 
	    `
	    	<div class="alert success">
			  <span class="closebtn">&times;</span>  
			  <strong>Success!</strong> Reimbursement added!
			</div>
	    `;
	    document.getElementById("add-reimbursement-form").reset();
	    showAddButton();
	    hideLoader();
	  }
	  
	  else if(xhttp.getResponseHeader("success") === 'false'){
		  document.getElementById('info').innerHTML = 
	    `
			<div class="alert">
			  <span class="closebtn">&times;</span>  
			  <strong>Oh no!</strong> Please check your input.
			</div>
	    `;  
		  
		  showAddButton();
		  hideLoader();
	  }
	};
    
    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(reimbursement));
    
}

// function returns the type number
function getType() {
	let types = document.getElementsByName('r_type_id');
	let type;
	for(let i = 0; i < types.length; i++) {
		if(types[i].checked) {
			type = types[i].value;
		}
	}
	switch(type) {
		case 'Lodging':
			type = 1;
			break;
			
		case 'Travel':
			type = 2;
			break;

		case 'Food':
			type = 3;
			break;

		case 'Other':
			type = 4;
			break;
	}

	return type;
}

/*
function disableButton() {
	document.getElementById("btn-add-reimbursement").disabled = true;
}

function enableButton() {
	document.getElementById("btn-add-reimbursement").disabled = false;
}
*/
function showAddButton() {
	document.getElementById('btn-add-reimbursement').style.display = "block";
}

function hideAddButton() {
	document.getElementById('btn-add-reimbursement').style.display = "none";
}

function showLoader() {
	document.getElementById('loader-id').style.display = "block";
}

function hideLoader() {
	document.getElementById('loader-id').style.display = "none";
}