function logout() {
	
	let xhttp = new XMLHttpRequest();
	
	xhttp.onload = (resp) => {
		//resp contains the response body
		if (xhttp.status === 200){
		window.location = "../static/login.html";
		} else {
			alert("failed to sign out");
		}
	}
	xhttp.onerror = () => {
		alert("failed to sign out");
	}
	xhttp.open('DELETE', '../reimbursement');
	xhttp.send();
	
}