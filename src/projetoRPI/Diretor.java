package projetoRPI;

public class Diretor extends Funcionario {

	public Diretor(String nome, String matricula, String senha, String dataNascimento){
		super(nome, matricula, senha, dataNascimento);
	}

	@Override
	public String getCargo() {
		return "Diretor Geral";
	}
}
