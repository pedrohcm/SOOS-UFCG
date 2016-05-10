package Funcionarios;

import Exceptions.FuncionarioException;

public class Diretor extends Funcionario {
	/**
	 * Construtor de diretor
	 * @param nome associa ao nome
	 * @param matricula associa a matricula
	 * @param senha associa a senha
	 * @param data associa a data
	 * @param cargo associa ao cargo
	 * @throws FuncionarioException
	 */
	public Diretor(String nome, String matricula, String senha, String data,String cargo) throws FuncionarioException {
		super(nome, matricula, senha, data,cargo);
	}

}
