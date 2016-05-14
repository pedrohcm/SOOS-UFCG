package Funcionarios;

import Exceptions.FuncionarioException;

public class Medico extends Funcionario {
	/**
	 * Construtor de medico
	 * @param nome associa ao nome
	 * @param matricula associa a matricula
	 * @param senha associa a senha
	 * @param data associa a data
	 * @param cargo associa ao cargo
	 * @throws FuncionarioException
	 */
	public Medico(String nome, String matricula, String senha, String data,String cargo) throws FuncionarioException {
	super(nome,matricula,senha,data,cargo);
	}

	@Override
	public void definirPermissoes() {
		// TODO Auto-generated method stub
		
	}

}
