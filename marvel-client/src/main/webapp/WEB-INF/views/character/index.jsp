<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personagens</title>
<link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
</head>

<body>
	<h2>Lista de Personagens</h2>
	<table class="table table-bordered">
		<tr>
			<th>No</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Ação</th>
		</tr>
		<tbody>
			<c:forEach items="${characters}" var="character" varStatus="itr">
				<tr>
					<td>${itr.index+1}</td>
					<td>${character.name}</td>
					<td>${character.description}</td>
					<td><a href="/person/edit/${character.id}"
						class="btn btn-warning">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<a href="/character/create" class="btn btn-success">Criar
		Personagem</a>

	<script type="application/javascript" src="js/jquery.js"></script>
	<script type="application/javascript" src="js/bootstrap.js"></script>

</body>
</html>