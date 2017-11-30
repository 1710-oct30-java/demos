function getReimbursements() {
	let xhttp = new XMLHttpRequest();
	xhttp.onload = (resp) => {
		if (xhttp.status ===200) {
			window.location = './welcome.html';

		} else {
			alert('unable to load data')
		}
		// resp contains the response body
	}
	xhttp.open('GET', '../reimbursements/');
	xhttp.send();
}
function createTable() {
	let array = [["A1","B1","C1"],
				["A2","B2","C2"],
				["A3","B3","C3"],
				["A4","B4","C4"],
				["A5","B5","C5"]];
	let table = document.getElementById("table");
	for(let i = 0; i < array.length; i++) {
		// create a new row
		let newRow = table.insertRow(table.length);
		for(let j = 0; j < array[i].length; j++) {
			// create a new cell
			let cell = newRow.insertCell(j);
			// add value to the cell
			cell.innerHTML = array[i][j];
		}
	}
}