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

public class EditaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		Integer idEmpresa;

		try {
			idEmpresa = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			throw new ServletException("Identificador não é válido");
		}

		Empresa empresa = banco.buscaEmpresa(idEmpresa);

		if (empresa == null) {

			throw new ServletException("Nenhuma empresa com o id " + idEmpresa + " foi localizada.");

		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataAberturaEmpresa = null;

		try {
			dataAberturaEmpresa = sdf.parse(request.getParameter("dataAberturaEmpresa"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Data Inválida!");
		}

		empresa.setNome(request.getParameter("nomeEmpresa"));
		empresa.setDataAbertura(dataAberturaEmpresa);

		return "redirect:listaEmpresa";

	}

}
