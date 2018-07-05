<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.mindty.modelos.Usuario"%>
<%@page import="java.util.List"%>

<!doctype html>
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

<title>Mindty: Coordinador</title>
</head>

<body>
	<!-- Enla�e del header -->
	<jsp:include page="./utils/header.jsp"></jsp:include>
	<!-- Fin header -->
	<!-- Fin header -->
	<!-- Breadcrumb -->
	<nav class="breadcrumb">
		<a class="breadcrumb-item" href="#" title="Incio" alt="Incio"
			aria-label="Inicio"> <i class="fas fa-home"></i>
		</a> <a class="breadcrumb-item" href="#" title="Curso" alt="Curso">Cursos</a>
		<span class="breadcrumb-item active" title="A�adir m�dulo"
			alt="A�adir m�dulo">Curso</span>
	</nav>

	<!-- Nombre secci�n -->
	<h1 class="d-inline">Curso</h1>
	<!-- Lupa -->
	<button class="botons d-inline ml-3" aria-label="Buscar curso">
		<i id="lupa" class="fas fa-search fa-2x"></i>
	</button>
	<hr>
	</section>

	<!-- Formulario entrada curso -->
	<section>
		<form id="formCurso" action="" method="POST">
			<!-- Fila C�digo + Nombre Curso -->
			<div class="form-row">
				<div class="form-group col-4">
					<!-- Campo C�digo curso con RegExp = ^[A-Z]{3}\s+[0-9]{5}$ (XXX 12345)$ -->
					<input type="text" class="form-control"
						pattern="^[A-Z]{3}\s+[0-9]{5}$" id="codigoCurso"
						placeholder="C�digo" aria-label="C�digo curso" name="codigoCurso"
						required value="ASD 12345"> <small id="cheet" class="text-info">Ej.
						XXX 12345</small>
				</div>
				<div class="col-8">
					<!-- ExpReg= 1a letra mayuscula, solo letras -->
					<input type="text" class="form-control"
						pattern="^[A-Z]+(([,. -][a-zA-Z ])?[a-zA-Z]*)*$" id="nombreCurso"
						placeholder="Nombre curso" aria-label="Nombre curso"
						name="nombreCurso" required value="Curso demo">
				</div>
			</div>

			<!-- Fila formador + horas -->
			<div class="form-row">
				<div class="form-group col-8">
					<select id="profes" class="form-control col-12"
						aria-label="Selecciona al formador" name="profes">
						<option value="0" disabled selected>Formador</option>
						<c:forEach var="unProfe" items="${profes}" varStatus="counter">
							<option value="${unProfe.idu}">${unProfe.nombreUsuario}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-4">
					<input type="number" class="form-control" id="horas"
						placeholder="20" min="20" max="200" name="horas" value="120"> <label
						for="horas">N� horas</label>
				</div>
			</div>

			<!-- N�mero m�dulos -->
			<div class="form-row" id="modulosadd">
				<div class="form-group col-5">
					<label for="modulos">N� m�dulos del curso</label> <input
						type="number" class="form-control" id="modulos" placeholder="1"
						min="1" max="10" name="modulos" value="2">
				</div>
				<button id="modulosButton" type="button" class="btn btn-info">A�adir
					m�dulos</button>
			</div>

			<!-- Listado de alumnos -->
			<div id="alumnos">
				<div class="row">
					<div class="col-3 btnBadge">
						<button id="btonAlumnos" type="button" class="btn btn-primary">
							Alumnos <span class="badge badge-light">4</span>
						</button>
					</div>
					<div class="col-5"></div>
					<div class="col-4">
						<button type="button" id="add" class="btn btn-success derecha"
							aria-label="Añadir alumno">
							<i class="fas fa-plus"></i>
						</button>
					</div>
				</div>

				<div class="row">
					<div class="col-6">
						<img class="rounded-circle img-thumbnail"
							src="./images/users/usr1.jpg" alt="Usuario 1">
						<p>
							<i class="fas fa-user"></i> Julia Ivanov <br> <i
								class="fas fa-envelope"></i> <a href="mailto:#">julia@ivanov.ru</a>
							<br> <i class="fas fa-phone flip-horizontal"></i> <a
								href="tel:#">685 12 75 54</a>
						</p>
					</div>
					<div class="col-6">
						<img class="rounded-circle img-thumbnail"
							src="./images/users/usr1.jpg" alt="Usuario 2">
						<p>
							<i class="fas fa-user"></i> Julia Ivanov <br> <i
								class="fas fa-envelope"></i> <a href="mailto:#">julia@ivanov.ru</a>
							<br> <i class="fas fa-phone flip-horizontal"></i> <a
								href="tel:#">685 12 75 54</a>
						</p>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<img class="rounded-circle img-thumbnail"
							src="./images/users/usr1.jpg" alt="Usuario 3">
						<p>
							<i class="fas fa-user"></i> Julia Ivanov <br> <i
								class="fas fa-envelope"></i> <a href="mailto:#">julia@ivanov.ru</a>
							<br> <i class="fas fa-phone flip-horizontal"></i> <a
								href="tel:#">685 12 75 54</a>
						</p>
					</div>
					<div class="col-6">
						<img class="rounded-circle img-thumbnail"
							src="./images/users/usr1.jpg" alt="Usuario 4">
						<p>
							<i class="fas fa-user"></i> Julia Ivanov <br> <i
								class="fas fa-envelope"></i> <a href="mailto:#">julia@ivanov.ru</a>
							<br> <i class="fas fa-phone flip-horizontal"></i> <a
								href="tel:#">685 12 75 54</a>
						</p>
					</div>
				</div>
			</div>

			<!-- Guardar -->
			<!-- <div class="col-2 container d-flex h-100 justify-content-center align-self-center"> -->
			<div>
				<button id="enviar" class="btn btn-primary btn-lg btn-block" aria-label="Guardar">Guardar</button>
			</div>
		</form>
		<div id="mensajes" class="row justify-content-center"></div>
	</section>

	<!-- Copy right -->
	<!-- Inicio footer -->
	<!-- Enla�e footer -->
	<jsp:include page="./utils/footer.jsp"></jsp:include>
	<!-- fin footer -->
</body>

<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- Popper.js, then Bootstrap JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q "
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl "
	crossorigin="anonymous"></script>

<!-- Font Awesome -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.9/js/all.js"
	integrity="sha384-8iPTk2s/jMVj81dnzb/iFR2sdA7u06vHJyyLlAd4snFpCl/SnyUjRrbdJsw1pGIl"
	crossorigin="anonymous"></script>

<!-- Mindty JS -->
<!-- <script src="./js/formValidation.js"></script> -->
<script src="./js/formValidationCoordinador.js" charset="UTF-8">
	>
</script>

</html>