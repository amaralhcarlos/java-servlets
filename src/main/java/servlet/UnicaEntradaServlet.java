package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

		String redirecionamento = null;

		if (url.equals("/gerenciador/listaEmpresas")) {
			ListaEmpresa acao = new ListaEmpresa();
			redirecionamento = acao.executa(request, response);
		}

		else if (url.equals("/gerenciador/removeEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			redirecionamento = acao.executa(request, response);
		}

		else if (url.equals("/gerenciador/mostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			redirecionamento = acao.executa(request, response);
		}

		else if (url.equals("/gerenciador/novaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			redirecionamento = acao.executa(request, response);
		}

		else if (url.equals("/gerenciador/editaEmpresa")) {
			EditaEmpresa acao = new EditaEmpresa();
			redirecionamento = acao.executa(request, response);
		}

		String[] tipoEEndereco = redirecionamento.split(":");

		if (tipoEEndereco[0].equals("forward")) {

			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
			rd.forward(request, response);

		} else {

			response.sendRedirect(tipoEEndereco[1]);

		}
	}

}
