function addReimb() {
    let amount = document.getElementById('amount').value;
    let description = document.getElementById('description').value;
    let type = document.getElementById('type').value;
    // let now = new Date();
    // now = now.getUTCFullYear() + '-' +
    //     ('00' + (now.getUTCMonth() + 1)).slice(-2) + '-' +
    //     ('00' + now.getUTCDate()).slice(-2) + ' ' +
    //     ('00' + now.getUTCHours()).slice(-2) + ':' +
    //     ('00' + now.getUTCMinutes()).slice(-2) + ':' +
    //     ('00' + now.getUTCSeconds()).slice(-2);

    let r = {
        "id": null,
        "amount": amount,
        "submitted": null,
        "resolved": null,
        "description": description,
        "receipt": null,
        "author": 1,
        "resolver": null,
        "statusId": 1,
        "typeId": type
    }

    let xhttp = new XMLHttpRequest();

    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            console.log("Reimbursement Added");
        }
    }

    xhttp.open('POST', '../reimbs/submit');
    xhttp.send(JSON.stringify(r));
}