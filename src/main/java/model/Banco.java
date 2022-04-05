package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();

	static {
		Banco.empresas.add(new Empresa(1, "Google", new Date()));
		Banco.empresas.add(new Empresa(2, "Microsoft", new Date()));
	}

	public void adiciona(Empresa empresa) {

		Banco.empresas.add(empresa);

		System.out.println("Empresa " + empresa.getNome() + " foi incluída.");

	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

}
