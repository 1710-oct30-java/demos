function displayPendingReimbursements() {
		
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
				                <th scope="col">Author</th>
				                <th scope="col">Amount</th>
				                <th scope="col">Sumitted</th>
				                <th scope="col">Description</th>
				                <th scope="col">Status</th>
				                <th scope="col">Type</th>
				                <th scope="col">Approve/Deny</th>
				                <th scope="col">Success</th>
				            </tr>
			            </thead>
			            <tbody>
				`;
			
			for(let i = 0; i < reimb.length; i++) {
				let resolved = reimb[i].r_resolved;
				let description = reimb[i].r_description;
				let type = getTypeString(reimb[i].r_type_id);
				let status = getStatusString(reimb[i].r_status_id);
				
				if(resolved === null) {
					resolved = " - ";
				}
				
				if(description === null) {
					description = " - ";
				}
				
				document.getElementById("tb-reimbursements").innerHTML += 
					`
						<tr>
			                <td><a href="javascript:void(0);">${reimb[i].r_id}</a></td>
			                <td>${reimb[i].r_author}</td>
			                <td>$ ${reimb[i].r_amount}</td>
			                <td>${reimb[i].r_submitted}</td>
			                <td>${description}</td>
			                <td>${status}</td>
			                <td>${type}</td>
			                <td>
								<select name="approve-deny-name">
								  <option value="" selected></option>
								  <option value="Approve">Approve</option>
								  <option value="Deny">Deny</option>
								</select>
							</td>
							<td><div id="info-icon-${i}" align="center"></div></td>
			            </tr>
					`;
			}
			
			document.getElementById("reimbursements").innerHTML += 
				`
							</tbody>
						</table>
				`;
		
			showSubmitChangesButton();
			
		}
		else if(xhttp.readyState === 4){
			console.log("Failed to load reimbursement!");
		}
	}	
	
	xhttp.open('GET', `../../pages/data?id=view-pending`);
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

/**
 * Search pending reimbursements by description
 */
function searchReimbursements() {
	let input, filter, table, tr, td, i;
	input = document.getElementById("search-input");
	filter = input.value.toUpperCase();
	table = document.getElementById("tb-reimbursements");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[4];	// description
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}