package projetoRPI;

public abstract class Funcionario {
	
	private String nome;
	private String matricula;
	private String dataNascimento;
	private String senha;
	
	public Funcionario(String nome, String matricula, String senha, String dataNascimento){
		
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public abstract String getCargo();

}
