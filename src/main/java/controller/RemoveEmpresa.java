package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;

public class RemoveEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("remover empresa " + request.getParameter("id"));

		Banco banco = new Banco();
		Integer idEmpresa;

		try {
			idEmpresa = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			throw new ServletException("Identificador não é válido");
		}

		banco.removeEmpresa(idEmpresa);

		return "redirect:listaEmpresa";
	}

}
