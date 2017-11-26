// Purpose: Handles login requests to the server.

function loginjs()
{
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = () => {

        if(xhttp.readyState === 4)
        {
            if(xhttp.status === 200)
            {
                userLoggedIn(xhttp);
            }
            else
            {
                console.log('Data request failed.');
            }
        }
    }

    xhttp.open('GET', './login');
    xhttp.send();
}

function startLogin()
{
    let success = true;
    let form = document.getElementById('login-form');
    let userBox = document.getElementById('login-user');
    let passBox = document.getElementById('login-pass');
    let submitButton = document.getElementById('login-submit');

    success = success && bootStrapIsEmpty(userBox);
    success = success && bootStrapIsEmpty(passBox);

    if(success)
    {
        let xhttp = new XMLHttpRequest();
        xhttp.open('POST', './login');
        xhttp.onload = (resp) => {

            userLoggedIn(xhttp);
        }

        let login = { "username":userBox.value, "password":passBox.value };
        xhttp.send(JSON.stringify(login));

        userBox.setAttribute('disabled', 'disabled');
        passBox.setAttribute('disabled', 'disabled');
        submitButton.setAttribute('disabled', 'disabled');
    }
}

function bootStrapIsEmpty(object)
{
    if(!object.value)
    {
        object.validity.valid = false;
        return false;
    }
    else
    {
        object.validity.valid = true;
        return true;
    }
}

function userLoggedIn(resp)
{
    let user = JSON.parse(resp.responseText);

    if(user)
    {
        console.log('user logged in');
        let form = document.getElementById('login-form');
        let userBox = document.getElementById('login-user');
        let passBox = document.getElementById('login-pass');
        let submitButton = document.getElementById('login-submit');

        userBox.remove();
        passBox.remove();
        submitButton.remove();

        let text = document.createElement('span');
        text.innerText = `Welcome, ${user.firstName}`;
        text.classList.add('whiteText');

        form.appendChild(text);

        fetchRequests();
    }
    else
    {
        let userBox = document.getElementById('login-user');
        let passBox = document.getElementById('login-pass');
        let submitButton = document.getElementById('login-submit');

        userBox.removeAttribute('disabled');
        passBox.removeAttribute('disabled');
        submitButton.removeAttribute('disabled');

        console.log('no user logged in');
    }
}