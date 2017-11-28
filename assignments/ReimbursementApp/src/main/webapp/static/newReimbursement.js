function newReimb() {
    let type = document.getElementById("reimbType");
    let text = type.options[type.selectedIndex].value;
    let currentTime = Date.now();
    let status = 0;
    let reimbType = null;
    console.log(text);
    switch (text) {
        case 'Lodging':
            reimbType = 1;
            break;
        case 'Travel':
            reimbType = 2;
            break;
        case 'Food':
            reimbType = 3;
            break;
        case 'Other':
            reimbType = 4;
            break;
        default:
            break;
    }
    let amount = document.getElementById('amount').value;
    let description = document.getElementById('description').value;

    let xhttp = new XMLHttpRequest();

    // xhttp.onload = (resp) => {
    //     if (xhttp.status === 200) {
    //         // resp contains the response body
    //         window.location = './home';
    //     } else {
    //         alert('Invalid Credentials')
    //     }
    //}
    let newReimbursement = {
        "typeId": reimbType,
        "amount": amount,
        "descip": description,
        "submitted": currentTime,
        "statusId": status

    }
    xhttp.open('POST', 'http://localhost:8080/ReimbursementApp/new');
    xhttp.send(JSON.stringify(newReimbursement));
}