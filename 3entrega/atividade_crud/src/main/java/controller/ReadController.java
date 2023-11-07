package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/ReadController")
public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			List<Usuario> clients = usuarioDAO.findClients();
			request.setAttribute("clients", clients);

			RequestDispatcher rd = request.getRequestDispatcher("Usuarios.jsp");
			rd.forward(request, response);
		
			response.sendRedirect("Usuarios.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}