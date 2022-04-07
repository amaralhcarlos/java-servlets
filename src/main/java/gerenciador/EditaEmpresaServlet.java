package gerenciador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

/**
 * Servlet implementation class EditaEmpresa
 */
@WebServlet("/editaEmpresa")
public class EditaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		Integer idEmpresa;

		try {
			idEmpresa = new Integer(request.getParameter("id"));
		} catch (NumberFormatException e) {
			throw new ServletException("Identificador n�o � v�lido");
		}

		Empresa empresa = banco.buscaEmpresa(idEmpresa);
		
		if (empresa == null) {

			throw new ServletException("Nenhuma empresa com o id " + idEmpresa + " foi localizada.");

		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataAberturaEmpresa = null;

		try {
			dataAberturaEmpresa = sdf.parse(request.getParameter("dataAberturaEmpresa"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Data Inv�lida!");
		}

		empresa.setNome(request.getParameter("nomeEmpresa"));
		empresa.setDataAbertura(dataAberturaEmpresa);

		response.sendRedirect("listaEmpresasJSTL");

	}
}
