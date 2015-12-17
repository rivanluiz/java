<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NutriSeg | Sistema 1.0.0</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
	<div class="container">
		<form action="Login" method="post" class="form-signin">
			<h2 class="form-signin-heading">Efetue o login</h2>
			<label for="inputEmail" class="sr-only">Email</label> 
			<input type="email" id="inputEmail" class="form-control" 
				name="email" placeholder="E-mail" required autofocus> 
			
			<label for="inputPassword" class="sr-only">Senha</label> 
			<input type="password" id="inputPassword" class="form-control" 
				name="password" placeholder="Senha" required>
			
			<div class="checkbox">
				<label> 
					<input type="checkbox" value="remember-me"/>
					Lembrar-me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>	
			${msg } <a href="esqueci.jsp" class="btn btn-link">Esqueci a senha</a>
		</form>
	</div>
</body>
</html>