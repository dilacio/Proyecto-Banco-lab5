<%@page import="frgp.utn.edu.ar.entidad.Persona"%>
<%
	HttpSession misession = (HttpSession) request.getSession();

	Persona Persona = (Persona) misession.getAttribute("Usuario");
%>
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
				<hr class="my-3">
			</div>
		</div>
	</div>
</nav>