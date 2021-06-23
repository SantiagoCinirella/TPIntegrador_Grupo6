<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Style -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/css/fresh-bootstrap-table.css" rel="stylesheet" />

<!-- Fonts and icons -->
<link href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,700,300"
	rel="stylesheet" type="text/css">


<!-- Javascript -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table/dist/bootstrap-table.min.js"></script>

<style>
/* Dropdown Button */
.dropbtn {
	background-color: #3498DB;
	color: white;
	padding: 10px;
	font-size: 12px;
	border: none;
	cursor: pointer;
	width: 1172px;
	height: 40px;
}

/* Dropdown button on hover & focus */
.dropbtn:hover, .dropbtn:focus {
	background-color: #2980B9;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	width: 1172px;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #ddd
}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {
	display: block;
}
</style>
<script type="text/javascript">
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
<title>Insert title here</title>
</head>
<body>

	<div class="container" style="background-color: grey">

		<div class="navbar-header">
			<button data-target=".navbar-collapse" data-toggle="collapse"
				class="navbar-toggle" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class=""><a style="color: white;"><span
						class="glyphicon glyphicon-home" style="color: white;"></span>
						Principal</a></li>

				<li class="dropdown"><a href="" data-toggle="dropdown"
					style="color: white;"><span
						class="glyphicon glyphicon-list-alt" style="color: white;"></span>
						Cursos</a><b class="caret"></b>
					<ul class="dropdown-menu">
						<li><a href="servletAltaCursos"><i style="color: white;"
								class="glyphicon glyphicon-list-alt"></i> Alta de cursos</a></li>

					</ul></li>

				<li class="nav-item"><a href="servletPersonas"
					style="color: white;"><span class="glyphicon glyphicon-user"
						style="color: white;"></span> Personas</a></li>
				<li class="nav-item"><a href="AdministradorReporte.jsp"
					style="color: white;"><span class="glyphicon glyphicon-book"
						style="color: white;"></span> Reportes</a></li>
				<li class="nav-item"><a href="servletUsuarios"
					style="color: white;"><span class="glyphicon glyphicon-refresh"
						style="color: white;"></span> Cambiar usuarios/contraseńas</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="" data-toggle="dropdown"
					class="dropdown-toggle" style="color: white;"> <span></span> <small>Bienvenido,</small>
						<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="index.jsp"><i
								class="glyphicon glyphicon-off"></i> Cerrar sesion</a></li>
					</ul></li>
			</ul>
		</div>
	</div>

	<div class="wrapper">
		<div class="container">
			<hr>
			<div class="row">
				<div class="description">
					<label style="font-size: 22px; align-content: center;">Seleccione
						una cuenta</label> <br>

				</div>
			</div>

			<div class="row">
				<div class="dropdown">
					<button onclick="myFunction()" class="dropbtn">Cuentas</button>
					<div id="myDropdown" class="dropdown-content">
						<a href="#">1122334455667788</a> <a href="#">8877665544332211</a>
						<a href="#">9999888877776666</a>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="description">
					<label style="font-size: 22px;">Historial de cuenta </label>
				</div>

				<div class="fresh-table full-color-blue">

					<table id="fresh-table" class="table">
						<thead>

							<th data-field="Nro" data-sortable="true">Fecha</th>
							<th data-field="Tipo" data-sortable="true">Descripcion</th>
							<th data-field="Saldo" data-sortable="true">Monto</th>
							<th data-field="actions" data-formatter="operateFormatter"
								data-events="operateEvents">Actions</th>
						</thead>
						<tbody>
							<tr>
								<td>15/12/2020</td>
								<td>Tienda Mia</td>
								<td>- $36.738</td>
								<td></td>
							</tr>
							<tr>
								<td>14/12/2020</td>
								<td>Pacheco Express</td>
								<td>-$2.300</td>
								<td></td>
							</tr>
							<tr>
								<td>13/12/2020</td>
								<td>Deposito de haberes</td>
								<td>$56.000</td>
								<td></td>
							</tr>
							<tr>
								<td>12/12/2020</td>
								<td>Spotify s.a</td>
								<td>-$735</td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>


			</div>
		</div>
	</div>

</body>

<script type="text/javascript">
	var $table = $('#fresh-table')

	window.operateEvents = {
		'click .like' : function(e, value, row, index) {
			alert('You click like icon, row: ' + JSON.stringify(row))
			console.log(value, row, index)
		},
		'click .edit' : function(e, value, row, index) {
			alert('You click edit icon, row: ' + JSON.stringify(row))
			console.log(value, row, index)
		},
		'click .remove' : function(e, value, row, index) {
			$table.bootstrapTable('remove', {
				field : 'id',
				values : [ row.id ]
			})
		}
	}

	function operateFormatter(value, row, index) {
		return [
				'<a rel="tooltip" title="Edit" class="table-action edit" href="javascript:void(0)" title="Edit">',
				'<i class="fa fa-edit"></i>', '</a>' ].join('')
	}

	$(function() {
		$table.bootstrapTable({
			classes : 'table table-hover table-striped',
			toolbar : '.toolbar',

			search : true,
			showRefresh : true,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			pageSize : 8,
			pageList : [ 8, 10, 25, 50, 100 ],

			formatShowingRows : function(pageFrom, pageTo, totalRows) {
				return ''
			},
			formatRecordsPerPage : function(pageNumber) {
				return pageNumber + ' Registros visibles'
			}
		})

	})
</script>
</html>