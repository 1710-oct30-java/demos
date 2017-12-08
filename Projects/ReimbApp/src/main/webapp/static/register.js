console.log("script started");


function login() {
    let username = document.getElementById('inputUsername').value;
    let password = document.getElementById('inputPassword').value;
    let user = {
        "username": username,
        "password": password,
        "fName" : document.getElementById('inputFirst').value,
        "lName" : document.getElementById('inputLast').value,
        "email" : document.getElementById('inputEmail').value,
        "roleId" : parseInt(document.getElementById('roleSelect').value)
    }

    let xhttp = new XMLHttpRequest();

    // what to do if it succeeds 
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            // resp contains the response body
            $("#successRegModal").modal("show");
            setTimeout(function(){window.location = './login';}, 4000);
        }
        else {
            errRegModal();
        }
    }


    xhttp.open('POST', './register');

    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(user));
}

function errRegModal() {
    $("#errRegModal").modal("show");
}

function loginPage()
{
    window.location = './login';
}


