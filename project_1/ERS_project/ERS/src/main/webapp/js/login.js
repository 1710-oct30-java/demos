function checkLogin() {
	hideLoginButton();
	showLoader();
	
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let user = {
            "username": username,
            "password": password
        }
    
    let xhttp = new XMLHttpRequest();
 
    // what to do if it succeeds
    xhttp.onload = (resp) => {
        if(xhttp.getResponseHeader("success") === 'true') {
            // resp contains the response body
        	sessionStorage.firstName = xhttp.getResponseHeader("firstName");
        	sessionStorage.sessionValid = xhttp.getResponseHeader("sessionValid");
        	sessionStorage.role = xhttp.getResponseHeader("role");
        	window.location = '/ERS/home';
        } 
        
        else if(xhttp.getResponseHeader("success") === 'false'){
		  document.getElementById('info').innerHTML = 
		  	    `
		  			<div class="alert">
		  			  <span class="closebtn">&times;</span>  
		  			  <strong>Invalid credentials</strong>
		  			</div>
		  	    `;
		  showLoginButton();
		  hideLoader();
		  }
        
        else if(xhttp.getResponseHeader("success") === 'connection-issue'){
  		  document.getElementById('info').innerHTML = 
  		  	    `
  		  			<div class="alert-warning">
  		  			  <span class="closebtn">&times;</span>  
  		  			  <strong>Cannot connect to server!</strong>
  		  			</div>
  		  	    `;
  		  showLoginButton();
  		  hideLoader();
  		  }
    }
    
    xhttp.open('POST', '../pages/signin');
    
    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(user));
    // enableLogin();
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function showLoginButton() {
	document.getElementById('btn_signin').style.display = "block";
}

function hideLoginButton() {
	document.getElementById('btn_signin').style.display = "none";
}

function showLoader() {
	document.getElementById('loader-id').style.display = "block";
}

function hideLoader() {
	document.getElementById('loader-id').style.display = "none";
}