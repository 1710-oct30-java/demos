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
            window.location = './employee-dash.html';
        }
        else {
            alert('invalid credentials');
        }
    }
    xhttp.open('POST', '../users/login');
    
    xhttp.send(JSON.stringify(user));
}

function showRegister() {
    window.location = './register.html';
}

function register() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let firstname = document.getElementById('firstname').value;
    let lastname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let role = document.getElementById('role').value;
    
    let roleId;
    
    if(role === 'Employee'){
        roleId = 1;
    }
    else{
        roleId = 2;
    }
    
    let newUser = {
        "username": username,
        "password": password,
        "firstName": firstname,
        "lastName": lastname,
        "email": email,
        "role": roleId
    }
    
    let xhttp = new XMLHttpRequest();
    
    xhttp.onload = (resp) => {
        if(xhttp.status === 200){
            console.log("trying to show the window...")
            window.location = './employee-dash.html';
        }
        else{
            alert('Please try again')
        }
    }
    xhttp.open('POST', '../users/register');
    
    xhttp.send(JSON.stringify(newUser));
}