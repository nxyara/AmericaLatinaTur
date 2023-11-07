package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.findClient(id);
			
			request.setAttribute("usuario", usuario);
			
			RequestDispatcher rd = request.getRequestDispatcher("Atualizar.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
			
		}


	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(Integer.parseInt(request.getParameter("id")));
			usuario.setNomeUsuario(request.getParameter("nome"));
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setDataNasc(LocalDate.parse(request.getParameter("dataNasc")));
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.updateUsuario(usuario);
			
			Usuario usuarioAtualizado = usuarioDAO.findClient(usuario.getIdUsuario());
			request.setAttribute("usuario", usuarioAtualizado);
			
			RequestDispatcher rd = request.getRequestDispatcher("Atualizar.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
