// Purpose: This is a rudamentary and admittedly lazy means of implementing the navbar as a
// single-line component in my web pages.

function navbarjs()
{
    let container = document.getElementById('navbar-container');

    container.innerHTML = `<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
          <div class="dropdown-menu" aria-labelledby="dropdown01">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
      </ul>
      <div class="form-inline my-2 my-lg-0" id="login-form">
        <input class="form-control mr-sm-2 is-valid" type="text" placeholder="Username" aria-label="Username" id="login-user" required>
        <input class="form-control mr-sm-2 is-valid" type="password" placeholder="Password" aria-label="Password" id="login-pass" required>
        <button class="btn btn-outline-success my-2 my-sm-0" onclick="startLogin()" id="login-submit">Login</button>
      </div>
    </div>
  </nav>`;
}