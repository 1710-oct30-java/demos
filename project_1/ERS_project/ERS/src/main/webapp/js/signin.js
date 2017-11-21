function disableSigninForm() {
	console.log("Sign in is under construction!");
	//alert("Sign in under construction!!!");
	
	var x = document.getElementById("user_icon");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
	
}

function addElement() {
    document.getElementById("addElement").innerHTML += `
    <div> Hello </div>
    `;
    console.log('div added!');
}