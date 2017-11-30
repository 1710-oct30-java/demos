let xhttp = new XMLHttpRequest();

xhttp.onload = (resp) => {
    if (xhttp.status === 200) {
        let jsonResp = xhttp.responseText;
        let jsonObj = JSON.parse(jsonResp);
        let table = document.querySelector('table');
        for (let p in jsonObj) {
            let newElement = document.createElement('tr');
            newElement.id = jsonObj[p].statusId;
            let checkbox = document.createElement('input');
            checkbox.type = 'checkbox';
            checkbox.name = "checker";
            checkbox.className = "myCheck";            
            checkbox.id = jsonObj[p].reimbId;
            let firstElement = document.createElement('td');
            firstElement.appendChild(checkbox);
            newElement.appendChild(firstElement);
            for (let k in jsonObj[p]) {
                let rowElement = document.createElement('td');
                rowElement.innerText = jsonObj[p][k];
                newElement.appendChild(rowElement);
            }
            document.getElementById('fillReimb').appendChild(newElement);
        }

        var checked = document.getElementsByName("checker");
        for (let i = 0; i < checked.length; i++) {
            checked[i].addEventListener('change', function () {
                selectCheck(checked[i]);
            });
        }

    }
}
xhttp.open('POST', 'http://localhost:8080/ReimbursementApp/manageReimbursements')
xhttp.send();
let manage = [];
function selectCheck(selected) {
    if (selected.checked)
        manage.push(selected.id)
}
function approveOrDeny(button) {
    if (button.id === 'approve') {
        xhttp.open('POST', 'http://localhost:8080/ReimbursementApp/approve');
        xhttp.send(JSON.stringify(manage));
        window.location = './approve'
    }

    else if (button.id === 'deny') {
        xhttp.open('POST', 'http://localhost:8080/ReimbursementApp/deny');
        xhttp.send(JSON.stringify(manage));
        window.location = './deny'
    }

}
function filter() {
    // Declare variables 

    let type = document.getElementById("reimbType");
    let text = type.options[type.selectedIndex].value;
    table = document.getElementById("fillReimb")
    tr = table.getElementsByTagName('tr');
    let approve = document.getElementById("approve")
    let deny = document.getElementById("deny")
    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        switch (text) {
            case 'Pending':
                if (tr[i].id == 0) {
                    tr[i].style.display = "";
                }
                else if (tr[i].id == 1) {
                    tr[i].style.display = "none";
                }
                else if (tr[i].id == 2) {
                    tr[i].style.display = "none";
                }
                show(approve);
                show(deny);
                break;
            case 'Approved':
                if (tr[i].id == 0) {
                    tr[i].style.display = "none";
                }
                else if (tr[i].id == 1) {
                    tr[i].style.display = "";
                    hide(approve);
                    show(deny);
                }
                else if (tr[i].id == 2) {
                    tr[i].style.display = "none";
                }
                break;
            case 'Denied':
                if (tr[i].id == 0) {
                    tr[i].style.display = "none";
                }
                else if (tr[i].id == 1) {
                    tr[i].style.display = "none";

                }
                else if (tr[i].id == 2) {
                    tr[i].style.display = "";
                    hide(deny);
                    show(approve);
                }
                break;
            default:
                tr[i].style.display = "";
                show(approve);
                show(deny);
                break;
        }
    }
}

function show(button) {
    button.style.visibility = 'visible';


}
function hide(button) {
    button.style.visibility = 'hidden';

}
