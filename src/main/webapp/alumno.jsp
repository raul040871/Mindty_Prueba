<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<!-- Enla�e del header -->
	<jsp:include page="./utils/header.jsp"></jsp:include>
	<!-- Fin header -->
	<!-- Breadcrumb -->
	<nav class="breadcrumb">
		<a class="breadcrumb-item active" href="#" title="Incio" alt="Incio"
			aria-label="Inicio"> <i class="fas fa-home"></i>
		</a>
	</nav>
	<div>
		<h1>Cursos</h1>
		
				<hr>
				<div>
					<c:forEach var="unCurso" items="${listaCurso}" varStatus="counter">
						<a>${unCurso.nombreCurso} </a>
						<hr>

					</c:forEach>
				</div>
				<div>
					<c:forEach var="unModulo" items="${listaModulo}"
						varStatus="counter">
						<a> ${unModulo.nombreModulo} </a>
						<hr>

					</c:forEach>
				</div>
				<div>
					<c:forEach var="unaUnidad" items="${listaUnidad}"
						varStatus="counter">
						<a> ${unaUnidad.nombreUnidad}</a>
						<hr>
					</c:forEach>
				</div>
			</div>

		


	<%-- 	<div class="desplegable">
			<div id="accordion">
				<div class="card">
					<div class="card-header" id="headingOne">
						<span name="alumno" value="alumno">alumno</span>
						<c:forEach var="unCurso" items="${listaCurso}" varStatus="counter">
							<h1 value="alumno">alumno</h1>
							<option value="${unCurso.idCurso}">${unCurso.nombreCurso}</option>
							<h2 class="mb-0">
								<!-- Boton del desplegable del primer curso -->

								<button class="btn btn-link" data-toggle="collapse"
									data-target="#collapseOne1" aria-expanded="true"
									aria-controls="collapseOne" value="${unCurso.idc}">
									${unCurso.nombreCurso}

									<c:forEach var="unModulo" items="${listaModulos}"
										varStatus="counter">
										<option value="${unModulo.idm}"></option>
										<div class="card-header" id="headingOne">
											<h3 class="mb-0">
												<!-- Boton del desplegable del primer Modulo -->
												<button class="btn btn-link" data-toggle="collapse"
													data-target="#collapseN2" aria-expanded="true"
													aria-controls="collapseOne" value="${unModulo.idm}">${unModulo.nombreModulo}
												</button>
											</h3>
										</div>
									</c:forEach>
								</button>


							</h2>

						</c:forEach>
					</div>
				</div>
			</div>
		</div>
 --%>



		<!-- 	<---------------------------->
		<div class="desplegable">
			<div id="accordion">
				<div class="card">
					<div class="card-header" id="headingOne">
						<h2 class="mb-0">
							<!-- Boton del desplegable del primer curso -->
							<button class="btn btn-link" data-toggle="collapse"
								data-target="#collapseOne1" aria-expanded="true"
								aria-controls="collapseOne">1 Curso</button>
						</h2>
					</div>

					<div id="collapseOne1" class="collapse show"
						aria-labelledby="headingOne" data-parent="#accordion">
						<div class="card-body">

							<div id="accordion2">
								<div class="card">
									<div class="card-header" id="headingOne">
										<h3 class="mb-0">
											<!-- Boton del desplegable del primer Modulo -->
											<button class="btn btn-link" data-toggle="collapse"
												data-target="#collapseN2" aria-expanded="true"
												aria-controls="collapseOne">Modulo 1</button>
										</h3>
									</div>

									<div id="collapseN2" class="collapse "
										aria-labelledby="headingOne" data-parent="#accordion2">
										<div class="card-body">
											<div class="card-body">

												<div id="accordion3">
													<div class="card">
														<div class="card-header" id="headingOne">
															<h4 class="mb-0">
																<!-- Boton del desplegable del primer Uf -->
																<button class="btn btn-link" data-toggle="collapse"
																	data-target="#collapseN3" aria-expanded="true"
																	aria-controls="collapseOne">Uf1</button>
															</h4>
														</div>

														<div id="collapseN3" class="collapse "
															aria-labelledby="headingOne" data-parent="#accordion3">
															<div class="card-body">
																<p>Documentacion</p>
																<br> <br>
																<p>Notas</p>
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>
										<div class="card-body">
											<div class="card-body">

												<div id="accordion3">
													<div class="card">
														<div class="card-header" id="headingOne">
															<h4 class="mb-0">
																<button class="btn btn-link" data-toggle="collapse"
																	data-target="#collapseN6" aria-expanded="true"
																	aria-controls="collapseOne">Uf1</button>
															</h4>
														</div>

														<div id="collapseN6" class="collapse "
															aria-labelledby="headingOne" data-parent="#accordion6">
															<div class="card-body"></div>
														</div>
													</div>
												</div>

											</div>
										</div>
										<div class="card-body">
											<div class="card-body">

												<div id="accordion7">
													<div class="card">
														<div class="card-header" id="headingOne">
															<h4 class="mb-0">
																<button class="btn btn-link" data-toggle="collapse"
																	data-target="#collapseN7" aria-expanded="true"
																	aria-controls="collapseOne">Uf1</button>
															</h4>
														</div>

														<div id="collapseN7" class="collapse "
															aria-labelledby="headingOne" data-parent="#accordion7">
															<div class="card-body"></div>
														</div>
													</div>
												</div>

											</div>
										</div>



									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingTwo">
					<h2 class="mb-0">
						<!-- Boton del desplegable del segundo Modulo -->
						<button class="btn btn-link collapsed" data-toggle="collapse"
							data-target="#collapseTwo2" aria-expanded="false"
							aria-controls="collapseTwo">2 Curso</button>
					</h2>
				</div>
				<div id="collapseTwo2" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordion">
					<div class="card-body"></div>
				</div>
			</div>
			<div class="card">
				<div class="card-header" id="headingThree">
					<h2 class="mb-0">
						<!-- Boton del desplegable del tercer Modulo -->
						<button class="btn btn-link collapsed" data-toggle="collapse"
							data-target="#collapseThree3" aria-expanded="false"
							aria-controls="collapseThree">3 Curso</button>
					</h2>
				</div>
				<div id="collapseThree3" class="collapse"
					aria-labelledby="headingThree" data-parent="#accordion">
					<div class="card-body"></div>
				</div>
			</div>
		</div>
	</div>



	</section>
	<!-- <div id="calendar"></div> -->
	<!-- Fin section -->
	<div id="calendario">

		</head>

		<body>
			<div id="formC">
				<h2>Calendario</h2>
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
	<!-- Inicio footer -->
	<!-- Enla�e footer -->
	<jsp:include page="./utils/footer.jsp"></jsp:include>
	<!-- fin footer -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js "
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN "
		crossorigin="anonymous "></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js "
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q "
		crossorigin="anonymous "></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js "
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl "
		crossorigin="anonymous "></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.print.css"></script> -->
	<script src="./js/calendario.js"></script>
</body>

</html>