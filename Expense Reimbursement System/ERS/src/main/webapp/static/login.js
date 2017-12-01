function login() {
    let un = document.getElementById('username').value;
    let pw = document.getElementById('password').value;
    let user = {
        "username": un,
        "password": pw
    }

    console.log(user);
    let xhttp = new XMLHttpRequest();

    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            // window.location = '../static/reimbs.html';
            window.location = './reimbs.html';
        } else {
            alert('invalid credentials')
        }
        // resp contains the response body
    }

    // xhttp.onreadystatechange = () => {
    //     // console.log(`state changed ${xhttp.readyState}`);

    //     if (xhttp.readyState === 4 && xhttp.status === 200) {
    //         // console.log(`response text: ${xhttp.responseText}`);
    //     } else if (xhttp.readyState === 4) {
    //         alert(`failed to log in. status is ${xhttp.status}`);
    //     }
    // }

    xhttp.open('POST', '/ERS/static/login');
    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(user));
}