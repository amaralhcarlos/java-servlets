package gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		banco.adiciona(new Empresa(banco.getEmpresas().size() + 1, nomeEmpresa));

		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Cadastrar nova empresa</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<P>Cadastro da empresa " + nomeEmpresa + " efetuado com sucesso</P>");

		out.println("<H3>Empresas Cadastradas</H3>");
		out.println("<TABLE>");

		out.println("<TR>");
		out.println("<TH>ID</TH>");
		out.println("<TH>Nome da Empresa</TH>");
		out.println("</TR>");

		if (banco.getEmpresas().size() > 0) {

			banco.getEmpresas().forEach(empresa -> out
					.println("<TR><TD>" + empresa.getId() + " </TD><TD> " + empresa.getNome() + " </TD></TR>"));

		}

		out.println("</TABLE>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

}