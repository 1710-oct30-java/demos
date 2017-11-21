function findByStatusId() {
let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = () => {
		console.log(`state changed ${xhttp.readyState}`);
		if(xhttp.readyState === 4 && xhttp.status === 200) {
			console.log('we have the response ready');
			console.log(`response text: ${xhttp.responseText}`);
			let reimb = JSON.parse(xhttp.responseText);

			document.getElementById("reimbursement-status").innerHTML = 
				`
					<table id="tb-reimbursements">
					<tr>
		                <th>ID</th>
		                <th>Amount</th>
		                <th>Sumitted</th>
		                <th>Resolved</th>
		                <th>Description</th>
		                <th>Author</th>
		                <th>Resolver</th>
		                <th>Status ID</th>
		                <th>Type ID</th>
		            </tr>
				`;
			
			for(let i = 0; i < reimb.length; i++) {
				document.getElementById("tb-reimbursements").innerHTML += 
					`
						<tr>
			                <td><a href="javascript:void(0);">${reimb[i].r_id}</a></td>
			                <td>${reimb[i].r_amount}</td>
			                <td>${reimb[i].r_submitted}</td>
			                <td>${reimb[i].r_resolved}</td>
			                <td>${reimb[i].r_description}</td>
			                <td>${reimb[i].r_author}</td>
			                <td>${reimb[i].r_resolver}</td>
			                <td>${reimb[i].r_status_id}</td>
			                <td>${reimb[i].r_type_id}</td>
			            </tr>
					`;
			}
			
			document.getElementById("reimbursement-status").innerHTML += 
				`
					</table>
				`;
			
			
		}
		else if(xhttp.readyState === 4){
			alert("Failed to load reimbursement!");
		}
	}	
	
	let num = document.getElementById("status-number").innerText = document.getElementById("status-number").value;
	xhttp.open('GET', `http://localhost:8080/ERS/pages/data?id=${num}`);
	xhttp.send();
}



function getUserFirstName() {
	let xhttp = new XMLHttpRequest();
		
	xhttp.onreadystatechange = () => {
		console.log(`state changed ${xhttp.readyState}`);
		if(xhttp.readyState === 4 && xhttp.status === 200) {
			console.log('we have the response ready');
			console.log(`response text: ${xhttp.responseText}`);
			let firstName = JSON.parse(xhttp.responseText);
			
			let num = document.getElementById("user-first-name").innerHTML = ', Hello';
			xhttp.open('GET', `http://localhost:8080/ERS/pages/home/${num}`);
			xhttp.send();
		}
	}
}



function searchReimbursements() {
	let input, filter, table, tr, td, i;
	input = document.getElementById("search-input");
	filter = input.value.toUpperCase();
	table = document.getElementById("tb-reimbursements");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[0];
		if (td) {
			if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
				tr[i].style.display = "";
			} else {
				tr[i].style.display = "none";
			}
		}
	}
}