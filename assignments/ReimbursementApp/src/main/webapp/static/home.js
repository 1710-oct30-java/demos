function nextPage(button) {
    let xhttp = new XMLHttpRequest();
   // xhttp.open('POST', 'http://localhost:8080/ReimbursementApp/');
    switch (button.id) {
        case 'history':
        window.location = './history';
            break;
        case 'logout':
        window.location = '/';
            break;
        default:
            break;
    }

}