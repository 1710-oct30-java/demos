function displayReimbursements(url) {
let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = () => {
		console.log(`state changed ${xhttp.readyState}`);
		if(xhttp.readyState === 4 && xhttp.status === 200) {
			console.log('we have the response ready');
			let reimb = JSON.parse(xhttp.responseText);

			document.getElementById("reimbursements").innerHTML = 
				`
					<table id="tb-reimbursements" class="table table-hover">
						<thead>
							<tr>
				                <th scope="col">ID</th>
				                <th scope="col">Amount</th>
				                <th scope="col">Sumitted</th>
				                <th scope="col">Resolved</th>
				                <th scope="col">Description</th>
				                <th scope="col">Resolver</th>
				                <th scope="col">Status</th>
				                <th scope="col">Type</th>
				            </tr>
			            </thead>
			            <tbody>
				`;
			var options = {  
				    weekday: "long", year: "numeric", month: "short",  
				    day: "numeric", hour: "2-digit", minute: "2-digit"  
				};
			for(let i = 0; i < reimb.length; i++) {
				let resolved = reimb[i].r_resolved;
				let description = reimb[i].r_description;
				let resolver = reimb[i].r_resolver;
				let type = getTypeString(reimb[i].r_type_id);
				let status = getStatusString(reimb[i].r_status_id);
				
				if(resolved === null) {
					resolved = " - ";
				}
				
				if(description === null) {
					description = " - ";
				}
				
				if(resolver === 0) {
					resolver = " - ";
				}
				
				document.getElementById("tb-reimbursements").innerHTML += 
					`
						<tr>
			                <td><a href="javascript:void(0);">${reimb[i].r_id}</a></td>
			                <td>$ ${reimb[i].r_amount}</td>
			                <td>${reimb[i].r_submitted}</td>
			                <td>${resolved}</td>
			                <td>${description}</td>
			                <td>${resolver}</td>
			                <td>${status}</td>
			                <td>${type}</td>
			            </tr>
					`;
			}
			
			document.getElementById("reimbursements").innerHTML += 
				`
						</tbody>
					</table>
				`;
			
			
		}
		else if(xhttp.readyState === 4){
			console.log("Failed to load reimbursement!");
		}
	}	
	
	xhttp.open('GET', url);
	xhttp.send();
}

function getTypeString(type) {
	switch(type) {
		case 1: 
			type = 'Lodging';
			break;
			
		case 2: 
			type = 'Travel';
			break;
			
		case 3: 
			type = 'Food';
			break;
			
		case 4: 
			type = 'Other';
			break;
	}
	return type;
}

function getStatusString(status) {
	switch(status) {
		case 1: 
			status = 'Pending';
			break;
			
		case 2: 
			status = 'Approved';
			break;
			
		case 3: 
			status = 'Denied';
			break;
	}
	return status;
}


function searchReimbursements() {
	let input, filter, found, table, tr, td, i, j;
    input = document.getElementById("reimbursement-search-input");
    filter = input.value.toUpperCase();
    table = document.getElementById("tb-reimbursements");
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {
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


/*
function searchReimbursements() {
	let input, filter, table, tr, i;
	input = document.getElementById("reimbursement-search-input");
	filter = input.value.toUpperCase();
	table = document.getElementById("tb-reimbursements");
	tr = table.getElementsByTagName("tr");

	for (i = 0; i < tr.length; i++) {
		td0 = tr[i].getElementsByTagName("td")[0];
		td1 = tr[i].getElementsByTagName("td")[1];
		td2 = tr[i].getElementsByTagName("td")[2];
		td3 = tr[i].getElementsByTagName("td")[3];
		td4 = tr[i].getElementsByTagName("td")[4];
		td5 = tr[i].getElementsByTagName("td")[5];
		td6 = tr[i].getElementsByTagName("td")[6];
		td7 = tr[i].getElementsByTagName("td")[7];
		
		if (td0) {
			if (td0.textContent.toUpperCase().indexOf(filter) > -1 || td1.textContent.toUpperCase().indexOf(filter) > -1 || td2.textContent.toUpperCase().indexOf(filter) > -1 || td3.textContent.toUpperCase().indexOf(filter) > -1 || td4.textContent.toUpperCase().indexOf(filter) > -1 || td5.textContent.toUpperCase().indexOf(filter) > -1 || td6.textContent.toUpperCase().indexOf(filter) > -1 || td7.textContent.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}
*/


/**
 * Search reimbursements by status
 */
/*
function searchReimbursementsManager() {
	let input, filter, table, tr, i;
	input = document.getElementById("reimbursement-search-input");
	filter = input.value.toUpperCase();
	table = document.getElementById("tb-reimbursements");
	tr = table.getElementsByTagName("tr");

	for (i = 0; i < tr.length; i++) {
		td0 = tr[i].getElementsByTagName("td")[0];
		td1 = tr[i].getElementsByTagName("td")[1];
		td2 = tr[i].getElementsByTagName("td")[2];
		td3 = tr[i].getElementsByTagName("td")[3];
		td4 = tr[i].getElementsByTagName("td")[4];
		td5 = tr[i].getElementsByTagName("td")[5];
		td6 = tr[i].getElementsByTagName("td")[6];
		td7 = tr[i].getElementsByTagName("td")[7];
		td8 = tr[i].getElementsByTagName("td")[8];
		
		if (td0) {
			if (td0.textContent.toUpperCase().indexOf(filter) > -1 || td1.textContent.toUpperCase().indexOf(filter) > -1 || td2.textContent.toUpperCase().indexOf(filter) > -1 || td3.textContent.toUpperCase().indexOf(filter) > -1 || td4.textContent.toUpperCase().indexOf(filter) > -1 || td5.textContent.toUpperCase().indexOf(filter) > -1 || td6.textContent.toUpperCase().indexOf(filter) > -1 || td7.textContent.toUpperCase().indexOf(filter) > -1 || td8.textContent.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}
*/

/**
 * Search reimbursements by status
 */
function searchUsers() {
	let input, filter, found, table, tr, td, i, j;
    input = document.getElementById("user-search-input");
    filter = input.value.toUpperCase();
    table = document.getElementById("tb-users");
    tr = table.getElementsByTagName("tr");
    for (i = 1; i < tr.length; i++) {
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

function hideAllReimbursements() {
	document.getElementById('reimbursement-search-input').style.display = "none";
	document.getElementById('all-reimbursements').style.display = "none";
}

function showAllReimbursements() {
	document.getElementById('reimbursement-search-input').style.display = "block";
	document.getElementById('all-reimbursements').style.display = "block";
}

function showAllUsers() {
	document.getElementById('user-search-input').style.display = "block";
	document.getElementById('all-users').style.display = "block";
}

function hideAllUsers() {
	document.getElementById('user-search-input').style.display = "none";
	document.getElementById('all-users').style.display = "none";
}

function hideSearchBoxes() {
	document.getElementById('user-search-input').style.display = "none";
	document.getElementById('reimbursement-search-input').style.display = "none";
}

let windowLocation = window.location.pathname;
if(windowLocation === '/ERS/pages/reimbursements') {
	document.getElementById('body-reimbursement').addEventListener("load", displayReimbursements('../pages/data?id=view'), false);
}