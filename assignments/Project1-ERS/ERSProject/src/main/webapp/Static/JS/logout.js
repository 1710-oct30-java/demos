function logout() {
    let xhttp = new XMLHttpRequest();
    
    xhttp.onload = (resp) => {
        if(xhttp.status === 200){
            window.location = './login.html';
        }
        else {
            alert('failed to logout');
        }
    }
    xhttp.open('GET', '../users/logout');
    xhttp.send();
}