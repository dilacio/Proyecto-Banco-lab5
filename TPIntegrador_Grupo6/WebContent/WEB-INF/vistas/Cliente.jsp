<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="frgp.utn.edu.ar.entidad.Persona"%>
<%@page import="frgp.utn.edu.ar.entidad.Cuenta"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="Header.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="NavegacionCliente.jsp"></jsp:include>
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
									<li class="breadcrumb-item"><a href="#">Cuentas</a></li>
								</ol>
							</nav>
						</div>
						<div class="col-lg-6 col-5 text-right">
							<a href="Transferencia.html" class="btn btn-sm btn-neutral">Nueva
								transferencia</a>
						</div>
					</div>
					<div>
						<c:choose>
							<c:when test="${mensaje.numeroMensaje == 16}">
								<div class="alert alert-danger" role="alert">
									${mensaje.mensaje}</div>
							</c:when>
						</c:choose>
					</div>
					<!-- Card stats -->
					<div class="row">
						<c:forEach items="${listaCuenta}" var="item">

							<div class="col-xl-3 col-md-6">
								<div class="card card-stats">
									<!-- Card body -->
									<div class="card-body">
										<div class="row">
											<div class="col">
												<h5 class="card-title text-uppercase text-muted mb-0">${item.tipoCuenta}</h5>
												<span class="h4 font-weight-bold mb-0">CBU:
													${item.cbu}</span> <br> <span
													class="h4 font-weight-bold mb-0">Nro:
													${item.nroCuenta}</span> <br> <span
													class="h2 font-weight-bold mb-0">$${item.saldo}</span>
											</div>
											<div class="col-auto">
												<div
													class="icon icon-shape bg-gradient-blue text-white rounded-circle shadow">
													<i class="ni ni-chart-pie-35"></i>
												</div>
											</div>
										</div>
										<p class="mt-3 mb-0 text-sm">
											<span class="text-success mr-2"><i
												class="fa fa-arrow-up"></i> 3.48%</span> <span class="text-nowrap">Desde
												el mes anterior</span>
										</p>
										<form method="post" action="Movimientos.html">
											<input type=submit value="Ver historial"
												class="btn btn-sm btn-neutral" name="btnnumeroCuenta"
												id="numeroCuenta"
												OnClick="return confirm('Estas seguro de ver los movimientos del CBU ${item.cbu}?')">
											<input type="hidden" value="${item.cbu}" class="myButton"
												name="cbu" id="numeroCuenta">
										</form>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
		<!-- Page content -->
		<div class="container-fluid mt--6">
			<div class="row">
				<div class="col-xl-8">
					<div class="card bg-default">
						<div class="card-header bg-transparent">
							<div class="row align-items-center">
								<div class="col">
									<h6 class="text-light text-uppercase ls-1 mb-1">Informacion
										general</h6>
									<h5 class="h3 text-white mb-0">Ingresos de todas las
										cuentas</h5>
								</div>
								<div class="col">
									<ul class="nav nav-pills justify-content-end">
										<li class="nav-item mr-2 mr-md-0" data-toggle="chart"
											data-target="#chart-sales-dark"
											data-update='{"data":{"datasets":[{"data":[0, 20, 10, 30, 15, 40, 20, 60, 60]}]}}'
											data-prefix="$" data-suffix="k"><a href="#"
											class="nav-link py-2 px-3 active" data-toggle="tab"> <span
												class="d-none d-md-block">Mes</span> <span class="d-md-none">M</span>
										</a></li>
										<li class="nav-item" data-toggle="chart"
											data-target="#chart-sales-dark"
											data-update='{"data":{"datasets":[{"data":[0, 20, 5, 25, 10, 30, 15, 40, 40]}]}}'
											data-prefix="$" data-suffix="k"><a href="#"
											class="nav-link py-2 px-3" data-toggle="tab"> <span
												class="d-none d-md-block">Semana</span> <span
												class="d-md-none">W</span>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="card-body">
							<!-- Chart -->
							<div class="chart">
								<!-- Chart wrapper -->
								<canvas id="chart-sales-dark" class="chart-canvas"></canvas>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-4">
					<div class="card">
						<div class="card-header bg-transparent">
							<div class="row align-items-center">
								<div class="col">
									<h6 class="text-uppercase text-muted ls-1 mb-1">Performance</h6>
									<h5 class="h3 mb-0">Ingresos</h5>
								</div>
							</div>
						</div>
						<div class="card-body">
							<!-- Chart -->
							<div class="chart">
								<canvas id="chart-bars" class="chart-canvas"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Footer -->
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
