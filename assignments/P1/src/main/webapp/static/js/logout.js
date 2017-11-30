function logOut() {
    xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            window.location = './login';
        }
    }
    xhttp.open('POST', './logout');
    xhttp.send();
}