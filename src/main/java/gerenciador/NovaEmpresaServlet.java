package gerenciador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");

		Banco banco = new Banco();

		String nomeEmpresa = request.getParameter("nomeEmpresa");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date dataAberturaEmpresa = null;
		
		try {
			dataAberturaEmpresa = sdf.parse(request.getParameter("dataAberturaEmpresa"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Data Inválida!");
		}

		Empresa empresa = new Empresa(banco.getEmpresas().size() + 1, nomeEmpresa, dataAberturaEmpresa);

		banco.adiciona(empresa);

		RequestDispatcher rd = request.getRequestDispatcher("/nova-empresa-cadastrada.jsp");
		request.setAttribute("nomeEmpresa", empresa.getNome());
		rd.forward(request, response);

	}

}
