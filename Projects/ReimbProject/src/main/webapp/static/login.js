console.log("script started");

function clickedHello()
{
    console.log('Hello Clicked');
}

function removeHello()
{
    document.getElementById("div1").remove();
    console.log('removed');
}

document.getElementById('dummy').innerHTML += 
`
<button id="dangerbutton" type="button" class="btn btn-danger">Danger</button>
`

// document.getElementById('error').innerText = 'Failed to login'; after failed validation

document.getElementById('dangerbutton').addEventListener('click', ()=> {
    document.getElementById('dangerbutton').remove();
})

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
        if(xhttp.status === 200) {
            // resp contains the response body
            window.location = './reimb';
        } else {
            document.getElementById('error').innerHTML = 
            `Invalid user/password`
        }
    }
    
    
    xhttp.open('POST', './login');
    
    // JSON.stringify converts a JavaScript object to JSON
    // JSON.parse converts a string to a JavaScript object
    xhttp.send(JSON.stringify(user));
}