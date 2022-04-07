package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static Integer chave = 1;

	static {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MM, dd");

		Date date = null;
		try {
			date = sdf.parse("2009, 12, 9");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Empresa empresa1 = new Empresa("Google", date);
		empresa1.setId(chave++);
		
		Empresa empresa2 = new Empresa("Microsoft", new Date());
		empresa2.setId(chave++);

		Banco.empresas.add(empresa1);
		Banco.empresas.add(empresa2);
	}

	public void adicionaEmpresa(Empresa empresa) {

		empresa.setId(chave++);
		
		Banco.empresas.add(empresa);

	}
	
	public void removeEmpresa(Integer id) {

		Empresa empresa = empresas.stream().filter(e -> id.equals(e.getId())).findAny().orElse(null);
		
		empresas.remove(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

}
