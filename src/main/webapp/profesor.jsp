<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.mindty.modelos.Curso"%>
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

<!-- Font Awesome -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.9/js/all.js"
	integrity="sha384-8iPTk2s/jMVj81dnzb/iFR2sdA7u06vHJyyLlAd4snFpCl/SnyUjRrbdJsw1pGIl"
	crossorigin="anonymous"></script>

<title>Mindty</title>
</head>

<body>
	<!-- Enlaçe del header -->
	<jsp:include page="./utils/header.jsp"></jsp:include>
	<!-- Fin header -->

	<!-- Breadcrumb -->
	<nav class="breadcrumb">
		<div>
			<a class="breadcrumb-item" href="#" title="Incio" alt="Incio"
				aria-label="Inicio"> <i class="fas fa-home"></i>
			</a> <a class="breadcrumb-item" href="#" title="Curso" alt="Curso">Contenido</a>
			<span class="breadcrumb-item active" title="Añadir modulo"
				alt="Añadir modulo">Modulos</span>
		</div>
	</nav>

	<!-- Nombre seccion -->
	<section>
		<div id="ok"></div>
		<h2>Seleccionar Curso:</h2>

		<!-- lsita de cursos -->

		<form id="form_Cursos" method="POST">
			<div class="form-row">
				<div class="form-group col-12">
					<select id="Cursos" class="form-control col-12"
						aria-label="Selecciona al formador" name="Cursos">
						<!-- <option value="" disabled selected>Cursos</option> -->
						<c:forEach var="unCurso" items="${listaCursos}"
							varStatus="counter">
							<option value="${unCurso.idCurso}">${unCurso.nombreCurso}</option>
						</c:forEach>

					</select>
				</div>

				<button>Cargar Modulos</button>
			</div>
		</form>

		<form id="form_Modulos" class="form-inline" method="POST">
			<div class="form-row">
				<div class="form-group col-12">
					<select id="Modulo" class="form-control col-12"
						aria-label="Selecciona al formador" name="ModuloCurso">
						<!-- <option value="" disabled selected>Cursos</option> -->
						<c:forEach var="unModulo" items="${listaModulo}"
							varStatus="counter">
							<option value="${unModulo.idm}">${unModulo.nombreModulo}</option>
						</c:forEach>

					</select>
				</div>

				<button>Mostrar alumnos</button>
			</div>
		</form>

		<h2>Alumnos</h2>
		<ul>
			<div>
				<ul>
					<c:forEach items="${listaAlumnos}" var="alumnos">
						<li><strong>${alumnos.nombreUsuario}</strong>, ${alumnos.email}</li>
					</c:forEach>
				</ul>
			</div>
		</ul>

	</section>











	<div id="calendario">

		</head>

		<body>
			<div id="formC">
				<h3>Calendario</h3>
				<!-- ivan -->
				<table id="calendar">
					<caption></caption>
					<thead>
						<tr>
							<th>Lun</th>
							<th>Mar</th>
							<th>Mie</th>
							<th>Jue</th>
							<th>Vie</th>
							<th>Sab</th>
							<th>Dom</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>

			</div>
	</div>

	<!-- Copy right -->
	<!-- Inicio footer -->
	<!-- Enlaçe footer -->
	<jsp:include page="./utils/footer.jsp"></jsp:include>
	<!-- fin footer -->
</body>
<!-- Optional JavaScript -->
<script src="./js/jquery-3.3.1.min.js"></script>
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js "
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q "
	crossorigin="anonymous "></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js "
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl "
	crossorigin="anonymous "></script>
<script src="./js/formValidationProfe.js"></script>
<script src="./js/calendario.js"></script>


</html>