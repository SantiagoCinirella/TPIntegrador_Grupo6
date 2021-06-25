<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>

<body>
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
							href="abmlCuentas.html"> <i class="ni ni-tv-2 text-primary"></i> <span
								class="nav-link-text">ABML Cuentas</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="abmlClientes.html"> <i
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
					<form class="navbar-search navbar-search-light form-inline mr-sm-3"
						id="navbar-search-main">
						<div class="form-group mb-0">
							<div
								class="input-group input-group-alternative input-group-merge">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-search"></i></span>
								</div>
								<input class="form-control" placeholder="Buscar" type="text"
									onkeyup=Filtrar(this)>
							</div>
						</div>
						<button type="button" class="close" data-action="search-close"
							data-target="#navbar-search-main" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</form>
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
								<a href="index.html" class="dropdown-item"> <i
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
									<li class="breadcrumb-item active" aria-current="page">Cuentas</li>
								</ol>
							</nav>
						</div>
						<div class="col-lg-6 col-5 text-right">
							<a href="#" class="btn btn-sm btn-neutral">Nueva cuenta</a>
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
							<h3 class="mb-0">Cuentas</h3>
						</div>
						<br>
						<div class="row">
							<div class="col-xl-12">
								<div class="card bg-default">
									<div class="card-header bg-transparent">
										<div class="row align-items-center">
											<div class="col-xl-12"></div>
											<div class="table-responsive">
												<table id="example"
													class="table align-items-center table-dark table-flush display"
													cellspacing="0" width="100%">

													<thead class="thead-dark" id="example">
														<tr>
															<th scope="col" class="sort" data-sort="NumeroCuenta">NumeroCuenta</th>
															<th scope="col" class="sort" data-sort="Tipo">Tipo
																de cuenta</th>
															<th scope="col" class="sort" data-sort="CBU">CBU</th>
															<th scope="col" class="sort" data-sort="Alias">Alias</th>
															<th scope="col" class="sort" data-sort="Modificar">Modificar</th>
															<th scope="col" class="sort" data-sort="Eliminar">Eliminar</th>

														</tr>
													</thead>
													<tbody class="list">
														<c:forEach items="${listaPersona}" var="item">
															<tr>
																<td>${item.nroCuenta}</td>
																<td>${item.tipoCuenta}</td>
																<td>${item.cbu}</td>
																<td>${item.alias}</td>
																<td><form method="post" action="ModificarCuenta.html">
																		<input type=submit value="Modificar"
																			class="btn btn-sm btn-neutral" name="btnModificar" id="Modificar"
																			OnClick="return confirm('Estas seguro de modificar la cuenta ${item.nroCuenta}, CBU ${item.cbu}?')">
																		<input type="hidden" value="${item.cbu}"
																			class="myButton" name="cbu" id="numeroCuenta">
																			<input type="hidden" value="${item.nroCuenta}"
																			class="myButton" name="numeroCuenta" id="numeroCuenta">
																			<input type="hidden" value="${item.tipoCuenta}"
																			class="myButton" name="tipoCuenta" id="numeroCuenta">
																			<input type="hidden" value="${item.alias}"
																			class="myButton" name="alias" id="numeroCuenta">
																	</form>
																	</td>
																<td>
																	<form method="post" action="eliminacionCuenta.html">
																		<input type=submit value="Eliminar"
																			class="btn btn-sm btn-neutral" name="btnnumeroCuenta" id="numeroCuenta"
																			OnClick="return confirm('Estas seguro de eliminar la cuenta ${item.nroCuenta}, CBU ${item.cbu}?')">
																		<input type="hidden" value="${item.cbu}"
																			class="myButton" name="numeroCuenta" id="numeroCuenta">
																	</form>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
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
</body>

</html>
