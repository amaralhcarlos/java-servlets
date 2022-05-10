package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Acao;

@WebServlet("/")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();

		String redirecionamento = null;

		String[] acoes = url.split("/");

		String acaoSelecionada = "controller." + acoes[2].substring(0, 1).toUpperCase() + acoes[2].substring(1);

		try {
			Class classe = Class.forName(acaoSelecionada);
			Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
			redirecionamento = acao.executa(request, response);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		String[] tipoEEndereco = redirecionamento.split(":");

		if (tipoEEndereco[0].equals("forward")) {

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);

		} else {

			response.sendRedirect(tipoEEndereco[1]);

		}
	}

}
