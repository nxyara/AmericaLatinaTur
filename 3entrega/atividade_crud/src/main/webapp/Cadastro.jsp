<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>

<link rel="icon" type="image/x-icon" href="./icon/favicon.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
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
                            <a class="nav-link" href="index.html">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Cadastro.jsp">Cadastros</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Sobre</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<h1 class="mt-5" >Cadastro de Usuario </h1>
				<form class="mt-5" action="CreateController" method="post">
					<div class="form-group">
						<label for="nome">Nome:</label> <input type="text"
							class="form-control" id="nome" name="nome" required>
					</div>
					<div class="form-group">
						<label for="login">Login:</label> <input type="text"
							class="form-control" id="login" name="login" required>
					</div>
					<div class="form-group">
						<label for="senha">Senha:</label> <input type="password"
							class="form-control" id="senha" name="senha" required>
					</div>
					<div class="form-group">
						<label for="dataNascimento">Data de Nascimento:</label> <input
							type="date" class="form-control" id="dataNasc"
							name="dataNasc" required>
					</div>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form>
			</div>
		</div>
	</div>


    <footer class=" text-light text-center py-3 fixed-bottom" style="background-color: #4d3024;">
        &copy; 2023 Sua Empresa. Todos os direitos reservados.
    </footer>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>