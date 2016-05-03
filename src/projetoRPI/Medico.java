package projetoRPI;

public class Medico extends Funcionario {
	
	public Medico(String nome, String matricula, String senha, String dataNascimento){
		super(nome, matricula, senha, dataNascimento);
	}

	@Override
	public String getCargo() {
		return "Medico";
	}
}
