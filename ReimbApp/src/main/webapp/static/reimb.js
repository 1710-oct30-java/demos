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
			`<tr>
				<th scope="row">${myJson[i].reimbId}</th>
				<td>$${myJson[i].amount}</td>
				<td>${myJson[i].submitTimePretty}</td>
				<td>${myJson[i].resolveTime}</td>
				<td>${myJson[i].description}</td>
				<td>${myJson[i].receipt}</td>
				<td>${myJson[i].authorName}</td>
				<td>${myJson[i].resolverName}</td>
				<td>${myJson[i].statusName}</td>
				<td>${myJson[i].typeName}</td>
		 	</tr>`
	}
}

function handleStateChange() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			myJson = JSON.parse(xmlHttp.responseText);
			insert_row();
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
}



function clearForm() {
	document.getElementById('newReimb').reset();
}




