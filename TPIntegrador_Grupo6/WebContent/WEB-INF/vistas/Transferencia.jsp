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
	<script>
		function ValidarDNI() {
			objeto = document.getElementById("CBU");
			Validar = document.getElementById("btnVerificar");
			valueForm = objeto.value;
			if (valueForm.length > 10) {
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
	<jsp:include page="NavegacionCliente.jsp"></jsp:include>
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
									<form action="TransferirDinero.html" method="post">
										<div class="pl-lg-4">
											<h6 class="heading-small text-muted mb-4">Informacion de
												cuenta destino</h6>
											<div class="pl-lg-4">
												<div class="row">
													<div class="col-md-12">

														<div class="form-group">
															<label class="form-control-label" for="input-address">CBU</label>
															<input type="text" id="CBU" class="form-control"
																placeholder="Ingrese el CBU" onkeyup="ValidarDNI()"
																name="CBU" value="${CuentaDestino.cbu}"
																oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1')"
																required>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-lg-4">
														<div class="form-group">
															<label class="form-control-label" for="input-city">Nombre</label>
															<input type="text" id="Nombre" name="Nombre"
																class="form-control" readonly
																value="${personaDestino.nombre}" required>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="form-group">
															<label class="form-control-label" for="input-country">Apellido
															</label> <input type="text" id="Apellido" name="Apellido"
																class="form-control" readonly
																value="${personaDestino.apellido}" required>
														</div>
													</div>
													<div class="col-lg-4">
														<div class="form-group">
															<label class="form-control-label" for="input-country">Alias</label>
															<input type="text" id="input-postal-code"
																class="form-control" readonly name="Alias"
																value="${CuentaDestino.alias}" required>
														</div>
													</div>
												</div>
											</div>
										</div>
										<br>
										<hr class="my-4" />

										<h6 class="heading-small text-muted mb-4">Elegi tu cuenta
											para hacer la transferencia</h6>
										<div class="row">

											<div class="col-lg-6">
												<div class="form-group">
													<label class="form-control-label" for="input-username">Cuenta</label>
													<select class="form-control" name="cuentas" id="idcuentas">
														<option value="0">Seleccione una cuenta</option>
														<c:forEach items="${listaCuenta}" var="item">
															<option value="${item.cbu}">${item.cbu}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-lg-6">
												<div class="form-group">
													<label class="form-control-label" for="input-email">Saldo
														disponible</label> <input type="number" id="Saldo" name="Saldo"
														disabled="disabled" class="form-control"
														value="${cuenta.saldo}">
												</div>
											</div>
											<div class="col-lg-6">
												<div class="form-group">
													<label class="form-control-label" for="input-email">Comentario</label>
													<input type="text" id="Saldo" name="Comentario"
														class="form-control" value="${Comentario}" required>
												</div>
											</div>
											<div class="col-lg-6">
												<div class="form-group">
													<label class="form-control-label" for="input-email">Saldo
														a transferir</label> <input type="number" id="Saldo"
														name="SaldoTransferir" class="form-control"
														value="${SaldoTransferir}"
														oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1')"
														required>
												</div>
											</div>
										</div>
										<br>
										<div class="col-12 text-center">
											<c:choose>
												<c:when test="${mensaje.numeroMensaje == 4}">
													<div class="alert alert-danger" role="alert">
														${mensaje.mensaje}</div>
												</c:when>
												<c:when test="${mensaje.numeroMensaje == 5}">
													<div class="alert alert-danger" role="alert">
														${mensaje.mensaje}</div>
												</c:when>
												<c:when test="${mensaje.numeroMensaje == 6}">
													<div class="alert alert-danger" role="alert">
														${mensaje.mensaje}</div>
												</c:when>
												<c:when test="${mensaje.numeroMensaje == 7}">
													<div class="alert alert-danger" role="alert">
														${mensaje.mensaje}</div>
												</c:when>
												<c:when test="${mensaje.numeroMensaje == 8}">
													<div class="alert alert-success" role="alert">
														${mensaje.mensaje}</div>
												</c:when>
											</c:choose>
										</div>
										<div class="col-12 text-center">
											<input type="submit" class="btn btn-success"
												id="btnVerificar" value="Verificar"
												formaction="buscarSaldo.html" style="width: 120px;">
										</div>
										<hr class="my-12" />
										<div class="form-group">
											<div class="col-12 text-center">
												<c:choose>
													<c:when
														test="${personaDestino.nombre == null || cuentas == 0}">

														<input type="submit" class="btn btn-sm btn-primary"
															style="width: 250px;" value="Transferir"
															disabled="disabled">
														<input type="hidden" value="${cuenta.cbu}"
															class="myButton" name="CBUOrigen" id="numeroCuenta">

													</c:when>
													<c:when
														test="${personaDestino.nombre != null && cuentas != 0}">
														<input type="submit" class="btn btn-sm btn-primary"
															style="width: 250px;" value="Transferir">
														<input type="hidden" value="${cuenta.cbu}"
															class="myButton" name="CBUOrigen" id="numeroCuenta">
													</c:when>
												</c:choose>
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
