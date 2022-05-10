package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

public class MostraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("mostrar empresa " + request.getParameter("id"));

		Banco banco = new Banco();
		Integer idEmpresa;
		try {
			idEmpresa = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e1) {
			throw new ServletException("Identificador não é válido");
		}

		Empresa empresa = banco.buscaEmpresa(idEmpresa);

		if (empresa == null) {
			throw new ServletException("Não foi encontrada nenhuma empresa com esse identificador.");
		}

		request.setAttribute("empresa", empresa);

		return "forward:/mostra-empresa.jsp";

	}

}
