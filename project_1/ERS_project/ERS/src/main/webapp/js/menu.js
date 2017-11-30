document.getElementById('menuScript').innerHTML = 
`
	<!-- Menu -->
<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a href="/ERS/"><img src="/ERS/images/icons/money-bag-icon.png" class="menu-icon"></a>
    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="/ERS/">Home <span class="sr-only">(current)</span></a>
        </li>
        
        <span id="userMenu-1"></span>
        <span id="userMenu-2"></span>
        <span id="userMenu-3"></span>
        <span id="userMenu-4"></span>
        
        <!-- 
        <li class="nav-item">
          <a class="nav-link" href="#">Settings</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Help</a>
        </li>
        -->
      </ul>
      
      <span id="login"></span>

      <!--
      <form class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    -->
    </div>
  </nav>
</header>
<br>
`;



function displayLogin() {
	let login = document.getElementById('login').innerHTML = 
	`
		<a href="/ERS/pages/signin" class="link_signin" style="color: white;">Sign In</a>
	`;
}

function displayLogout() {
	let login = document.getElementById('login').innerHTML = 
	`
		<a href="/ERS/pages/signout" class="link_signin" style="color: white;">Sign Out</a>
	`;
}

function displayUserMenu() {
	document.getElementById('userMenu-1').innerHTML = 
	`
		<li class="nav-item">
          <a class="nav-link" href="/ERS/pages/reimbursements">My Reimbursements</a>
        </li>
	`;
	
	document.getElementById('userMenu-2').innerHTML =
	`
		<li class="nav-item">
			<a class="nav-link" href="/ERS/pages/reimbursements/add">Add Reimbursement</a>
		</li>
  `;
}

function displayManagerMenu() {
	displayUserMenu();
	document.getElementById('userMenu-3').innerHTML = 
	`
        <li class="nav-item">
          <a class="nav-link" href="/ERS/pages/reimbursements/approve">Approve Reimbursements</a>
        </li>
	`;
	
	document.getElementById('userMenu-4').innerHTML = 
		`
	        <li class="nav-item">
	          <a class="nav-link" href="/ERS/pages/reimbursements/view-all">Users and Reimbursements</a>
	        </li>
		`;
}

if(sessionStorage.sessionValid === 'true') {
	displayLogout();
	if(sessionStorage.role === '1') {
		displayManagerMenu();
	}
	else {
		displayUserMenu();
	}
}
else {
	displayLogin();
}
