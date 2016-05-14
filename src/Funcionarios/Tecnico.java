package Funcionarios;

import java.util.HashSet;

import Exceptions.FuncionarioException;

public class Tecnico extends Funcionario {
	/**
	 * Construtor de tecnico
	 * @param nome associa ao nome
	 * @param matricula associa a matricula
	 * @param senha associa a senha
	 * @param data associa a data
	 * @param cargo associa ao cargo
	 * @throws FuncionarioException
	 */
	public Tecnico(String nome,String matricula,String senha,String data,String cargo) throws FuncionarioException{
		super(nome,matricula,senha,data,cargo);
		definirPermissoes();
	}

	/**
	 * Na especificação do problema o tecnico tem permissao para cadastro de pacientes e medicamentos
	 * */
	@Override
	protected void definirPermissoes() {
		HashSet<Permissoes> permissoesConcedidas = this.getPermissoes();
		permissoesConcedidas.add(Permissoes.CADASTRAPACIENTE);
		permissoesConcedidas.add(Permissoes.CADASTRAMEDICAMENTO);
		this.setPermissoes(permissoesConcedidas);
	}
}
