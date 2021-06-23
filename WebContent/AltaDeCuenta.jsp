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
										de cuenta</li>
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
							<h3 class="mb-0">Cuentas</h3>
						</div>
									<div class="row">
						<div class="card-body">
							<div class="row icon-examples">
                					<div class="col-xl-12">
									<div class="card">
										<div class="card-header">
											<div class="row align-items-center">
                								<div class="col-xl-12">
													<h3 class="mb-0">Alta de cuenta</h3>
												</div>
											</div>
										</div>
										<div class="card-body">
											<form>
												<h6 class="heading-small text-muted mb-4">Información
													de cliente</h6>
												<div class="pl-lg-4">
													<div class="row">
														<div class="col-lg-6">
															<div class="form-group">
																<label class="form-control-label" for="input-username">Cliente</label>
																<select class="form-control" id="sel1">
																	<option selected="true" disabled="disabled">Seleccione
																		un cliente</option>
																	<option>11223344455</option>
																	<option>22222222222</option>
																	<option>33333333333</option>
																</select>
															</div>
														</div>
														<div class="col-lg-6">
															<div class="form-group">
																<label class="form-control-label" for="input-email">DNI</label>
																<input type="email" id="input-email" disabled="disabled"
																	class="form-control" placeholder="31.222.333"
																	value="31.222.333">
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-6">
															<div class="form-group">
																<label class="form-control-label" for="input-first-name">Nombres</label>
																<input type="text" disabled="disabled"
																	id="input-first-name" class="form-control"
																	placeholder="Nombres" value="Gabriel Brandon">
															</div>
														</div>
														<div class="col-lg-6">
															<div class="form-group">
																<label class="form-control-label" for="input-last-name">Apellido</label>
																<input type="text" id="input-last-name"
																	disabled="disabled" class="form-control"
																	placeholder="Apellido" value="Dilacio">
															</div>
														</div>
													</div>
												</div>
												<hr class="my-4" />
												<!-- Address -->
												<h6 class="heading-small text-muted mb-4">Informacion
													de cuenta</h6>
												<div class="pl-lg-4">
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<label class="form-control-label" for="input-address">Tipo
																	de cuenta</label> <select class="form-control" id="sel1">
																	<option selected="true" disabled="disabled">Seleccione
																		un tipo de Cuenta</option>
																	<option>Caja de ahorro en pesos</option>
																	<option>Caja de ahorro en dolares</option>
																	<option>Cuenta Comitente</option>
																</select>
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-4">
															<div class="form-group">
																<label class="form-control-label" for="input-city">CBU</label>
																<input type="text" id="input-city" class="form-control"
																	placeholder="CBU" disabled="disabled"
																	value="22334455667788">
															</div>
														</div>
														<div class="col-lg-4">
															<div class="form-group">
																<label class="form-control-label" for="input-country">N°
																	de cuenta</label> <input type="text" id="input-country"
																	class="form-control" placeholder="N° de cuenta"
																	disabled="disabled" value="123-44556-123">
															</div>
														</div>
														<div class="col-lg-4">
															<div class="form-group">
																<label class="form-control-label" for="input-country">Alias</label>
																<input type="number" id="input-postal-code"
																	class="form-control" disabled="disabled"
																	placeholder="Alias">
															</div>
														</div>
													</div>
												</div>
												<hr class="my-12" />
													<div class="form-group">
														  <div class="col-12 text-center">
										                  	<a href="#!" class="btn btn-sm btn-primary" style="width: 250px;">Alta</a>
										                  	<a href="#!" class="btn btn-sm btn-primary" style="width: 250px;">Modificación</a>
										                </div>
													</div>
											</form>
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
