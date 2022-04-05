package gerenciador;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ListaEmpresas
 */
@WebServlet("/listaEmpresasJSTL")
public class ListaEmpresasJSTLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		RequestDispatcher rd = request.getRequestDispatcher("/lista-empresa-jstl.jsp");
		request.setAttribute("empresas", empresas);
		rd.forward(request, response);

	}

}
