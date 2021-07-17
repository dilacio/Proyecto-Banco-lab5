<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="frgp.utn.edu.ar.entidad.Persona"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav
	class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
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
			<%
				HttpSession misession = (HttpSession) request.getSession();

				Persona Persona = (Persona) misession.getAttribute("Usuario");
			%>
			<ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
				<li class="nav-item dropdown"><a class="nav-link pr-0"
					role="buttondata-toggle=" dropdown" aria-haspopup="true"
					aria-expanded="false">
						<div class="media align-items-center">
							<span class="avatar avatar-sm rounded-circle"> <img
								alt="Image placeholder" src="assets/img/theme/team-1.jpg">
							</span>
							<div class="media-body  ml-2  d-none d-lg-block">
								<span class="mb-0 text-sm  font-weight-bold"><%=Persona.getNombre()%>,
									<%=Persona.getApellido()%></span>
							</div>

						</div>
				</a></li>
				<div>
					<a href="index.html"><img src="https://img.icons8.com/ios-filled/50/ffffff/exit-sign.png"/></a>
				</div>
			</ul>
		</div>
	</div>
</nav>