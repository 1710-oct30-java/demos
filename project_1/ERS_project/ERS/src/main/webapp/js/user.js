function displayInfo() {
	let xhttp = new XMLHttpRequest();
	if(sessionStorage.role === '1') {
		managerInfo();
	}
	
	else if(sessionStorage.role === '2') {
		userInfo();
	}
}
displayInfo();

function userInfo() {
	document.getElementById('user').innerHTML = 
	`
		<div class="row">
		  <div class="col">
		  	<div class="col"><h5>My Reimbursements</h5></div>
		  	<a href="/ERS/pages/reimbursements"><img class="tilt home-img" src="images/icons/file.png"></a>
		  	<br><br>
		  	<div>
				Here you can view all your reimbursements. You can search, see your pending, and view your past submitted reimbursements.
			</div>
		  </div>
		  
		  <div class="col">
		  	<div class="col"><h5>Add Reimbursement</h5></div>
		  	<a href="/ERS/pages/reimbursements/add"><img class="tilt home-img" src="images/icons/add-icon.png"></a>
		  	<br><br>
		  	<div>
				Here you can submit a new reimbursement. Once submitted, it will be pending until a Finance Manager reviews it.
			</div>
		  </div>
		</div>
	`;
}

function managerInfo() {
	document.getElementById('user').innerHTML = 
	`
		<div class="row">
		  <div class="col">
		  	<div class="col"><h5>My Reimbursements</h5></div>
		  	<a href="/ERS/pages/reimbursements"><img class="tilt home-img" style="width: 200px;" src="images/icons/file.png"></a>
		  	<br><br>
		  	<div>
				Here you can view all your reimbursements. You can search, see your pending, and view your past submitted reimbursements.
			</div>
		  </div>
		  
		  <br><br>
		  
		  <div class="col">
		  <div class="col"><h5>Add Reimbursement</h5></div>
		  	<a href="/ERS/pages/reimbursements/add"><img class="tilt home-img" style="width: 200px;" src="images/icons/add-icon.png"></a>
		  	<br><br>
		  	<div>
				Here you can submit a new reimbursement. Once submitted, it will be pending until a Finance Manager reviews it.
			</div>
		  </div>
		  
		  <br><br>
		  
		  <div class="col">
		  	<div class="col"><h5>Approve Reimbursements</h5></div>
		  	<a href="/ERS/pages/reimbursements/approve"><img class="tilt home-img" style="width: 200px;" src="images/icons/check-folded.png"></a>
		  	<br><br>
		  	<div>
				Here you can approve or deny reimbursements. All pending reimbursements will be shown. 
			</div>
		  </div>
		  
		  <br><br>
		  
		  <div class="col">
		  	<div class="col"><h5>Users and Reimbursements</h5></div>
		  	<a href="/ERS/pages/reimbursements/view-all"><img class="tilt home-img" style="width: 200px;" src="images/icons/files.png"></a>
		  	<br><br>
		  	<div>
				Here you can view all users and reimbursements. You can search for users information and search for reimbursements.
			</div>
		  </div>
		</div>
	`;
}