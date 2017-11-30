function login() {
	
	showLoader();
	
	let username = document.getElementById('inputEmail').value;
	let password = document.getElementById('inputPassword').value;
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onload = (resp) => {
		//resp contains the response body
		if (xhttp.status === 200){
		window.location = "./reimbursement.html";
		} else {
			
			hideLoader();
			alert("invalid credentials");
		}
	}
	xhttp.onerror = () => {
		alert("invalid credentials");
	}
	xhttp.open('POST', '../home/login');
	
	let user = {
			"username":username,
			"password":password
	}
	xhttp.send(JSON.stringify(user));
}

let showLoader = () => {
	let x = document.getElementsByClassName("loader");
	x[0].style.display="block";
}
let hideLoader = () => {
	let x = document.getElementsByClassName("loader");
	x[0].style.display="none";
}
