package Funcionarios;

import Exceptions.FuncionarioException;

public class Diretor extends Funcionario {

	public Diretor(String nome, String matricula, String senha, String data,String cargo) throws FuncionarioException {
		super(nome, matricula, senha, data,cargo);
	}

}
