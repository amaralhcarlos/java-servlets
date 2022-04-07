package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();

	static {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MM, dd");

		Date date = null;
		try {
			date = sdf.parse("2009, 12, 9");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Banco.empresas.add(new Empresa(1, "Google", date));
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
