function register() {
    let username = document.getElementById('usernameR').value;
    let password = document.getElementById('passwordR').value;
    let firstname = document.getElementById('firstnameR').value;
    let lastname = document.getElementById('lastnameR').value;
    let email = document.getElementById('emailR').value;
    let role = document.getElementById('roleR').value;
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
            alert('Added user to the system');
            window.location = './finance-manager-dash.html';
        }
        else{
            alert('Please try again');
        }
    }
    xhttp.open('POST', '../users/register');
    xhttp.send(JSON.stringify(newUser));
}