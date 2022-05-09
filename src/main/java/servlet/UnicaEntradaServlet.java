package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.EditaEmpresa;
import controller.ListaEmpresa;
import controller.MostraEmpresa;
import controller.NovaEmpresa;
import controller.RemoveEmpresa;

@WebServlet("/")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();


		if (url.equals("/gerenciador/listaEmpresas")) {
			ListaEmpresa acao = new ListaEmpresa();
			acao.executa(request, response);
		}

		else if (url.equals("/gerenciador/removeEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			acao.executa(request, response);
		}

		else if (url.equals("/gerenciador/mostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);
		}

		else if (url.equals("/gerenciador/novaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			acao.executa(request, response);
		}

		else if (url.equals("/gerenciador/editaEmpresa")) {
			EditaEmpresa acao = new EditaEmpresa();
			acao.executa(request, response);
		}
	}

}
