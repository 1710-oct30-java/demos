function login() {

    console.log('login function called');

    let un = document.getElementById('username').value;
    let pw = document.getElementById('password').value;
    let user = {
        "username": un,
        "password": pw
    }

    let xhttp = new XMLHttpRequest();

    // what to do if it succeeds 
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            // resp contains the response body
            console.log('successful');
            window.location = '/home.html';
        } else {
            alert('invalid credentials')
        }
    }

    xhttp.onreadystatechange = () => {
        console.log(`state changed ${xhttp.readyState}`);
        console.log(xhttp.status);
        if (xhttp.readyState === 4 && xhttp.status === 200) {
            console.log('we have the response ready');
            console.log(`response text: ${xhttp.responseText}`);

            let pokemon = JSON.parse(xhttp.responseText);
            // document.getElementById('pokemon').innerHTML = '<h1>' + pokemon.name + '</h1>';

        }
        else if (xhttp.readyState === 4)
            alert('Failed to load the requested pokemon');
    }

    xhttp.open('POST', '/user');

    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(user));

    // xhttp.open('GET', '/user');
    // xhttp.send();
}