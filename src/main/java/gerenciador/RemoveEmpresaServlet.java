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

		Empresa empresa = banco.getEmpresas().stream().filter(e -> idEmpresa.equals(e.getId())).findAny().orElse(null);

		if (empresa == null) {

			throw new ServletException("Nenhuma empresa com o id " + idEmpresa + " foi localizada.");

		}

		System.out.println(empresa);

		banco.getEmpresas().remove(empresa);

		response.sendRedirect("listaEmpresasJSTL");

	}

}
