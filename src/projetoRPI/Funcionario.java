package projetoRPI;



public abstract class Funcionario {
	
	private String nome;
	private String matricula;
	private String dataNascimento;
	private String senha;
	private Util util;
	
	public Funcionario(String nome, String matricula, String senha, String dataNascimento){
		
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		util = new Util();
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

	public String getDataNascimento(){
		return util.formataData(dataNascimento);
		
	}
	
	public abstract String getCargo();

}
