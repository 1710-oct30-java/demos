let xmlHttp;
let myJson;
window.onload = startRequest();


function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
}

function insert_row() {
	document.getElementById('rowEntry').innerHTML =
		`<tr>
	 <th scope="row">${myJson[0].reimbId}</th>
	 <td>${myJson[0].amount}</td>
     <td>${myJson[0].submitTime}</td>
     <td>${myJson[0].resolveTime}</td>
	 <td>${myJson[0].description}</td>
	 <td>${myJson[0].receipt}</td>
	 <td>${myJson[0].author}</td>
	 <td>${myJson[0].resolver}</td>
	 <td>${myJson[0].statusId}</td>
	 <td>${myJson[0].type}</td>
 </tr>`
}

function handleStateChange() {
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			myJson = JSON.parse(xmlHttp.responseText);
			insert_row();
		}
	}
}

function startRequest() {
	createXMLHttpRequest();
	xmlHttp.onreadystatechange = handleStateChange;
	xmlHttp.open("post", "./reimb", true);
	xmlHttp.setRequestHeader('Content-Type',
		'application/x-www-form-urlencoded'); // add here 
	xmlHttp.send(null);
}


