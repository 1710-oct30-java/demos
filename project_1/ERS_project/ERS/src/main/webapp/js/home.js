function getFirstName() {
    let firstName = sessionStorage.firstName;
    
    if(firstName === undefined || firstName === '') {
    	document.getElementById('welcome').innerHTML = 
    		`
    			<h3 style="font-family: Verdana;">Edel's Expense Reimbursement System</h3>
    			<br><br>
    			
    			<div class="container-fluid">
	    			<div class="row">
						<span class="col">
							<img class="tilt home-img" src="images/icons/analytics.png">
						</span>
						  
						<span class="col">
							<img class="tilt home-img" src="images/icons/graph-magnifier.png">
						</span>
					</div>
					<br><br><br>
					<div class="row">
						<span class="col">
							<h5>Employees can log in and submit reimbursement requests. Requests can be for Lodging, Travel, Food, or Other.</h5>
						</span>
						
						<span class="col">
							<h5>Finance Managers can log in to approve or deny reimbursement requests. They can also submit their own requests, but cannot approve their own requests.</h5>
						</span>
					</div>
				</div>
    		`;
    }
    
    
    else {
    	document.getElementById('welcome').innerHTML = `Welcome, ${firstName}!`;
    }
}