function getAllReimbs() {
	
	let xhttp = new XMLHttpRequest();
	  console.log('get json called');
	  xhttp.onload = (resp) => {
			if (xhttp.status ===200) {
	        let jsonReimbs = JSON.parse(xhttp.responseText);
	        console.log(jsonReimbs[1].reimbId);
			
	        for (let i=0; i<jsonReimbs.length; i++) {
	        	//create tr and td elements
	        	  let newElement = document.createElement('tr');
	        	  let reimbIdTd = document.createElement('td');
	        	  let amountTd = document.createElement('td');
	        	  let timeSubmittedTd = document.createElement('td');
	        	  let timeResolvedTd = document.createElement('td');
	        	  let descriptionTd = document.createElement('td');
	        	  let authorTd = document.createElement('td');
	        	  let resolverTd = document.createElement('td');
	        	  let statusIdTd = document.createElement('td');
	        	  let typeIdTd = document.createElement('td');
	        	  let checkboxTd = document.createElement('td');
	        	  
	        	  let checkbox = document.createElement("INPUT");
	        	  checkbox.setAttribute("type", "checkbox");
	        	  checkbox.setAttribute("class", "checkbox");
	        	  
	        	  // get the row from json
	        	  reimbIdTd.innerText = jsonReimbs[i].reimbId;// get from json object;
	        	  amountTd.innerText = jsonReimbs[i].amount; // get from json object
//	        	  timeSubmittedTd.innerText = jsonReimbs[i].timeSubmitted;// get from json object;
	        	  let formattedTime = new Date(jsonReimbs[i].timeSubmitted);
	        	  timeSubmittedTd.innerText = formattedTime;
	        	  
//	        	  timeResolvedTd.innerText = jsonReimbs[i].timeResolved;// get from json object;
	        	  let formattedTimeRes = new Date(jsonReimbs[i].timeResolved);
	        	  timeResolvedTd.innerText = formattedTimeRes;
	        	  
	        	  descriptionTd.innerText = jsonReimbs[i].description;// get from json object;
	        	  authorTd.innerText = jsonReimbs[i].author;// get from json object;
	        	  resolverTd.innerText = jsonReimbs[i].resolver;// get from json object;
//	        	  statusIdTd.innerText = jsonReimbs[i].statusId;// get from json object;
	        	  if (jsonReimbs[i].statusId==1) statusIdTd.innerText = 'Pending';
	        	  else if (jsonReimbs[i].statusId==2) statusIdTd.innerText = 'Approved';
	        	  else if (jsonReimbs[i].statusId==3) statusIdTd.innerText = 'Denied';
	        	  else statusIdTd.innerText = null;
	        	  
//	        	  typeIdTd.innerText = jsonReimbs[i].typeId;// get from json object;
	        	  if (jsonReimbs[i].typeId==1) typeIdTd.innerText = 'Lodging';
	        	  else if (jsonReimbs[i].typeId==2) typeIdTd.innerText = 'Travel';
	        	  else if (jsonReimbs[i].typeId==3) typeIdTd.innerText = 'Food';
	        	  else if (jsonReimbs[i].typeId==4) typeIdTd.innerText = 'Other';
	        	  else statusIdTd.innerText = null;
	        	  checkboxTd = checkbox;
	        	  
	        	  // append the json row to the table
	        	  newElement.appendChild(reimbIdTd);
	        	  newElement.appendChild(amountTd);
	        	  newElement.appendChild(timeSubmittedTd);
	        	  newElement.appendChild(timeResolvedTd);
	        	  newElement.appendChild(descriptionTd);
	        	  newElement.appendChild(authorTd);
	        	  newElement.appendChild(resolverTd);
	        	  newElement.appendChild(statusIdTd);
	        	  newElement.appendChild(typeIdTd);
	        	  newElement.appendChild(checkboxTd);
	        	  
	        	  // add i'th element to the table body
	        	  document.getElementById('ers-table-body').appendChild(newElement);  
	        	} // end for loop
			}
			else {
				console.log('failed to load json')
			}
	  }
	  xhttp.open('GET', `../reimbursement/all`);
	  xhttp.send();
}

function filterByStatus() {
	 let input, filter, found, table, tr, td, i, j;
	    input = document.getElementById("myInput");
	    filter = input.value.toUpperCase();
	    table = document.getElementById("ers-table");
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

function approveSelected() {
	let checkboxes = document.getElementsByClassName("checkbox");
	let checkedReimbIds = [];
	for (let i = 0; i < checkboxes.length; i++) {
	    let checkbox = checkboxes[i];
	    let currentRow = checkbox.parentNode;
	    let reimbId = currentRow.getElementsByTagName("td")[0].innerText;
	    	if (checkbox.checked==true){
	    		checkedReimbIds.push(reimbId);
	    	}
	    }
	let xhttp = new XMLHttpRequest();
	xhttp.onload = (resp) => {
		if (xhttp.status ===200) {
			alert("Success");
			location.reload();
		} else {
			alert('failed to update approval status');
		}
	}
	xhttp.open('POST', '../reimbursement/approve');
	xhttp.send(JSON.stringify(checkedReimbIds))
}



function denySelected() {
	let checkboxes = document.getElementsByClassName("checkbox");
	let checkedReimbIds = [];
	for (let i = 0; i < checkboxes.length; i++) {
	    let checkbox = checkboxes[i];
	    let currentRow = checkbox.parentNode;
	    let reimbId = currentRow.getElementsByTagName("td")[0].innerText;
	    	if (checkbox.checked==true){
	    		checkedReimbIds.push(reimbId);
	    	}
	    }
	let xhttp = new XMLHttpRequest();
	xhttp.onload = (resp) => {
		if (xhttp.status ===200) {
			alert("Success");
			location.reload();
		} else {
			alert('failed to update approval status');
		}
	}
	xhttp.open('POST', '../reimbursement/deny');
	xhttp.send(JSON.stringify(checkedReimbIds))
}
