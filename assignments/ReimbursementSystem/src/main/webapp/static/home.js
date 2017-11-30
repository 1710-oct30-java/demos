function loadHome(){
	let xhttp = new XMLHttpRequest();
	let div = document.getElementById('info');
	xhttp.onload = (resp) => {
		if(xhttp.status === 200){
			let userObj = JSON.parse(xhttp.responseText);
			if(userObj.roleId.userRoleId === 1){
				window.location = './finance-home.html';
			}
			div.innerText = `
			Name: ${userObj.firstName} ${userObj.lastName} 
			Email: ${userObj.email} 
			Role: ${userObj.roleId.userRole}
			`
		}else{
			window.location = './login.html';
		}
	}
	
	xhttp.open('GET', '../users/home');
	xhttp.send();
}
