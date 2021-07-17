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
									<li class="breadcrumb-item active" aria-current="page">Clientes</li>
								</ol>
							</nav>
						</div>
						<div class="col-lg-6 col-5 text-right">
							<a href="RedireccionNuevoCliente.html"
								class="btn btn-sm btn-neutral">Nuevo cliente</a>
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
							<h3 class="mb-0">Clientes</h3>
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
															<th scope="col" class="sort" data-sort="DNI">DNI</th>
															<th scope="col" class="sort" data-sort="Apellido">Apellido</th>
															<th scope="col" class="sort" data-sort="Nombre">Nombre</th>
															<th scope="col" class="sort" data-sort="Nombre">Email</th>
															<th scope="col" class="sort" data-sort="Modificar">Modificar</th>
															<th scope="col" class="sort" data-sort="Eliminar">Eliminar</th>
														</tr>
													</thead>
													<tbody class="list">
														<c:forEach items="${listaPersona}" var="item">
															<tr>
																<td>${item.dni}</td>
																<td>${item.apellido}</td>
																<td>${item.nombre}</td>
																<td>${item.email}</td>

																<td>
																	<form method="post" action="ModificarCliente.html">
																		<input type=submit value="Modificar"
																			class="btn btn-sm btn-neutral" name="btndni" id="dni"
																			OnClick="return confirm('Estas seguro de modificar a ${item.apellido}, ${item.nombre}?')">
																		<input type="hidden" value="${item.dni}"
																			class="myButton" name="dni" id="dni"> <input
																			type="hidden" value="${item.apellido}"
																			class="myButton" name="apellido" id="dni"><input
																			type="hidden" value="${item.nombre}" class="myButton"
																			name="nombre" id="dni"> <input type="hidden"
																			value="${item.email}" class="myButton" name="email"
																			id="dni"> <input type="hidden"
																			value="${item.provincia}" class="myButton"
																			name="provincia" id="provincia"> <input
																			type="hidden" value="${item.localidad}"
																			class="myButton" name="localidad" id="localidad">

																		<input type="hidden" value="${item.direccion}"
																			class="myButton" name="direccion" id="direccion">

																		<input type="hidden" value="${item.sexo}"
																			class="myButton" name="sexo" id="sexo">
																	</form>
																</td>


																<td>
																	<form method="post" action="eliminacion.html">
																		<input type=submit value="Eliminar"
																			class="btn btn-sm btn-neutral" name="btndni" id="dni"
																			OnClick="return confirm('Estas seguro de eliminar a ${item.apellido}, ${item.nombre}?')">
																		<input type="hidden" value="${item.dni}"
																			class="myButton" name="dni" id="dni">
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