<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Cargonaut</title>
  <link rel="stylesheet" href="style.css">
</head>

<body>
<header>
  <nav class="navbar navbar-light ">
    <a class="navbar-brand" href="#">
      <img src="/assets/Cargo-Logo.PNG" width="200" height="90" class="d-inline-block align-top" alt=""
           loading="lazy">
    </a>
  </nav>
</header>

<div id="body">
  <div class="form-box">
    <div class="button-box">
      <div id="btn"></div>
      <button type="button" class="toggle-btn" onclick="toggleLogin()">Log in</button>
      <button type="button" class="toggle-btn" onclick="toggleRegister()">Register</button>
    </div>
    <form id="login" class="input-group">
      <input type="email" class="input-field" placeholder="Email" required>
      <input type="password" class="input-field" placeholder="Password" required>
      <select id="role" class="input-field" name="role">
        <option value="Client">Client</option>
        <option value="Driver">Driver</option>
      </select>
      <button type="submit" class="submit-btn">Login</button>
    </form>
    <form id="register" class="input-group">
      <input id="email" type="email" class="input-field" placeholder="Email" required>
      <input type="password" class="input-field" placeholder="Password" required>
      <input id=firstname type="text" class="input-field" placeholder="First Name" required>
      <input id="lastname" type="text" class="input-field" placeholder="Last Name" required>
      <input id="birthday" type="text" class="input-field" onfocus="(this.type='date')" placeholder="Birthday" required>
      <input type="tel" class="input-field" placeholder="Phone number">
      <select id="role" class="input-field" name="role">
        <option value="Client">As a Client</option>
        <option value="Driver">As a Driver</option>
      </select>
      <button type="submit" class="submit-btn">Register</button>
    </form>
  </div>
</div>
<script>
  var loginElement = document.getElementById("login")
  var registerElement = document.getElementById("register")
  var btnElement = document.getElementById("btn")

  function toggleRegister() {
    loginElement.style.left = "-400px"
    registerElement.style.left = "50px"
    btnElement.style.left = "110px"
    //registerElement.hidden = false
    //loginElement.hidden = true
  }
  function toggleLogin() {
    loginElement.style.left = "50px"
    registerElement.style.left = "450px"
    btnElement.style.left = "0px"
    //registerElement.hidden = true
    //loginElement.hidden = false
  }

</script>
</body>

</html>