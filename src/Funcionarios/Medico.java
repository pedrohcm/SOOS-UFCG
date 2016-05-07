package Funcionarios;

import Exceptions.FuncionarioException;

public class Medico extends Funcionario {

	public Medico(String nome, String matricula, String senha, String data,String cargo) throws FuncionarioException {
	super(nome,matricula,senha,data,cargo);
	}

}
