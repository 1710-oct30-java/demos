function allUsers() {
	  
    let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
        	document.getElementById("returnBody").innerHTML = xhttp.responseText;
        } else {
            alert('invalid credentials');
        }
    }
    
    xhttp.open('GET', '/ExpenseReimbursementSystem/user/');
    
    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send();
}

function allRequests() {
	
	document.getElementById('request-table-body').innerText="";
    let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
        	// will use these later
        	let jsonResp = xhttp.responseText;
        	let jsObj = JSON.parse(jsonResp);
        	let jsonNew = xhttp.responseText;
        	
        	var table = document.querySelector('table');
        	for (var p in jsObj) {
        		let newElement = document.createElement('tr');
        		for (var k in jsObj[p] ) {

        			// Check for json string returned from dao and replace all
					// instances of id's to their appropriate strings
        			// typeId and statusId
        			
        			if(k === "typeId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Lodging";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Travel";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Food";
        				} else if (jsObj[p][k] === 4) {
        					jsObj[p][k] = "Other";
        				}
        			}
        			
        			if (k === "statusId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Pending";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Approved";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Denied";
        				}
        			}
        			
        			let rowElement = document.createElement('td');
        			rowElement.innerText = jsObj[p][k];
        			newElement.appendChild(rowElement);
        		}
        			document.getElementById('request-table-body').appendChild(newElement);
        	}  			
        	    document.getElementById("myTable").style.display = "";
        } else {
            alert('invalid credentials');
        }
    }
    xhttp.open('GET', '/ExpenseReimbursementSystem/request/');
    xhttp.send();
    
}

function allPendingRequests() {
	document.getElementById('request-table-body').innerText="";
    let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
        	let jsonResp = xhttp.responseText;
        	let jsObj = JSON.parse(jsonResp);
        	
        	var table = document.querySelector('table');
        	for (var p in jsObj) {
        		let newElement = document.createElement('tr');
        		for (var k in jsObj[p] ) {
        				
        			if(k === "typeId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Lodging";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Travel";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Food";
        				} else if (jsObj[p][k] === 4) {
        					jsObj[p][k] = "Other";
        				}
        			}
        			
        			if (k === "statusId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Pending";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Approved";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Denied";
        				}
        			}
        			
        			let rowElement = document.createElement('td');
        			rowElement.innerText = jsObj[p][k];
        			newElement.appendChild(rowElement);
        		}
        			document.getElementById('request-table-body').appendChild(newElement);
        	}  			
        	    document.getElementById("myTable").style.display = "";
        	    
        } else {
            alert('invalid credentials');
        }
    }
 
    xhttp.open('GET', '/ExpenseReimbursementSystem/request/pending/');
    xhttp.send();
}

function allApprovedRequests() {

	document.getElementById('request-table-body').innerText="";
    let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
        	let jsonResp = xhttp.responseText;
        	let jsObj = JSON.parse(jsonResp);
        	
        	var table = document.querySelector('table');
        	for (var p in jsObj) {
        		let newElement = document.createElement('tr');
        		for (var k in jsObj[p] ) {
        				
        			if(k === "typeId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Lodging";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Travel";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Food";
        				} else if (jsObj[p][k] === 4) {
        					jsObj[p][k] = "Other";
        				}
        			}
        			
        			// I leave this code in here for testing purposes
        			if (k === "statusId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Pending";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Approved";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Denied";
        				}
        			}
        			
        			let rowElement = document.createElement('td');
        			rowElement.innerText = jsObj[p][k];
        			newElement.appendChild(rowElement);
        		}
        			document.getElementById('request-table-body').appendChild(newElement);
        	}  			
        	    document.getElementById("myTable").style.display = "";
        	    
        } else {
            alert('invalid credentials');
        }
    }
 
    xhttp.open('GET', '/ExpenseReimbursementSystem/request/approved/');
    xhttp.send();
}

function allDeniedRequests() {

	document.getElementById('request-table-body').innerText="";
    let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
        	let jsonResp = xhttp.responseText;
        	let jsObj = JSON.parse(jsonResp);
        	
        	var table = document.querySelector('table');
        	for (var p in jsObj) {
        		let newElement = document.createElement('tr');
        		for (var k in jsObj[p] ) {
        				
        			if(k === "typeId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Lodging";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Travel";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Food";
        				} else if (jsObj[p][k] === 4) {
        					jsObj[p][k] = "Other";
        				}
        			}
        			
        			// code is left in here for testing purposes
        			if (k === "statusId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Pending";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Approved";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Denied";
        				}
        			}
        			
        			let rowElement = document.createElement('td');
        			rowElement.innerText = jsObj[p][k];
        			newElement.appendChild(rowElement);
        		}
        			document.getElementById('request-table-body').appendChild(newElement);
        	}  			
        	    document.getElementById("myTable").style.display = "";
        	    
        } else {
            alert('invalid credentials');
        }
    }
 
    xhttp.open('GET', '/ExpenseReimbursementSystem/request/denied/');
    xhttp.send();
}

function approveReimbursementForm() {
	document.getElementById("approveReimbursement").style.display = "";
	document.getElementById("denyReimbursement").style.display = "none";
}

function approveReimbursement() {
		
	let reimbId = document.getElementById("reimbursementId").value;
	let submission = {
			"id": reimbId
	}
	
	let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
           console.log("approve reimbursement success in JS");
           location.reload();
        } else {
            alert('invalid credentials');
            alert(xhttp.status);
        }
    }
    
    xhttp.open('POST', '/ExpenseReimbursementSystem/request/approve');
    xhttp.send(JSON.stringify(reimbId));
	
	
}


function denyReimbursementForm() {
	document.getElementById("denyReimbursement").style.display = "";
	document.getElementById("approveReimbursement").style.display = "none";
}

function denyReimbursement() {
		
	let reimbId = document.getElementById("denyId").value;
	let submission = {
			"id": reimbId
	}
	
	let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
           console.log("deny reimbursement success in JS");
           location.reload();
        } else {
            alert('invalid credentials');
            alert(xhttp.status);
        }
    }
    
    xhttp.open('POST', '/ExpenseReimbursementSystem/request/deny');
    xhttp.send(JSON.stringify(reimbId));
	
	
}

function newRequest() {
	document.getElementById("newReq").style.display = "";
	
}

function submitRequest() {
	let amount = document.getElementById("amountInput").value;
	let type = document.getElementById("reimbType").value;
	let description = document.getElementById("reimbDescription").value;

	let submission = {
			"amount" : amount,
			"typeId" : type,
			"description" : description,
	}
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
           console.log("successfully added a new reimbursement request");
           location.reload();
        } else {
            alert('invalid credentials');
            alert(xhttp.status);
        }
    }
    
    xhttp.open('POST', '/ExpenseReimbursementSystem/request/new');
    xhttp.send(JSON.stringify(submission));
	
}

function searchTable() {
    var input, filter, found, table, tr, td, i, j;
    input = document.getElementById("search");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++) {
            if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
                found = true;
            }
        }
        if (found) {
            tr[i].style.display = "";
            found = false;
        } else {
            tr[i].style.display = "none";
        }
    }
}

function myRequests() {
	
	document.getElementById('request-table-body').innerText="";
    let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
        	// will use these later
        	let jsonResp = xhttp.responseText;
        	let jsObj = JSON.parse(jsonResp);
        	let jsonNew = xhttp.responseText;
        	
        	var table = document.querySelector('table');
        	for (var p in jsObj) {
        		let newElement = document.createElement('tr');
        		for (var k in jsObj[p] ) {

        			// Check for json string returned from dao and replace all
					// instances of id's to their appropriate strings
        			// typeId and statusId
        			
        			if(k === "typeId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Lodging";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Travel";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Food";
        				} else if (jsObj[p][k] === 4) {
        					jsObj[p][k] = "Other";
        				}
        			}
        			
        			if (k === "statusId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Pending";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Approved";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Denied";
        				}
        			}
        			
        			let rowElement = document.createElement('td');
        			rowElement.innerText = jsObj[p][k];
        			newElement.appendChild(rowElement);
        		}
        			document.getElementById('request-table-body').appendChild(newElement);
        	}  			
        	    document.getElementById("myTable").style.display = "";
        } else {
            alert('invalid credentials');
        }
    }
    xhttp.open('GET', '/ExpenseReimbursementSystem/request/userAll');
    xhttp.send();
	
}

function myPending() {
	
	document.getElementById('request-table-body').innerText="";
    let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
        	// will use these later
        	let jsonResp = xhttp.responseText;
        	console.log(jsonResp);
        	let jsObj = JSON.parse(jsonResp);
        	let jsonNew = xhttp.responseText;
        	
        	var table = document.querySelector('table');
        	for (var p in jsObj) {
        		let newElement = document.createElement('tr');
        		for (var k in jsObj[p] ) {

        			// Check for json string returned from dao and replace all
					// instances of id's to their appropriate strings
        			// typeId and statusId
        			
        			if(k === "typeId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Lodging";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Travel";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Food";
        				} else if (jsObj[p][k] === 4) {
        					jsObj[p][k] = "Other";
        				}
        			}
        			
        			if (k === "statusId") {
        				if(jsObj[p][k] === 1) {
        					jsObj[p][k] = "Pending";
        				} else if (jsObj[p][k] === 2) {
        					jsObj[p][k] = "Approved";
        				} else if (jsObj[p][k] === 3) {
        					jsObj[p][k] = "Denied";
        				}
        			}
        			
        			let rowElement = document.createElement('td');
        			rowElement.innerText = jsObj[p][k];
        			newElement.appendChild(rowElement);
        		}
        			document.getElementById('request-table-body').appendChild(newElement);
        	}  			
        	    document.getElementById("myTable").style.display = "";
        } else {
            alert('invalid credentials');
        }
    }
    xhttp.open('GET', '/ExpenseReimbursementSystem/request/userPending');
    xhttp.send();
    
}

function home() {
	
	window.location = 'login.html';
	
	
}