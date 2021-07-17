<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>

<script type="text/javascript">
	function alertName() {
		alert("Error al iniciar sesion");
	}
</script>

<link rel="apple-touch-icon" type="image/png"
	href="https://cpwebassets.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png">
<meta name="apple-mobile-web-app-title" content="CodePen">


<link rel="mask-icon" type=""
	href="https://cpwebassets.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg"
	color="#111">

<title>Banco UTN-FRGP</title>
<link href="https://fonts.googleapis.com/css?family=Asap"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="css/styleLogin.css">
</head>

<body
	background="https://images.pexels.com/photos/259200/pexels-photo-259200.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260">
<body translate="no">
	<form class="login" method="post" action="altaDeUsuarios.html">
		<input type="text" placeholder="Usuario" name="txtUsuario" required>
		<input type="password" placeholder="Contraseña" name="txtPassword"
			required> <input type="submit" value="Login" name="btnLogin">
	</form>
	<c:choose>
		<c:when test="${verificarUsuario==false}">
       <script type="text/javascript"> window.onload = alertName; </script>
        <br />
		</c:when>
	</c:choose>
</body>
</html>
