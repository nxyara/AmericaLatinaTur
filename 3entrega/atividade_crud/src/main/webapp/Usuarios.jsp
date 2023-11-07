<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuarios</title>

<link rel="icon" type="image/x-icon" href="./icon/favicon.ico">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="text-center">
    <!-- Cabeçalho -->
    <header>
        <nav class="navbar navbar-expand-lg navbar-light  bg-light text-dark">
            <div class="container">
                <a class="navbar-brand" href="index.html"><img src="./icon/logo.png" height="48px"/> </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="./index.html">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./Cadastro.jsp">Cadastros</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#sobre">Sobre</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contato">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
	<h1 class="mt-5">Lista de Usuarios</h1>
	<div class="container mt-5">
	<a href="./Cadastro.jsp" class="btn btn-primary mb-5">Criar novo</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Login</th>
					<th>Senha</th>
					<th>Data de Nascimento</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clients}" var="usuario">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.login}</td>
						<td>${usuario.senha}</td>
						<td>${usuario.dataNasc}</td>
						<td>
							<a href="UpdateController?id=${usuario.id}" class="btn btn-success">Editar</a>
							<a href="DeleteController?id=${usuario.id}"	class="btn btn-danger">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

    <footer class="text-light text-center py-3 fixed-bottom" style="background-color: #4d3024;">
        &copy; 2023 Sua Empresa. Todos os direitos reservados.
    </footer>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>