function displayAllUsers() {
		
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = () => {
		console.log(`state changed ${xhttp.readyState}`);
		if(xhttp.readyState === 4 && xhttp.status === 200) {
			console.log('we have the response ready');
			let user = JSON.parse(xhttp.responseText);

			document.getElementById("users").innerHTML = 
				`
					<table id="tb-users" class="table table-hover">
						<thead>
							<tr>
				                <th scope="col">ID</th>
				                <th scope="col">Username</th>
				                <th scope="col">First Name</th>
				                <th scope="col">Last Name</th>
				                <th scope="col">Email</th>
				                <th scope="col">Role</th>
				            </tr>
			            </thead>
			            <tbody>
				`;
			
			for(let i = 0; i < user.length; i++) {
				let role = user[i].role_id;
				
				if(role === 1) {
					role = 'Manager';
				}
				
				else if (role === 2) {
					role = 'Employee';
				}
				
				document.getElementById("tb-users").innerHTML += 
					`
						<tr>
			                <td><a href="javascript:void(0);">${user[i].user_id}</a></td>
			                <td>${user[i].username}</td>
			                <td>${user[i].firstName}</td>
			                <td>${user[i].lastName}</td>
			                <td>${user[i].email}</td>
			                <td>${role}</td>
			            </tr>
					`;
			}
			
			document.getElementById("users").innerHTML += 
				`
							</tbody>
						</table>
				`;
			
		}
		else if(xhttp.readyState === 4){
			console.log("Failed to load users!");
		}
	}	
	
	xhttp.open('GET', `../../pages/data?id=view-users`);
	xhttp.send();

}


/**
 * Returns username of user_id
 * @param user_id
 * @returns username
 */
function getUsername(user_id) {
	return user_id; // will be converted from number to string
}


function displayAllReimbursements(url) {
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
					                <th scope="col">User</th>
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
				                <td>${reimb[i].r_author}</td>
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