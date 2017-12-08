let xmlHttp;
let myJson;

window.onload = startRequest('./reimb', null);



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
                </form>
		 	</tr>`
    }
}

function insert_row_filter(num) {
    document.getElementById('rowEntry').innerHTML = '';
    if (parseInt(num) === 0) {
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
                        </form>
		 	        </tr>`

        }
    }
    else {
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
                        </form>
		 	        </tr>`
            }
            else {
                insert_row
            }
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
    startRequest('./reimb', JSON.stringify(reimbRec));
    setTimeout(function(){
        $("#exampleModal").modal("hide");
            event.disabled = false;
            clearForm();}
        , 4000);
        
}

function updateStatus(temp) {

    let option = `actionStatus${parseInt(temp.cells[0].innerText)}`;
    if (document.getElementById(option).value > 0) {
        let reimbUpd = {
            "reimbId": parseInt(temp.cells[0].innerText),
            "authorName": temp.cells[6].innerText,
            "statusId": document.getElementById(option).value
        }
        startRequest('./reimb', JSON.stringify(reimbUpd))
    };
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
    startRequest('./reimb', 'mine');
}


function clearForm() {
    document.getElementById('newReimb').reset();
}



function errChangeOwn() {
    alert('cannot change your own request');
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

function logOut() {
    window.location = './login';
}

// setTimeout(
//     function() {
//       document.getElementById('div1').style.display='none';
//       document.getElementById('div2').style.display='none';
//     }, 2000);