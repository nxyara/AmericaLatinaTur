package controller;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import database.databaseConnection;
import model.Usuario;


@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		

		usuario.setNomeUsuario(request.getParameter("nome"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setDataNasc(LocalDate.parse(request.getParameter("dataNasc")));

		
		try {
			Connection connection = databaseConnection.createConnection();
			UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
			usuarioDAO.createUsuario(usuario);
			
			response.sendRedirect("ReadController");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
