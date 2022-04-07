package model;

import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private Date dataAbertura;

	public Empresa(String nomeEmpresa, Date dataAberturaEmpresa) {

		super();
		this.nome = nomeEmpresa;
		this.dataAbertura = dataAberturaEmpresa;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataAbertura(Date dataAberturaEmpresa) {
		this.dataAbertura = dataAberturaEmpresa;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", dataAbertura=" + dataAbertura + "]";
	}

}
