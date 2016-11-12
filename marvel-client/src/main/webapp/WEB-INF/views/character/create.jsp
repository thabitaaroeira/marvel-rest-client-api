<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Personagem</title>
<link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<h2>Criar um novo Personagem</h2>
	<form action="/character/save" method="post">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>Nome</th>
					<td><input type="text" name="nome" required="required"></td>
				</tr>
				<tr>
					<th>Descrição</th>
					<td><input type="text" name="descricao" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Salvar"
						class="btn btn-success">
				</tr>
			</tbody>
		</table>
	</form>
	<a href="/character/index" class="btn btn-success">Back</a>

	<script type="application/javascript" src="js/jquery.js"></script>
	<script type="application/javascript" src="js/bootstrap.js"></script>


</body>
</html>