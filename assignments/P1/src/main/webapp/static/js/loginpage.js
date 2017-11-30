function signin() {
    console.log('clicked Sign In');
    let username = document.getElementById('inputUsername').value;
    let password = document.getElementById('inputPassword').value;
    console.log(username + ' | ' + password);
    if (username === '' || password === '') return;
    console.log('sending');
    user = {
        username: username,
        password: password
    };
    xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status === 210) {
            changeFlag();
            //alert(flag);
            window.location = './user';
        }
        else if (xhttp.status === 211) {
            window.location = './manager';
            changeFlag();
        }
        else if (xhttp.status === 212) {
            window.location = './admin';
            changeFlag();
        }
        else {
            alert('A User with those credentials does not exist');
        }
    }
    xhttp.open('POST', './login/try');
    xhttp.send(JSON.stringify(user));
}