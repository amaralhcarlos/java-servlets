package model;

public class Empresa {

	private Integer id;
	private String nome;


	public Empresa(Integer id, String nomeEmpresa) {

		super();
		this.id = id;
		this.nome = nomeEmpresa;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
