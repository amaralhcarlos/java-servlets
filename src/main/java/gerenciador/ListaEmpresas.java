package gerenciador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresas
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();

		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Cadastrar nova empresa</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");

		if (banco.getEmpresas().size() > 0) {

			out.println("<H3>Empresas Cadastradas</H3>");
			out.println("<TABLE>");
			out.println("<TR><TH>ID</TH><TH>Nome da Empresa</TH></TR>");

			empresas.forEach(empresa -> out
					.println("<TR><TD>" + empresa.getId() + " </TD><TD> " + empresa.getNome() + " </TD></TR>"));

			out.println("</TABLE>");

		} else {
			out.println("<H2>Não existem empresas cadastradas nesse momento.</H2>");
		}
		
		
		out.println("</BODY>");
		out.println("</HTML>");

	}

}
