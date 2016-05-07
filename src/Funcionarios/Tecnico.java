package Funcionarios;

import Exceptions.FuncionarioException;

public class Tecnico extends Funcionario {
	public Tecnico(String nome,String matricula,String senha,String data,String cargo) throws FuncionarioException{
		super(nome,matricula,senha,data,cargo);
	}
}
