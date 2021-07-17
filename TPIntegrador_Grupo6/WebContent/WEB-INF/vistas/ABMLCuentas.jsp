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
									<li class="breadcrumb-item active" aria-current="page">Cuentas</li>
								</ol>
							</nav>
						</div>
						<div class="col-lg-6 col-5 text-right">
							<a href="RedireccionAltaDeCuenta.html"
								class="btn btn-sm btn-neutral">Nueva cuenta</a>
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
								<div class="card text-dark bg-light mb-3">
									<div class="card-header bg-transparent">
										<div class="row align-items-center">
											<div class="col-xl-12"></div>
											<div class="table-responsive">
												<table id="myTable" class="display table" width="100%">

													<thead class="thead-dark" id="example">
														<tr>
															<th scope="col" class="sort" data-sort="NumeroCuenta">DNI</th>
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
																<td>${item.dni}</td>
																<td>${item.nroCuenta}</td>
																<td>${item.tipoCuenta}</td>
																<td>${item.cbu}</td>
																<td>${item.alias}</td>
																<td><form method="post"
																		action="ModificarCuenta.html">
																		<input type=submit value="Modificar"
																			class="btn btn-sm btn-neutral" name="btnModificar"
																			id="Modificar"
																			OnClick="return confirm('Estas seguro de modificar la cuenta ${item.nroCuenta}, CBU ${item.cbu}?')">
																		<input type="hidden" value="${item.cbu}"
																			class="myButton" name="cbu" id="numeroCuenta">
																		<input type="hidden" value="${item.nroCuenta}"
																			class="myButton" name="numeroCuenta"
																			id="numeroCuenta"> <input type="hidden"
																			value="${item.tipoCuenta}" class="myButton"
																			name="tipoCuenta" id="numeroCuenta"> <input
																			type="hidden" value="${item.alias}" class="myButton"
																			name="alias" id="numeroCuenta">
																	</form></td>
																<td>
																	<form method="post" action="eliminacionCuenta.html">
																		<input type=submit value="Eliminar"
																			class="btn btn-sm btn-neutral" name="btnnumeroCuenta"
																			id="numeroCuenta"
																			OnClick="return confirm('Estas seguro de eliminar la cuenta ${item.nroCuenta}, CBU ${item.cbu}?')">
																		<input type="hidden" value="${item.cbu}"
																			class="myButton" name="numeroCuenta"
																			id="numeroCuenta">
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

</body>

</html>
