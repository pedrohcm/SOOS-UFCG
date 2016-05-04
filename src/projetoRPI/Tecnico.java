package projetoRPI;

public class Tecnico extends Funcionario{
	
	public Tecnico(String nome, String matricula, String senha, String dataNascimento){
		super(nome, matricula, senha, dataNascimento);
	}

	@Override
	public String getCargo() {
		return "Tecnico Administrativo";
	
	}

}
