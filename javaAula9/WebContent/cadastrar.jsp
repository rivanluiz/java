<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
<script type="text/javascript">
	function validarFormulario() {
		var nome = document.getElementById("nome").value;
		var preco = document.getElementById("preco").value;
		var quantidade = document.getElementById("quantidade").value;
		var dataCompra = document.getElementById("dataCompra").value;
		
		try{
			
			if (!nome.match(/^[A-Za-z0-9\s]{6,50}$/)){
				throw("Erro. Nome Inválido");
			}else if (! preco.match(/^[0-9.,]{1,10}$/)){
				throw("Erro. Preco Inválido");
			}else if (! quantidade.match(/^[0-9.,]{1,6}$/)){
				throw("Erro. Quantidade Inválido");
			}else if (! dataCompra.match(/^[0-9-]{10}$/)){
				throw("Erro. Data Inválida");
			}
			
		} catch(e){
			alert(e);
			return false;
		}
	}
</script>
</head>
<body class="container">
<h3>Cadastro de Produtos</h3>
<a href="index.jsp">Voltar</a>
<hr>
<div class="row">
	<div class="col-md-5">
		<p>
			Informe os dados do produto:
		</p>
		<form action="ControleProduto?cmd=gravar" method="post" name="form1" onsubmit="return validarFormulario()">
			<label>Nome do produto:</label><br>
			<input type="text" id="nome" name="nome"><br><br>
			<label>Preço:</label><br>
			<input type="text" id="preco" name="preco"><br><br>
			<label>Quantidade:</label><br>
			<input type="number" id="quantidade" name="quantidade"><br><br>
			<label>Data de Compra:</label><br>
			<input type="date" id="dataCompra" name="dataCompra"><br><br>
			<input type="submit" value="Cadastrar">
			<h4>${msg }</h4>
		</form>
	</div>
	<div class="col-md-7">
	</div>
</div>
</body>
</html>