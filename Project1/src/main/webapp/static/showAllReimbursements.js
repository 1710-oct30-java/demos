let showAllReimbursements = () => {
	let xmlhttp, x;
	let txt="";
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    	if (this.readyState == 4 && this.status == 200) {
            let myObj = JSON.parse(this.responseText);
            
            for (x in myObj) {
            	let status = "";
            	let statusStr ="";
            	let type = "";
            	if (myObj[x].reimb_status_id === 1) {
            		status = "success";
            		statusStr = "Approved";
            	}
            	else if (myObj[x].reimb_status_id === 2) {
            		status = "danger";
            		statusStr = "Denied";
            	}
            	else {
            		status = "active";
            		statusStr = "Pending";
            	}
            	if (myObj[x].reimb_type_id === 1) {
            		type = "Food";
            	}
            	else if (myObj[x].reimb_type_id === 2) {
            		type = "General";
            	}
            	else if (myObj[x].reimb_type_id === 3) {
            		type = "Travel";
            	}
            	else {
            		type = "Lodging";
            	}
            	if (myObj[x].reimb_resolver === 0) {
            		myObj[x].reimb_resolver = "N/A";
            	}
            	if (myObj[x].reimb_resolved === null) {
            		myObj[x].reimb_resolved = "N/A";
            	}
            	if (myObj[x].reimb_description === null) {
            		myObj[x].reimb_description = "Not Provided";
            	}
            	txt += "<tr class= " + status +">";
                txt += "<td>" + myObj[x].reimb_id + "</td>";
                txt += "<td>" + "$" + myObj[x].reimb_amount + "</td>";
                txt += "<td>" + myObj[x].reimb_submitted + "</td>";
                txt += "<td>" + myObj[x].reimb_resolved + "</td>";
                txt += "<td>" + myObj[x].reimb_description + "</td>";
                txt += "<td>" + myObj[x].reimb_author + "</td>";
                txt += "<td>" + myObj[x].reimb_resolver + "</td>";
                txt += "<td>" + statusStr + "</td>";
                txt += "<td>" + type + "</td>";
                txt += "</tr>";
            txt += "</tbody>"
            txt += "</table>"   
            document.getElementById("reimb").innerHTML = txt;
        }
            }
    };													
	}
	xmlhttp.open("GET", '../reimbursement', true);
	xmlhttp.send();
	};