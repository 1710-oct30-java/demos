function login() {
    let un = document.getElementById('username').value;
    let pw = document.getElementById('password').value;
    let user = {
        "username": un,
        "password": pw
    }

    console.log(user);
    let xhttp = new XMLHttpRequest();

    // what to do if it succeeds 
    xhttp.onload = (resp) => {
        console.log(resp);

        if (xhttp.status === 200) {
            // resp contains the response body
            console.log('successful');
            window.location = './home.html';
        } else {
            alert('invalid credentials')
        }
    }

    xhttp.open('POST', '../login');
    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(user));
}