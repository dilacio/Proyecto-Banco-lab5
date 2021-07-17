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
	<jsp:include page="NavegacionAdmin.jsp"></jsp:include>
	<!-- Main content -->
	<div class="main-content" id="panel">
		<!-- Topnav -->
		<jsp:include page="Sesion.jsp"></jsp:include>
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
									<li class="breadcrumb-item active" aria-current="page">
										Modificacion de cuenta</li>
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
						<div class="card-body">
							<div class="row icon-examples">

								<div class="col-xl-8 order-xl-1">
									<div class="card">
										<div class="card-header">
											<div class="row align-items-center">
												<div class="col-8">
													<h3 class="mb-0">Modificacion de cuenta</h3>
												</div>
											</div>
										</div>
										<div class="card-body">
											<form action="ModificarCuenta_AltaDecuenta.html"
												method="post">
												<h6 class="heading-small text-muted mb-4">Informacion
													de cuenta</h6>
												<div class="pl-lg-4">
													<div class="row">
														<div class="col-md-12">
															<div class="form-group">
																<label class="form-control-label" for="input-city">Tipo
																	de Cuenta</label> <input type="text" name="tipoCuenta"
																	class="form-control" placeholder="CBU"
																	readonly="readonly"
																	value="${CuentaModificar.tipoCuenta}">
															</div>
														</div>
													</div>
													<div class="row">
														<div class="col-lg-4">
															<div class="form-group">
																<label class="form-control-label" for="input-city">CBU</label>
																<input type="text" name="cbu" class="form-control"
																	placeholder="CBU" readonly="readonly"
																	value="${CuentaModificar.cbu}">
															</div>
														</div>
														<div class="col-lg-4">
															<div class="form-group">
																<label class="form-control-label" for="input-country">Nro
																	de cuenta</label> <input type="text" name="numeroCuenta"
																	class="form-control" placeholder="11111"
																	readonly="readonly"
																	value="${CuentaModificar.nroCuenta}">
															</div>
														</div>
														<div class="col-lg-4">
															<div class="form-group">
																<label class="form-control-label" for="input-country">Alias</label>
																<input type="text" name="alias" required="required"
																	class="form-control" value="${CuentaModificar.alias}"
																	placehlder="Alias">
															</div>
														</div>
													</div>
												</div>
												<hr class="my-12" />
												<div class="form-group">
													<div class="col-12 text-center">
														<c:choose>
															<c:when test="${MensajeBack.numeroMensaje == 14}">
																<div class="alert alert-success" role="alert">
																	${MensajeBack.mensaje}</div>
															</c:when>
															<c:when test="${MensajeBack.numeroMensaje == 15}">
																<div class="alert alert-danger" role="alert">
																	${MensajeBack.mensaje}</div>
															</c:when>

														</c:choose>
														<input type="submit" name="btnAgregarPersona"
															class="btn btn-sm btn-primary" value="Modificar"
															style="width: 70%;">

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
