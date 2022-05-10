package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

public class CadastraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "forward:form-nova-empresa.jsp";

	}

}
