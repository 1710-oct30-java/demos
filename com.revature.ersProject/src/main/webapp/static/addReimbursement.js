function addReimbursement () {
	let amount = document.getElementById("amount").value;
	let description = document.getElementById("description").value;
	let type = document.getElementById("type").value;
	let typeid; 
	
	if (type === 'Lodging'){
		typeId = 1;
	
	}
	else if 
	   (type === 'Travel'){
		typeId = 2;
	}
	else if 
	   (type === 'Food'){
		typeId = 3;
	}
	else {
		typeId = 4;
	}
	
	let submitted = Date.now();
	let status = 1;
	let resolver = null;
	let author;
	
	
    let reimbursement = {
    			       "amount": amount,
    			       "submitted": submitted,
    			       "resolved": null,
    			       "description": description,
    			       "authorId": author,
    			       "resolverId": resolver,
    			       "status": status,
    			       "type": typeId
    			       
    	
    }
    
    
    
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
    	if(xhttp.status === 200){
    		window.location='./reimbursement.html';
   
    	}
    	else {
    		alert('Unable to add reimbursement');
    }
    }
    xhttp.open('POST', '../reimbursements/add');
    xhttp.send(JSON.stringify(reimbursement));
    
    
    
    
    
    
    
    
}