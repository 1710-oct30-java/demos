function login(){

	let username = document.getElementById('username').value;
	let password = document.getElementById('password').value;
	
	let user = {
			"username": username,
			"password": password
	}
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onload = (resp) => {
		if(xhttp.status === 200){
		//response contains the response body
		window.location = './home.html';
		}else {
			alert('invalid credentials');
		}
	}
	
	xhttp.open('POST', '../users/login');
	xhttp.send(JSON.stringify(user));
}