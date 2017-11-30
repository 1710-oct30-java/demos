function getTickets() {
	
	let xhttp = new XMLHttpRequest();
	  console.log('get json called');
	  xhttp.onload = (resp) => {
			if (xhttp.status ===200) {
	        let jsonReimbs = JSON.parse(xhttp.responseText);
			
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
	        	  
	        	  // get the row from json
	        	  reimbIdTd.innerText = jsonReimbs[i].reimbId;// get from json object;
	        	  amountTd.innerText = jsonReimbs[i].amount.toFixed(2); // get from json object
	        	  let formattedTime = new Date(jsonReimbs[i].timeSubmitted);
	        	  timeSubmittedTd.innerText = formattedTime;
	        	  
	        	  let formattedTimeRes = new Date(jsonReimbs[i].timeResolved);
	        	  if (jsonReimbs[i].timeResolved==null) {
	        		  timeResolvedTd.innerText = '';
	        	  } else {
	        		  console.log(jsonReimbs[i].timeResolved);
	        		  timeResolvedTd.innerText = formattedTimeRes;
	        	  }
	        	  descriptionTd.innerText = jsonReimbs[i].description;// get from json object;
	        	  authorTd.innerText = jsonReimbs[i].author;// get from json object;
	        	  if (jsonReimbs[i].resolver==0){
	        		  resolverTd.innerText = null;
	        	  } else {
	        		  resolverTd.innerText = jsonReimbs[i].resolver;// get from json object;
	        	  }
	        	  if (jsonReimbs[i].statusId==1) statusIdTd.innerText = 'Pending';
	        	  else if (jsonReimbs[i].statusId==2) statusIdTd.innerText = 'Approved';
	        	  else if (jsonReimbs[i].statusId==3) statusIdTd.innerText = 'Denied';
	        	  else statusIdTd.innerText = null;
	        	  
	        	  if (jsonReimbs[i].typeId==1) typeIdTd.innerText = 'Lodging';
	        	  else if (jsonReimbs[i].typeId==2) typeIdTd.innerText = 'Travel';
	        	  else if (jsonReimbs[i].typeId==3) typeIdTd.innerText = 'Food';
	        	  else if (jsonReimbs[i].typeId==4) typeIdTd.innerText = 'Other';
	        	  else statusIdTd.innerText = null;
	        	  
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

	        	  document.getElementById('ers-table-body').appendChild(newElement);
	        	  
	        }

			}
			else {
				console.log('failed to load json')
			}
	  }
	  xhttp.open('GET', `../reimbursement/emp`);
	  xhttp.send();
}