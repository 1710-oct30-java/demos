console.log("script started");

function clickedHello() {
    console.log('Hello Clicked');
}

function removeHello() {
    document.getElementById("div1").remove();
    console.log('removed');
}


function login() {
    let username = document.getElementById('inputUsername').value;
    let password = document.getElementById('inputPassword').value;
    let user = {
        "username": username,
        "password": password
    }

    let xhttp = new XMLHttpRequest();

    // what to do if it succeeds 
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            // resp contains the response body
            window.location = './reimb';
        } else if (xhttp.status === 201) {
            window.location = './reimbM';
        }
        else {
            errAuthModal();
        }
    }


    xhttp.open('POST', './login');

    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(user));
}


function errAuthModal(){
    
    $("#errAuthModal").modal("show");
}

function registerPage()
{
    window.location = './register';
}