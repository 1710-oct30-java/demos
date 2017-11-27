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
	document.getElementById('rowEntry').innerHTML = '';
	for (let i = 0; i < myJson.length; i++) {
	document.getElementById('rowEntry').innerHTML +=
		`<tr>
	 <th scope="row">${myJson[i].reimbId}</th>
	 <td>$${myJson[i].amount}</td>
     <td>${myJson[i].submitTime}</td>
     <td>${myJson[i].resolveTime}</td>
	 <td>${myJson[i].description}</td>
	 <td>${myJson[i].receipt}</td>
	 <td>${myJson[i].authorName}</td>
	 <td>${myJson[i].resolverName}</td>
	 <td>${myJson[i].statusName}</td>
	 <td>${myJson[i].typeName}</td>
 </tr>`}
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


