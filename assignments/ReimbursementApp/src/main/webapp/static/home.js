
function nextPage(button) {
    let xhttp = new XMLHttpRequest();
    switch (button.id) {
        case 'history':
            xhttp.open('GET', 'http://localhost:8080/ReimbursementApp/home');
            xhttp.send();
            window.location = './history';
            break;
        case 'manageReimbursements':
            xhttp.open('GET', 'http://localhost:8080/ReimbursementApp/home');
            xhttp.send();
            window.location = './manageReimbursements';
            break;
        case 'logout':
            window.location = './';
            break;
        default:
            break;
    }

}