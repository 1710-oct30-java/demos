function login() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let user = {
            "username": username,
            "password": password
        }
    
    let xhttp = new XMLHttpRequest();
    
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.status === 200) {
            // resp contains the response body
        	
        	// post statement returns the role of the user logging in
        	// 1 employee : 2 manager
        	// Dashboards are different based on role id
        	
        	let temp = xhttp.responseText;
        	let roleId = JSON.parse(temp);

        	if (roleId === 1) {
            window.location = 'employee-landing.html';
        	} else if (roleId === 2) {
        		window.location = 'landing.html';
        	}
        	
        } else {
            alert('invalid credentials');
            alert(xhttp.status);
        }
    }
    
    
    xhttp.open('POST', '/ExpenseReimbursementSystem/user/login');
    
    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(user));
}