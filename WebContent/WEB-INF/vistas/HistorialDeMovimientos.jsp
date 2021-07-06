<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="frgp.utn.edu.ar.entidad.Persona"%>

<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="Header.jsp"></jsp:include>
</head>

<body>
	<%
		HttpSession misession = (HttpSession) request.getSession();

		Persona Persona = (Persona) misession.getAttribute("Usuario");
	%>

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
						<li class="nav-item">
							<center>
								<form method="post" action="homeCliente.html">
									<i class="ni ni-tv-2 text-primary"></i> <input type=submit
										value="Cuentas" class="btn btn-primary btn-sm" name="btn"
										id="btn"> <input type="hidden"
										value="<%=Persona.getDni()%>" class="myButton" name="Usuario"
										id="Usuario">
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
		<jsp:include page="Sesion.jsp"></jsp:include>
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
									<li class="breadcrumb-item"><a href="#">Historial</a></li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid mt--6">
			<div class="row justify-content-center">
				<div class=" col ">
					<div class="card">
						<div class="card-header bg-transparent">
							<h3 class="mb-0">Movimientos de cuenta</h3>

							<br>
							<div class="row">
								<div class="col-xl-12">
									<div class="card text-dark bg-light mb-3">
										<div class="card-header bg-transparent">
											<div class="row align-items-center">
												<div class="col-xl-12"></div>
												<div class="table-responsive">
													<table id="myTable" class="display table" width="100%">

														<thead class="thead-dark" id="example">
															<tr>
																<th scope="col" class="sort" data-sort="name">Fecha</th>
																<th scope="col" class="sort" data-sort="budget">Descripcion</th>
																<th scope="col" class="sort" data-sort="status">Monto</th>
															</tr>
														</thead>
														<tbody class="list">
															<c:forEach items="${listaMovimientos}" var="item">

																<tr>
																	<td>${item.fecha}</td>
																	<td>${item.detalle}</td>
																	<td>${item.saldo}</td>

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
	</div>
</body>

</html>
