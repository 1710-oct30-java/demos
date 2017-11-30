function loadReimbursements(){

	let xhttp = new XMLHttpRequest();
	
	xhttp.onload = (resp) => {
		if(xhttp.status === 200){
		//response contains the response body
		window.location = './home.html';
		}
	}
	
	xhttp.open('POST', '../users/id');
	xhttp.send(JSON.stringify(user));
}