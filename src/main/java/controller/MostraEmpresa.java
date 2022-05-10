package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		Integer idEmpresa;
		try {
			idEmpresa = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e1) {
			throw new ServletException("Identificador n�o � v�lido");
		}

		Empresa empresa = banco.buscaEmpresa(idEmpresa);

		if (empresa == null) {
			throw new ServletException("N�o foi encontrada nenhuma empresa com esse identificador.");
		}

		request.setAttribute("empresa", empresa);

		return "forward:mostra-empresa.jsp";

	}

}
