function login() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    
    let user = {
        "username": username,
        "password": password
    }
    let xhttp = new XMLHttpRequest();
    
    xhttp.onload = (resp) => {
            
        if(xhttp.status === 200){
            let role = JSON.parse(xhttp.getResponseHeader("user")).role;
            if(role === 1){
                window.location = './employee-dash.html'; 
            }
            else{
                window.location = './finance-manager-dash.html';
            }
        }
        else {
            alert('invalid credentials');
        }
    }
    xhttp.open('POST', '../users/login');
    
    xhttp.send(JSON.stringify(user));
}
