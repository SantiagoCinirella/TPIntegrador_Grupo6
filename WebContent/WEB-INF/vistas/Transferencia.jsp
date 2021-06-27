<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="frgp.utn.edu.ar.entidad.Persona"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css">    
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
  <meta name="author" content="Creative Tim">
  <title>UTN FRGP</title>
  <!-- Favicon -->
  <link rel="icon" href="https://play-lh.googleusercontent.com/on7AWbuav44mB2ztIB6mp1BUu6bhIMcNd-9YjbjNDxgViamcJ3bo1dkEo06EGbC7njw" type="image/png">
  <!-- Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
  <!-- Icons -->
  <link rel="stylesheet" href="assets/vendor/nucleo/css/nucleo.css" type="text/css">
  <link rel="stylesheet" href="assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" type="text/css">
  <!-- Page plugins -->
  <!-- Argon CSS -->
  <link rel="stylesheet" href="assets/css/argon.css?v=1.2.0" type="text/css">
</head>

<body>
 					    <% 
	HttpSession misession= (HttpSession) request.getSession();
	 
	Persona Persona = (Persona) misession.getAttribute("Usuario");
	%>  
  <!-- Sidenav -->
  <nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white" id="sidenav-main">
    <div class="scrollbar-inner">
      <!-- Brand -->
      <div class="sidenav-header  align-items-center">
        <a class="navbar-brand" href="javascript:void(0)">
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLkhUzGfv2cVnLW35gPKqwpGdOEf7gttt20Q&usqp=CAU" class="navbar-brand-img" alt="...">
        </a>
      </div>
      <div class="navbar-inner">
        <!-- Collapse -->
        <div class="collapse navbar-collapse" id="sidenav-collapse-main">
          <!-- Nav items -->
          <ul class="navbar-nav">
            <li class="nav-item">
         <center>
            <form method="post" action="homeCliente.html">
            <i class="ni ni-tv-2 text-primary"></i>			
			<input type=submit value="Cuentas"class="btn btn-primary btn-sm" name="btn" id="btn">
			<input type="hidden" value="<%=Persona.getDni()%>"class="myButton" name="Usuario" id="Usuario">
			</form>
			</center>
            </li>
          </ul>
          <!-- Divider -->
          <hr class="my-3">
          <!-- Heading -->
          
          <!-- Navigation -->
        </div>
      </div>
    </div>
  </nav>
  <!-- Main content -->
  <div class="main-content" id="panel">
    <!-- Topnav -->
    <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!-- Search form -->

          <!-- Navbar links -->
          <ul class="navbar-nav align-items-center  ml-md-auto ">
            <li class="nav-item d-xl-none">
              <!-- Sidenav toggler -->
              <div class="pr-3 sidenav-toggler sidenav-toggler-dark" data-action="sidenav-pin" data-target="#sidenav-main">
                <div class="sidenav-toggler-inner">
                  <i class="sidenav-toggler-line"></i>
                  <i class="sidenav-toggler-line"></i>
                  <i class="sidenav-toggler-line"></i>
                </div>
              </div>
            </li>
            <li class="nav-item d-sm-none">
              <a class="nav-link" href="#" data-action="search-show" data-target="#navbar-search-main">
                <i class="ni ni-zoom-split-in"></i>
              </a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="ni ni-bell-55"></i>
              </a>
              <div class="dropdown-menu dropdown-menu-xl  dropdown-menu-right  py-0 overflow-hidden">
                <!-- Dropdown header -->
                <div class="px-3 py-3">
                  <h6 class="text-sm text-muted m-0">Tenes <strong class="text-primary">3</strong> nuevas notificationes.</h6>
                </div>
                <!-- List group -->
                <div class="list-group list-group-flush">
                  <a href="#!" class="list-group-item list-group-item-action">
                    <div class="row align-items-center">
                      <div class="col-auto">
                        <!-- Avatar -->
                        <img alt="Image placeholder" src="assets/img/theme/team-1.jpg" class="avatar rounded-circle">
                      </div>
                      <div class="col ml--2">
                        <div class="d-flex justify-content-between align-items-center">
                          <div>
                            <h4 class="mb-0 text-sm">Pedro Tonello</h4>
                          </div>
                          <div class="text-right text-muted">
                            <small>Hace 2 hrs</small>
                          </div>
                        </div>
                        <p class="text-sm mb-0">Te ha transferido $2000</p>
                      </div>
                    </div>
                  </a>
                  <a href="#!" class="list-group-item list-group-item-action">
                    <div class="row align-items-center">
                      <div class="col-auto">
                        <!-- Avatar -->
                        <img alt="Image placeholder" src="assets/img/theme/team-2.jpg" class="avatar rounded-circle">
                      </div>
                      <div class="col ml--2">
                        <div class="d-flex justify-content-between align-items-center">
                          <div>
                            <h4 class="mb-0 text-sm">Mirta Legrand</h4>
                          </div>
                          <div class="text-right text-muted">
                            <small>Hace 3 hrs</small>
                          </div>
                        </div>
                        <p class="text-sm mb-0">Te ha transferido $1000.</p>
                      </div>
                    </div>
                  </a>
                  <a href="#!" class="list-group-item list-group-item-action">
                    <div class="row align-items-center">
                      <div class="col-auto">
                        <!-- Avatar -->
                        <img alt="Image placeholder" src="assets/img/theme/team-5.jpg" class="avatar rounded-circle">
                      </div>
                      <div class="col ml--2">
                        <div class="d-flex justify-content-between align-items-center">
                          <div>
                            <h4 class="mb-0 text-sm">Pedro Tonello</h4>
                          </div>
                          <div class="text-right text-muted">
                            <small>Hace 23 hrs</small>
                          </div>
                        </div>
                        <p class="text-sm mb-0">Te ha transferido $5000</p>
                      </div>
                    </div>
                  </a>
                </div>
                <!-- View all -->
              </div>
            </li>
          </ul>
          <ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
            <li class="nav-item dropdown">
              <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <div class="media align-items-center">
                  <span class="avatar avatar-sm rounded-circle">
                    <img alt="Image placeholder" src="assets/img/theme/team-4.jpg">
                  </span>
                  <div class="media-body  ml-2  d-none d-lg-block">
                    <span class="mb-0 text-sm  font-weight-bold"><%=Persona.getNombre()%>, <%=Persona.getApellido()%></span>
                  </div>
                </div>
              </a>
              <div class="dropdown-menu  dropdown-menu-right ">
                <div class="dropdown-header noti-title">
                  <h6 class="text-overflow m-0">Bienvenida!</h6>
                </div>
                <a href="#!" class="dropdown-item">
                  <i class="ni ni-single-02"></i>
                  <span>Mi perfil</span>
                </a>
                <a href="#!" class="dropdown-item">
                  <i class="ni ni-settings-gear-65"></i>
                  <span>Configuracion</span>
                </a>
                <div class="dropdown-divider"></div>
                <a href="index.html" class="dropdown-item">
                  <i class="ni ni-user-run"></i>
                  <span>Salir</span>
                </a>
              </div>
            </li>
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
              <nav aria-label="breadcrumb" class="d-none d-md-inline-block ml-md-4">
                <ol class="breadcrumb breadcrumb-links breadcrumb-dark">
                  <li class="breadcrumb-item"><a href="#"><i class="fas fa-home"></i></a></li>
                  <li class="breadcrumb-item"><a href="#">Transferencia</a></li>
                </ol>
              </nav>
            </div>
                        </div>
                        </div>
                        </div>
                        </div>
            
	<!-- Main content -->

		<!-- Page content -->
		<div class="container-fluid mt--6">
			<div class="row justify-content-center">
				<div class=" col ">
					<div class="card">
						<div class="card-header bg-transparent">
							<h3 class="mb-0">Transferencia</h3>
						</div>
						<div class="card-body">
							<div class="row icon-examples">
										<div class="card-body">
											<form>
												<h6 class="heading-small text-muted mb-4">Elegi tu cuenta para hacer la transferencia</h6>
												<div class="pl-lg-4">
													<div class="row">
														<div class="col-lg-6">
															<div class="form-group">
																<label class="form-control-label" for="input-username">Cuenta</label>
																<select class="form-control" id="Cuenta">
																	<option selected="true" disabled="disabled">Seleccione
																		una cuenta</option>
																	<option>11223344455</option>
																	<option>22222222222</option>
																	<option>33333333333</option>
																</select>
															</div>
														</div>
														<div class="col-lg-6">
															<div class="form-group">
																<label class="form-control-label" for="input-email">Saldo</label>
																<input type="email" id="Saldo" disabled="disabled"
																	class="form-control">
																	
															</div>
														</div>
													</div>
												</div>
												<hr class="my-4" />
												<!-- Address -->
												<h6 class="heading-small text-muted mb-4">Informacion
													de cuenta destino</h6>
												<div class="pl-lg-4">
													<div class="row">
														<div class="col-md-12">
														
															<div class="form-group">
																<label class="form-control-label" for="input-address">Tipo
																	de cuenta</label> 
																	<input type="text" id="CBU" class="form-control"
																	placeholder="CBU">
															</div>
																<div class="form-group">
														  <div class="col-12 text-center">
										                  	<a href="#!" class="btn btn-success" style="width: 120px;">Verificar</a>
										                </div>
													</div>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-4">
															<div class="form-group">
																<label class="form-control-label" for="input-city">Nombre</label>
																<input type="text" id="Nombre" class="form-control"
																	disabled="disabled"
																	>
															</div>
														</div>
														<div class="col-lg-4">
															<div class="form-group">
																<label class="form-control-label" for="input-country">Apellido
																	</label> <input type="text" id="Apellido"
																	class="form-control" 
																	disabled="disabled">
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
										                  	<a href="#!" class="btn btn-sm btn-primary" style="width: 250px;">Transferir</a>
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
