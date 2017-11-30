// Employee Login
function loginEmployee() {
	let username = document.getElementById('emp_username').value;
	let password = document.getElementById('emp_password').value;
	let user = {
			"username": username,
			"password": password
	}
	let xhttp = new XMLHttpRequest();
	xhttp.onload = (resp) => {
		if (xhttp.status ===200) {
			window.location = './pastTickets.html';

		} else {
			alert('invalid credentials')
		}
		// resp contains the response body
	}
	xhttp.open('POST', '../users/login');
	xhttp.send(JSON.stringify(user))
}
// Admin Login
function loginAdmin() {
	let username = document.getElementById('admin_username').value;
	let password = document.getElementById('admin_password').value;
	let user = {
			"username": username,
			"password": password
	}
	let xhttp = new XMLHttpRequest();
	xhttp.onload = (resp) => {
		if (xhttp.status ===200) {
			window.location = './managerHome.html';

		} else {
			alert('invalid credentials')
		}
		// resp contains the response body
	}
	xhttp.open('POST', '../users/login');
	xhttp.send(JSON.stringify(user))
}