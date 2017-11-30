let forms = document.getElementsByTagName('input');
document.getElementById('button').disabled = true;
function checkIfFilled() {
    let flag = true;
    for (let i = 0; i < forms.length; i++) {
        console.log('value:' + forms[i].value + ':end')
        if (forms[i].value == '') {
            flag = false;
            break;
        }
    }
    if (flag) {
        document.getElementById('button').disabled = false;
    }
    else
    {
        document.getElementById('button').disabled = true;
    }
}

function buttonClick()
{
    let firstname = document.getElementById('firstname').value;
    let lastname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let password2 = document.getElementById('password2').value;
    console.log(typeof(email));
    console.log(email.includes('@'));
    if(!email.includes('@'))
    {
        let emailWarning = document.getElementById('emailwarn');
        emailWarning.style.opacity = 1;
        return;
    }
    document.getElementById('emailwarn').style.opacity = 0;
    if(password === password2)
    {
        let user = {
            'firstName':firstname,
            'lastName':lastname,
            'email':email,
            'username':username,
            'password':password,
        }
        let xhttp = new XMLHttpRequest();
        xhttp.onload = (resp) => {
            console.log(resp);
            if(xhttp.status === 200)
            {
                alert('Your account has been successfully created, please wait for the admin to approve your accunt');
                window.location = './login';
            }
            else if (xhttp.status === 401)
            {
                alert('A user with that username already exists');
            }
            else
            {
                alert('technical difficulties')
            }
        }
        xhttp.open('POST', './new');
        
        xhttp.send(JSON.stringify(user));
        console.log('sending');
    }
    else{
        let warnings = document.getElementsByClassName('passwordMatch');
        for(let label of warnings)
        {
            label.style.opacity = 1;
        }
    }
}