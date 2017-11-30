let xmlHttp;
let myJson;
let currRow;

window.onload = startRequest('./reimbM', null);



function createXMLHttpRequest() {
    if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
}

function insert_row() {
    document.getElementById('rowEntry').innerHTML = '';
    for (let i = 0; i < myJson.length; i++) {
        document.getElementById('rowEntry').innerHTML +=
            `<tr onchange="updateStatus(this)">
                <form onsubmit="event.preventDefault()">
                    <th id="udpateId" scope="row">${myJson[i].reimbId}</th>
                    <td align="center">$${myJson[i].amount}</td>
                    <td align="center">${myJson[i].submitTimePretty}</td>
                    <td align="center">${myJson[i].resolvedTimePretty}</td>
                    <td align="center">${myJson[i].description}</td>
                    <td align="center">${myJson[i].receipt}</td>
                    <td align="center">${myJson[i].authorName}</td>
                    <td align="center">${myJson[i].resolverName}</td>
                    <td id="updateStatusName">${myJson[i].statusName}</td>
                    <td align="center">${myJson[i].typeName}</td>
                    <td align="center">
                        <select id="actionStatus${myJson[i].reimbId}">
                            <option value="0">Action</option>
                            <option value="1">Pending</option>
                            <option value="2">Denied</option>
                            <option value="3">Approved</option>
                        </select>
                    </td>
                </form>
		 	</tr>`
    }
}

function insert_row_filter(num) {
    document.getElementById('rowEntry').innerHTML = '';
    for (let i = 0; i < myJson.length; i++) {
        if (myJson[i].statusId === parseInt(num)) {
            document.getElementById('rowEntry').innerHTML +=
                `<tr onchange="updateStatus(this)">
                <form onsubmit="event.preventDefault()">
                    <th id="udpateId" scope="row">${myJson[i].reimbId}</th>
                    <td align="center">$${myJson[i].amount}</td>
                    <td align="center">${myJson[i].submitTimePretty}</td>
                    <td align="center">${myJson[i].resolvedTimePretty}</td>
                    <td align="center">${myJson[i].description}</td>
                    <td align="center">${myJson[i].receipt}</td>
                    <td align="center">${myJson[i].authorName}</td>
                    <td align="center">${myJson[i].resolverName}</td>
                    <td id="updateStatusName">${myJson[i].statusName}</td>
                    <td align="center">${myJson[i].typeName}</td>
                    <td align="center">
                        <select id="actionStatus${myJson[i].reimbId}">
                            <option value="0">Action</option>
                            <option value="1">Pending</option>
                            <option value="2">Denied</option>
                            <option value="3">Approved</option>
                        </select>
                    </td>
                </form>
		 	</tr>`
        }
        else{
            insert_row
        }
    }
}

function handleStateChange() {
    if (xmlHttp.readyState == 4) {
        if (xmlHttp.status == 200) {
            myJson = JSON.parse(xmlHttp.responseText);
            insert_row();
        }
        else if (xmlHttp.status == 401) {
            errChangeOwn();
        }
        else if (xmlHttp.status == 500) {
            document.getElementById('rowEntry').innerHTML =
                `<tr>
					<th scope="row"></th>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>`
        }
    }
}

function startRequest(url, file) {
    createXMLHttpRequest();
    xmlHttp.onreadystatechange = handleStateChange;
    xmlHttp.open("post", url);
    xmlHttp.send(file);
}

function createReimb(event) {
    event.disabled = true;
    event.childNodes[0].nodeValue = 'Submitted';
    let reimbRec = {
        "amount": document.getElementById('inputAmount').value,
        "description": document.getElementById('inputDescription').value,
        "receipt": document.getElementById('inputReceipt').value,
        "type": parseInt(document.getElementById('typeSelect').value)
    }
    startRequest('./reimbM', JSON.stringify(reimbRec));
}

function updateStatus(temp) {

    currRow = `actionStatus${parseInt(temp.cells[0].innerText)}`;
    if (document.getElementById(currRow).value > 0) {
        let reimbUpd = {
            "reimbId": parseInt(temp.cells[0].innerText),
            "authorName": temp.cells[6].innerText,
            "statusId": document.getElementById(currRow).value
        }
        console.log(reimbUpd);
        startRequest('./reimbM', JSON.stringify(reimbUpd))
    };
}

function getAll() {
    startRequest('./reimbM', 'all');
}

// function getPending() {
//     startRequest('./reimbM', 'pending');
// }

// function getDenied() {
//     startRequest('./reimbM', 'denied');
// }
// function getApproved() {
//     startRequest('./reimbM', 'approved');
// }
function getMine() {
    startRequest('./reimbM', 'mine');
}


function clearForm() {
    document.getElementById('newReimb').reset();
}



function errChangeOwn() {
    document.getElementById(currRow).value = 0;
    $('#errChangeModal').modal('show');
    // let el = document.getElementById("errChangeOwn");
    // el.style.opacity = 1;
    // let tick = function () {
    //     el.style.opacity = +el.style.opacity - 0.0015;
    //     if (+el.style.opacity > 0) {
    //         (window.requestAnimationFrame && requestAnimationFrame(tick)) || setTimeout(tick, 500)
    //     }
    // };
    // tick();
}

function logOut()
{
    window.location = './login';
}
// setTimeout(
//     function() {
//       document.getElementById('div1').style.display='none';
//       document.getElementById('div2').style.display='none';
//     }, 2000);