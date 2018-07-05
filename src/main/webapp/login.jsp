<!DOCTYPE html>
<html lang="es">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- Mindty CSS -->
<link rel="stylesheet" href="./css/style.css">


<!-- Font Awesome -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.9/js/all.js"
	integrity="sha384-8iPTk2s/jMVj81dnzb/iFR2sdA7u06vHJyyLlAd4snFpCl/SnyUjRrbdJsw1pGIl"
	crossorigin="anonymous"></script>
<title>Mindty</title>
</head>

<body>
	<!-- Inicio header -->
	<header>
		<!-- Menu nav -->
		<nav id="menu" class="navbar navbar-expand-lg navbar-light">
			<!-- Boton desplegable -->
			<!-- Titulo de la web -->
			<a class="navbar-brand logo" href="#">
				<h1>MINDTY</h1>
			</a>


		</nav>
		<!-- Menu nav -->
	</header>
	<!-- Fin header -->



	<section class="login">
		<form action="" method="post" id="commentForm">
			<div class="imgcontainer">
				<img src="./images/login/login.png" alt="Avatar" class="avatar">
			</div>
			<br> <br> <br>

			<div id="mensajes">
				<div>
					<div id="prue"></div>
					<input class="pinta" id="usuario" type="text" placeholder="usuario"
						name="usuario" value="Usuario"
						pattern="^([A-Z][a-z]{1}[a-z������]+[\s]*)+$" aria-label="Usuario"
						required>
				</div>

				<div>
					<div id="prue2"></div>
					<input class="pinta" id="contrase�a" type="password"
						placeholder="contrase�a" value="Password"
						pattern="^([A-Z]{1}[a-z������]+[\s]*)+$" aria-label="Contrase�a"
						name="contrasena" required>
				</div>
				<div>
					<br>
					<button id="bton" type="submit">Entrar</button>
				</div>

			</div>
			<div class="enviado"></div>
		</form>
		<div id="errServidor"></div>
		<div id="btonErr"></div>
	</section>
	<footer>
		<div>
			<p>
				Dise�ado por OVERFLOW <br>&copy 2.018
			</p>
		</div>
	</footer>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/login.js"></script>

</html>