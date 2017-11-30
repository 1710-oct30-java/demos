function login() {
    let username = document.getElementById('idusername').value;
    let password = document.getElementById('idpassword').value;
    
    let user = {
            "username":username,
            "password":password
    }
    let xhttp = new XMLHttpRequest();
    
    xhttp.onload = (resp) => {
        //resp contains the response body
        if (xhttp.status === 200){
        	let roleId = JSON.parse(xhttp.getResponseHeader("user")).role_id;
        	console.log(roleId);
        	if (roleId === 1){
        		window.location = "reimbursement.html";
        	}
        	else {
        		window.location = "managerHome.html";
        		}
        	
        } else {
            alert("invalid credentials");
        }
    }
    
    xhttp.open('POST', '../home/login');
    xhttp.send(JSON.stringify(user));
}