package gerenciador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

/**
 * Servlet implementation class RemoveEmpresaServlet
 */
@WebServlet("/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		Integer idEmpresa;

		try {
			idEmpresa = new Integer(request.getParameter("id"));
		} catch (NumberFormatException e) {
			throw new ServletException("Identificador não é válido");
		}

		banco.removeEmpresa(idEmpresa);

		response.sendRedirect("listaEmpresasJSTL");

	}

}
