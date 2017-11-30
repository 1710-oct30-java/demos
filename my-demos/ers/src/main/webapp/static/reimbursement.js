function viewPast(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = () => {
        console.log(`state changed ${xhttp.readyState}`);
        if(xhttp.readyState === 4 && xhttp.status === 200) {
          console.log('we have the response ready');
          console.log(`response text: ${xhttp.responseText}`)
          let reimbursements = JSON.parse(xhttp.responseText);
          let html = "<table border='1|1'>";
          for (let i = 0; i < reimbursements.length; i++) {
              html+="<tr>";
              html+="<td>"+reimbursements[i].reimbID+"</td>";
              html+="<td>"+reimbursements[i].amount+"</td>";
              html+="<td>"+reimbursements[i].submitted+"</td>";
              html+="<td>"+reimbursements[i].resolved+"</td>";
              html+="<td>"+reimbursements[i].description+"</td>";
              html+="<td>"+reimbursements[i].receipt+"</td>";
              html+="<td>"+reimbursements[i].author+"</td>";
              html+="<td>"+reimbursements[i].resolver+"</td>";
              html+="<td>"+reimbursements[i].statusID+"</td>";
              html+="<td>"+reimbursements[i].typeID+"</td>";
              
              html+="</tr>";
      
          }
          html+="</table>";
          document.getElementById("pastReimbursements").innerHTML = html;
        }
    }
    xhttp.open('GET', '../reimbursements/');
    xhttp.send(); 
}

function viewByStatus(){
    let status = document.getElementById('reimbStatus').value;
    
    let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = () => {
        console.log(`state changed ${xhttp.readyState}`);
        if(xhttp.readyState === 4 && xhttp.status === 200) {
          console.log('we have the response ready');
          console.log(`response text: ${xhttp.responseText}`)
          let reimbursements = JSON.parse(xhttp.responseText);
          let html = "<table border='1|1'>";
          
          for (let i = 0; i < reimbursements.length; i++) {
              if(reimbursements[i].statusID == status){

              
              html+="<tr>";
              html+="<td>"+reimbursements[i].reimbID+"</td>";
              html+="<td>"+reimbursements[i].amount+"</td>";
              html+="<td>"+reimbursements[i].submitted+"</td>";
              html+="<td>"+reimbursements[i].resolved+"</td>";
              html+="<td>"+reimbursements[i].description+"</td>";
              html+="<td>"+reimbursements[i].receipt+"</td>";
              html+="<td>"+reimbursements[i].author+"</td>";
              html+="<td>"+reimbursements[i].resolver+"</td>";
              html+="<td>"+reimbursements[i].statusID+"</td>";
              html+="<td>"+reimbursements[i].typeID+"</td>";
              
              html+="</tr>";
              }
          }
          html+="</table>";
          document.getElementById("allReimbursements").innerHTML = html;
        }
        else if(xhttp.status === 401){
            alert('You are not authorized to view this data')
        }
    }
    xhttp.open('GET', '../reimbursements/all');
    xhttp.send();
}

function viewAll(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = () => {
        console.log(`state changed ${xhttp.readyState}`);
        if(xhttp.readyState === 4 && xhttp.status === 200) {
          console.log('we have the response ready');
          console.log(`response text: ${xhttp.responseText}`)
          let reimbursements = JSON.parse(xhttp.responseText);
          let html = "<table border='1|1'>";
          for (let i = 0; i < reimbursements.length; i++) {
              html+="<tr>";
              html+="<td>"+reimbursements[i].reimbID+"</td>";
              html+="<td>"+reimbursements[i].amount+"</td>";
              html+="<td>"+reimbursements[i].submitted+"</td>";
              html+="<td>"+reimbursements[i].resolved+"</td>";
              html+="<td>"+reimbursements[i].description+"</td>";
              html+="<td>"+reimbursements[i].receipt+"</td>";
              html+="<td>"+reimbursements[i].author+"</td>";
              html+="<td>"+reimbursements[i].resolver+"</td>";
              html+="<td>"+reimbursements[i].statusID+"</td>";
              html+="<td>"+reimbursements[i].typeID+"</td>";
              
              html+="</tr>";
      
          }
          html+="</table>";
          document.getElementById("allReimbursements").innerHTML = html;
        }
        else if(xhttp.status === 401){
            alert('You are not authorized to view this data')
        }
    }
    xhttp.open('GET', '../reimbursements/all');
    xhttp.send();
}

function approve(){
	let reimbID = document.getElementById('reimbID').value;
	let user = {
			"status": reimbID
	}
	
	let xhttp = new XMLHttpRequest();
	xhttp.onload = (resp) => {
		if(xhttp.status === 200){
			alert('Reimbursement Approved')
		}
		else{
			alert('You are not authorized to perform this action')
		}
	}
	xhttp.open('POST', '../reimbursements/approve');
    xhttp.send(JSON.stringify(user));
	
}

function deny(){
	let reimbID = document.getElementById('reimbDeny').value;
	let user = {
			"status": reimbID
    }
    console.log(user.status);
	
	let xhttp = new XMLHttpRequest();
	xhttp.onload = (resp) => {
		if(xhttp.status === 200){
			alert('Reimbursement Denied')
		}
		else{
			alert('You are not authorized to perform this action')
		}
	}
	xhttp.open('POST', '../reimbursements/deny');
    xhttp.send(JSON.stringify(user));

}

function add(){
    let amount = document.getElementById('amount').value;
    let description = document.getElementById('description').value;
    let type = document.getElementById('type').value;
    
    let user = {
            "amount": amount,
            "description": description,
            "type": type
    }
    console.log(user.amount);
	
	let xhttp = new XMLHttpRequest();
	xhttp.onload = (resp) => {
		if(xhttp.status === 200){
			alert('Reimbursement Added')
		}
		else{
			alert('invalid crendentials')
		}
	}
	xhttp.open('POST', '../reimbursements/add');
    xhttp.send(JSON.stringify(user));
}