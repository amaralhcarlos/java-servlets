package gerenciador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

/**
 * Servlet implementation class MostraEmpresa
 */
@WebServlet("/mostraEmpresa")
public class MostraEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		Integer idEmpresa;
		try {
			idEmpresa = new Integer(request.getParameter("id"));
		} catch (NumberFormatException e1) {
			throw new ServletException("Identificador não é válido");
		}

		Empresa empresa = banco.buscaEmpresa(idEmpresa);

		if (empresa == null) {
			throw new ServletException("Não foi encontrada nenhuma empresa com esse identificador.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/mostra-empresa.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);

	}

}
