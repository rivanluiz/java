<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- /aula08/bootstrap/css/bootstrap.min.css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
</head>
<body>



  <!--   <nav class="navbar navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div>/.nav-collapse
      </div>
    </nav>
 -->

	<div class="container">
		<nav class="navbar navbar-fixed-top">
			<a class="navbar-brand" href="#">Project name</a>
			<div class="col-xs-12">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp">Cadastrar Produto</a></li>
					<li><a href="buscar.jsp">Buscar Produto</a></li>
					<li><a href="sair.htm">Sair</a></li>
				</ul>
			</div>
		</nav>
		<div class="col-xs-12">
			<p class="text-right">
				Seja bem vindo ao sistema, ${nome }
			</p>
		</div>
		
		<div class="col-xs-12">
		