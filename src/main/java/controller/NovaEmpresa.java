package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

public class NovaEmpresa {
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		Empresa empresa = new Empresa(nomeEmpresa, dataAberturaEmpresa);

		banco.adicionaEmpresa(empresa);

		response.sendRedirect("listaEmpresas");
	}
}
