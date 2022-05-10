package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

public class ListaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Empresa> empresas = banco.getEmpresas();
		request.setAttribute("empresas", empresas);

		return "forward:/lista-empresa.jsp";

	}

}
