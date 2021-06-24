<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Start your development with a Dashboard for Bootstrap 4.">
<meta name="author" content="Creative Tim">
<title>UTN FRGP</title>
<!-- Favicon -->
<link rel="icon"
	href="https://play-lh.googleusercontent.com/on7AWbuav44mB2ztIB6mp1BUu6bhIMcNd-9YjbjNDxgViamcJ3bo1dkEo06EGbC7njw"
	type="image/png">
<!-- Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
<!-- Icons -->
<link rel="stylesheet" href="assets/vendor/nucleo/css/nucleo.css"
	type="text/css">
<link rel="stylesheet"
	href="assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
	type="text/css">
<!-- Page plugins -->
<!-- Argon CSS -->
<link rel="stylesheet" href="assets/css/argon.css?v=1.2.0"
	type="text/css">


<script type="text/javascript">
	function alertAgregarUsuario() {
		alert("Usuario creado exitosamente");
	}
	
	function alertModificarUsuario() {
		alert("Usuario modificado exitosamente");
	}
</script>


</head>

<body>
	<form method="post" action="agregarCliente.html">
		<script type="text/javascript">
			function Filtrar(strKey) {
				var strData = strKey.value.toLowerCase().split(" ");
				var tblData = document.getElementById('example');
				var rowData;
				for (var i = 1; i < tblData.rows.length; i++) {
					rowData = tblData.rows[i].innerHTML;
					var styleDisplay = 'none';
					for (var j = 0; j < strData.length; j++) {
						if (rowData.toLowerCase().indexOf(strData[j]) >= 0)
							styleDisplay = '';
						else {
							styleDisplay = 'none';
							break;
						}
					}
					tblData.rows[i].style.display = styleDisplay;
				}
			}
		</script>



		<!-- Sidenav -->
		<nav
			class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white"
			id="sidenav-main">
			<div class="scrollbar-inner">
				<!-- Brand -->
				<div class="sidenav-header  align-items-center">
					<a class="navbar-brand" href="javascript:void(0)"> <img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLkhUzGfv2cVnLW35gPKqwpGdOEf7gttt20Q&usqp=CAU"
						class="navbar-brand-img" alt="...">
					</a>
				</div>
				<div class="navbar-inner">
					<!-- Collapse -->
					<div class="collapse navbar-collapse" id="sidenav-collapse-main">
						<!-- Nav items -->
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link active"
								href="ABMLCuentas.jsp"> <i class="ni ni-tv-2 text-primary"></i>
									<span class="nav-link-text">ABML Cuentas</span>
							</a></li>
							<li class="nav-item"><a class="nav-link"
								href="ABMLClientes.jsp"> <i
									class="ni ni-single-02 text-yellow"></i> <span
									class="nav-link-text">ABML Clientes</span>
							</a></li>
						</ul>
						<hr class="my-3">
					</div>
				</div>
			</div>
		</nav>
		<!-- Main content -->
		<div class="main-content" id="panel">
			<!-- Topnav -->
			<nav
				class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
				<div class="container-fluid">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<!-- Search form -->

						<!-- Navbar links -->
						<ul class="navbar-nav align-items-center  ml-md-auto ">
							<li class="nav-item d-xl-none">
								<!-- Sidenav toggler -->
								<div class="pr-3 sidenav-toggler sidenav-toggler-dark"
									data-action="sidenav-pin" data-target="#sidenav-main">
									<div class="sidenav-toggler-inner">
										<i class="sidenav-toggler-line"></i> <i
											class="sidenav-toggler-line"></i> <i
											class="sidenav-toggler-line"></i>
									</div>
								</div>
							</li>
						</ul>
						<ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
							<li class="nav-item dropdown"><a class="nav-link pr-0"
								href="#" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false">
									<div class="media align-items-center">
										<span class="avatar avatar-sm rounded-circle"> <img
											alt="Image placeholder" src="assets/img/theme/team-1.jpg">
										</span>
										<div class="media-body  ml-2  d-none d-lg-block">
											<span class="mb-0 text-sm  font-weight-bold">Cacho
												Castania</span>
										</div>
									</div>
							</a>
								<div class="dropdown-menu  dropdown-menu-right ">
									<div class="dropdown-header noti-title">
										<h6 class="text-overflow m-0">Bienvenido!</h6>
									</div>
									<a href="#!" class="dropdown-item"> <i
										class="ni ni-single-02"></i> <span>Mi perfil</span>
									</a> <a href="#!" class="dropdown-item"> <i
										class="ni ni-settings-gear-65"></i> <span>Configuracion</span>
									</a>
									<div class="dropdown-divider"></div>
									<a href="Login.jsp" class="dropdown-item"> <i
										class="ni ni-user-run"></i> <span>Salir</span>
									</a>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Header -->
			<!-- Header -->
			<div class="header bg-primary pb-6">
				<div class="container-fluid">
					<div class="header-body">
						<div class="row align-items-center py-4">
							<div class="col-lg-6 col-7">
								<nav aria-label="breadcrumb"
									class="d-none d-md-inline-block ml-md-4">
									<ol class="breadcrumb breadcrumb-links breadcrumb-dark">
										<li class="breadcrumb-item"><a href="#"><i
												class="fas fa-home"></i></a></li>
										<li class="breadcrumb-item"><a href="#">ABML</a></li>
										<li class="breadcrumb-item active" aria-current="page">Alta
											de cliente</li>
									</ol>
								</nav>
							</div>

						</div>
					</div>
				</div>
			</div>
			<!-- Page content -->
			<div class="container-fluid mt--6">
				<div class="row justify-content-center">
					<div class=" col ">
						<div class="card">
							<div class="card-header bg-transparent">
								<h3 class="mb-0">Cliente</h3>
							</div>

							<div class="row">
								<div class="card-body">
									<div class="row icon-examples">
										<div class="col-xl-12">
											<div class="card">
												<div class="card-header">
													<div class="row align-items-center">
														<div class="col-xl-12">
															<h3 class="mb-0">Alta de cliente</h3>
														</div>
													</div>
												</div>
												<div class="card-body">
													<h6 class="heading-small text-muted mb-4">Información
														de cliente</h6>
													<div class="pl-lg-4">
														<div class="row">
															<div class="col-lg-6">
																<div class="form-group">
																	<label class="form-control-label" for="input-email">Email</label>
																	<input type="email" id="input-email"
																		class="form-control" placeholder="email"
																		name="txtEmail" required>
																</div>
															</div>
															<div class="col-lg-6">
																<div class="form-group">
																	<label class="form-control-label" for="input-last-name">DNI</label>
																	<input type="text" id="input-dni" class="form-control"
																		placeholder="DNI" name="txtDNI" required>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-lg-6">
																<div class="form-group">
																	<label class="form-control-label"
																		for="input-first-name">Nombre</label> <input
																		type="text" id="input-first-name" class="form-control"
																		placeholder="Nombres" value="Gabriel Brandon"
																		name="txtNombre" required>
																</div>
															</div>
															<div class="col-lg-6">
																<div class="form-group">
																	<label class="form-control-label" for="input-last-name">Apellido</label>
																	<input type="text" id="input-last-name"
																		class="form-control" placeholder="Apellido"
																		value="Dilacio" name="txtApellido" required>
																</div>
															</div>
														</div>
													</div>
													<!-- Address -->
													<hr class="my-12" />

													<div class="form-group">
														<div class="col-12 text-center">
															<input class="btn btn-sm btn-primary"
																style="width: 250px;" type="submit" value="Crear"
																name="btnCrear"> <input
																class="btn btn-sm btn-primary" style="width: 250px;"
																type="submit" value="Modificar" name="btnModificar">
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
			<!-- Argon Scripts -->
			<!-- Core -->
			<script src="assets/vendor/jquery/dist/jquery.min.js"></script>
			<script src="assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
			<script src="assets/vendor/js-cookie/js.cookie.js"></script>
			<script src="assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
			<script
				src="assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
			<!-- Optional JS -->
			<script src="assets/vendor/chart.js/dist/Chart.min.js"></script>
			<script src="assets/vendor/chart.js/dist/Chart.extension.js"></script>
			<!-- Argon JS -->
			<script src="assets/js/argon.js?v=1.2.0"></script>
	</form>
	<c:choose>
		<c:when test="${agregadoExitoso == true && esBotonCrear == 'Crear'}">
			<script type="text/javascript">
				window.onload = alertAgregarUsuario;
			</script>
			<br />
		</c:when>
		<c:when test="${agregadoExitoso == true && esBotonCrear == null}">
			<script type="text/javascript">
				window.onload = alertModificarUsuario;
			</script>
			<br />
		</c:when>
	</c:choose>
</body>

</html>
