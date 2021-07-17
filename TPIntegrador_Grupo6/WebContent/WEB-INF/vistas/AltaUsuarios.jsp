<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="frgp.utn.edu.ar.entidad.Persona"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="Header.jsp"></jsp:include>
</head>

<script type="text/javascript">
	function ValidarDNI() {
		objeto = document.getElementById("dnitxt");
		Validar = document.getElementById("btnCrear");
		valueForm = objeto.value;
		if (valueForm.length > 8) {
			objeto.className = "form-control border border-danger";
			objeto.style.boxShadow = "0 0 0 0.2rem rgba(255, 0, 0, 0.23)";
			Validar.disabled = true;
		} else {
			objeto.className = "form-control border border-success";
			objeto.style.boxShadow = "0 0 0 0.2rem rgba(79, 162, 51, 0.25)";
			Validar.disabled = false;
		}
	}
</script>
</head>

<body>
	<%
		HttpSession misession = (HttpSession) request.getSession();

		Persona Persona = (Persona) misession.getAttribute("Usuario");
	%>
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
		<jsp:include page="NavegacionAdmin.jsp"></jsp:include>
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
										<li class="breadcrumb-item"><a href="#">ABML</a></li>
										<c:choose>
											<c:when test="${esNuevoCliente==true}">
												<li class="breadcrumb-item active" aria-current="page">Alta
													de cliente</li>
											</c:when>
											<c:otherwise>
												<li class="breadcrumb-item active" aria-current="page">Modificacion
													de cliente</li>
											</c:otherwise>

										</c:choose>

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
															<c:choose>
																<c:when test="${esNuevoCliente==true}">
																	<li class="breadcrumb-item active" aria-current="page">Alta
																		de cliente</li>
																</c:when>
																<c:otherwise>
																	<li class="breadcrumb-item active" aria-current="page">Modificacion
																		de cliente</li>
																</c:otherwise>

															</c:choose>


														</div>
													</div>
												</div>
												<div class="card-body">
													<form>
														<c:forEach items="${listaPersona}" var="item">

															<h6 class="heading-small text-muted mb-4">Información
																de cliente</h6>
															<div class="pl-lg-4">
																<div class="row">
																	<div class="col-lg-6">
																		<label class="form-control-label" for="input-email">Email</label>
																		<input type="email" id="input-email"
																			class="form-control" placeholder="email"
																			name="txtEmail" value="${item.email}" required>
																	</div>
																	<div class="col-lg-6">
																		<label class="form-control-label"
																			for="input-last-name">DNI</label>
																		<c:choose>
																			<c:when test="${esNuevoCliente==true}">
																				<input type="text" id="dnitxt" class="form-control"
																					placeholder="DNI" onkeyup="ValidarDNI()"
																					name="txtDNI" value="${item.dni}" required
																					oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');">
																				<br />
																			</c:when>
																			<c:otherwise>
																				<input type="text" id="input-dni"
																					class="form-control" placeholder="DNI"
																					name="txtDNI" value="${item.dni}" required
																					readonly="readonly">
																			</c:otherwise>
																		</c:choose>

																	</div>
																</div>
																<br>
																<div class="row">
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label class="form-control-label"
																				for="input-first-name">Nombre</label> <input
																				type="text" id="input-first-name"
																				class="form-control" value="${item.nombre}"
																				name="txtNombre" placeholder="nombre" required>

																		</div>
																	</div>
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label class="form-control-label"
																				for="input-last-name">Apellido</label> <input
																				type="text" id="input-last-name"
																				class="form-control" value="${item.apellido}"
																				name="txtApellido" placeholder="apellido" required>

																		</div>
																	</div>
																</div>
																<div class="row">
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label class="form-control-label" for="input-address">Provincia</label>
																			<select class="form-control" name="provincia"
																				required>
																				<option selected="true">Buenos Aires</option>
																				<c:forEach items="${listaProvincias}"
																					var="provincia">
																					<option>${provincia.provincia}</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label class="form-control-label"
																				for="input-last-name">Localidad</label> <input
																				type="text" id="input-last-name"
																				class="form-control" value="${item.localidad}"
																				name="localidad" placeholder="localidad" required>
																		</div>
																	</div>
																</div>
																<div class="row">
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label class="form-control-label"
																				for="input-last-name">Direccion</label> <input
																				type="text" id="input-last-name"
																				class="form-control" value="${item.direccion}"
																				name="direccion" placeholder="direccion" required>
																		</div>
																	</div>
																	<div class="col-lg-6">
																		<div class="form-group">
																			<label class="form-control-label" for="input-address">Sexo</label>
																			<select class="form-control" required name="sexo">
																				<option selected="true">Masculino</option>
																				<c:forEach items="${listaSexo}" var="item">
																					<option value="${item.sexo}">${item.sexo}</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="row"></div>
															</div>
															<!-- Address -->
															<hr class="my-12" />
															<div class="form-group">
																<div class="col-12 text-center">
																	<c:choose>
																		<c:when test="${mensaje.numeroMensaje == 1}">
																			<div class="alert alert-success" role="alert">
																				${mensaje.mensaje}</div>
																		</c:when>
																		<c:when test="${mensaje.numeroMensaje == 2}">
																			<div class="alert alert-success" role="alert">
																				${mensaje.mensaje}</div>
																		</c:when>
																		<c:when test="${mensaje.numeroMensaje == 3}">
																			<div class="alert alert-danger" role="alert">
																				${mensaje.mensaje}</div>
																		</c:when>
																	</c:choose>


																	<c:choose>
																		<c:when test="${esNuevoCliente==true}">
																			<input class="btn btn-sm btn-primary"
																				style="width: 250px;" type="submit" id="btnCrear"
																				value="Crear" name="btnCrear">
																			<br />
																		</c:when>
																		<c:otherwise>
																			<input class="btn btn-sm btn-primary"
																				style="width: 250px;" type="submit"
																				value="Modificar" name="btnModificar">
																			<br />
																		</c:otherwise>
																	</c:choose>
																</div>
															</div>
														</c:forEach>
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
	</form>
</body>

</html>
