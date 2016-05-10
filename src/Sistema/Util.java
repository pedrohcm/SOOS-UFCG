package Sistema;

import Exceptions.ControllerException;
import Exceptions.DataInvalidaException;
import Exceptions.MedicamentoException;
import Exceptions.PacienteException;
import Funcionarios.Funcionario;

public class Util {

	/**
	 * Verifica o nome do funcionario
	 * 
	 * @param nome
	 *            associa ao nome
	 * @throws ControllerException
	 */
	public void Nomefuncionario(String nome) throws ControllerException {
		if (nome.equals("") || nome == null) {
			throw new ControllerException(
					"Nome do funcionario nao pode ser vazio.");
		}
	}

	/**
	 * Verifica o nome do paciente
	 * 
	 * @param nome
	 *            associa ao nome
	 * @throws PacienteException
	 */
	public void Nomepaciente(String nome) throws PacienteException {
		if (nome.equals("") || nome.equals(" ") || nome == null) {
			throw new PacienteException("Nome do paciente nao pode ser vazio.");
		}
	}

	/**
	 * Verifica o nome do medicamento
	 * 
	 * @param nome
	 *            associa o nome do medicamento
	 * @throws MedicamentoException
	 */
	public void nomeMedicamento(String nome) throws MedicamentoException {
		if (nome.equals("") || nome.equals(" ") || nome == null) {
			throw new MedicamentoException(
					"Nome do medicamento nao pode ser vazio.");
		}
	}

	/**
	 * Verifica o preco do medicamento
	 * 
	 * @param preco
	 *            associa ao preco
	 * @throws MedicamentoException
	 */
	public void precoMedicamento(double preco) throws MedicamentoException {
		if (preco < 0) {
			throw new MedicamentoException(
					"Preco do medicamento nao pode ser negativo.");
		}
	}

	/**
	 * Verifica a quantidade de medicamento
	 * 
	 * @param quantidade
	 *            associa a quantidade
	 * @throws MedicamentoException
	 */
	public void quantidadeMedicamento(int quantidade)
			throws MedicamentoException {
		if (quantidade < 0) {
			throw new MedicamentoException(
					"Quantidade do medicamento nao pode ser negativo.");
		}
	}

	/**
	 * Formata a data
	 * 
	 * @param data
	 *            associa a data de nascimento
	 * @throws DataInvalidaException
	 */
	public void data(String data) throws DataInvalidaException {
		String[] newDate = data.split("/");
		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);
		if ((dia < 1 || dia > 31) || (mes < 1 || mes > 12) || (ano > 2016)) {
			throw new DataInvalidaException("Data invalida.");
		}
	}

	/**
	 * Verifica o peso
	 * 
	 * @param peso
	 *            associa ao peso
	 * @throws PacienteException
	 */
	public void peso(double peso) throws PacienteException {
		if (peso <= 0) {
			throw new PacienteException(
					"Peso do paciente nao pode ser negativo.");
		}
	}

	/**
	 * Verifica os tipo de sanguineo
	 * 
	 * @param tiposanguineo
	 *            associa ao tipo sanguineo
	 * @return
	 * @throws PacienteException
	 */
	public boolean tipoSanguineo(String tiposanguineo) throws PacienteException {
		tiposanguineo = tiposanguineo.toLowerCase();
		switch (tiposanguineo) {
		case "ab+":
			return true;
		case "ab-":
			return true;
		case "a+":
			return true;
		case "a-":
			return true;
		case "b+":
			return true;
		case "b-":
			return true;
		case "o+":
			return true;
		case "o-":
			return true;
		default:
			throw new PacienteException("Tipo sanguineo invalido.");
		}
	}

	/**
	 * Verifica senha
	 * 
	 * @param senha
	 *            associa a senha
	 * @throws ControllerException
	 */
	public void verificaSenha(String senha) throws ControllerException {
		if (senha.contains("@#!")) {
			throw new ControllerException(
					"A nova senha deve ter entre 8 - 12 caracteres alfanumericos.");
		}
	}

	/**
	 * Verifica o nome do funcionario
	 * @param valor associa ao nome 
	 * @throws ControllerException
	 */
	public void verificaNome(String valor) throws ControllerException {
		if (valor.equals("") || valor == null) {
			throw new ControllerException(
					"Nome do funcionario nao pode ser vazio.");
		}
	}
	/**
	 * Verifica a data de nascimento
	 * @param data associa a data de nascimento
	 * @throws DataInvalidaException
	 */
	public void verificaData(String data) throws DataInvalidaException {
		String[] newDate = data.split("/");
		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);
		if ((dia < 1 || dia > 31) || (mes < 1 || mes > 12) || (ano > 2016)) {
			throw new DataInvalidaException("Data invalida.");
		}
	}
	/**
	 * Verifica id
	 * @param ID associa ao id
	 * @throws ControllerException
	 */
	public void verificaID(String ID) throws ControllerException {
		int id = Integer.parseInt(ID);
		if (id < 0) {
			throw new ControllerException(
					"Indice do prontuario nao pode ser negativo.");
		}
	}
	/**
	 * Verifica Permissao
	 * @param usuariologado associa a ao funcionario logado
	 * @param requisito associa ao requisito solicitado
	 * @return
	 * @throws ControllerException
	 */
	public boolean verificaPermissao(Funcionario usuariologado, String requisito)
			throws ControllerException {
		requisito = requisito.toLowerCase();
		String cargo = usuariologado.getCargo();
		if (!(cargo.equalsIgnoreCase(requisito))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Verifica se e um preco valido.
	 * 
	 * @throws ControllerException
	 * */
	public void verificaPreco(double valor) throws ControllerException {
		if (valor < 0) {
			throw new ControllerException("Preco nao pode ser negativo.");
		}
	}

	/**
	 * Verifica se e uma quantidade valida.
	 * 
	 * @throws ControllerException
	 * */
	public void verificaQuantidade(int quantidade) throws ControllerException {
		if (quantidade < 0) {
			throw new ControllerException("Quantidade nao pode ser negativa.");
		}
	}

	/**
	 * Verifica se a chave para liberar o sistema e valida
	 * 
	 * @param chave
	 *            sera comparada a chave do sistema
	 * */

	public void verificaChave(String chave) throws ControllerException {
		if (!(chave.equals("c041ebf8"))) {
			throw new ControllerException("Chave invalida.");
		}
	}

	/**
	 * Verifica se o cargo e valido para criacao de um novo funcionario
	 * 
	 * @throws ControllerException
	 * */
	public void verificaCargo(String cargo) throws ControllerException {
		if (cargo.equalsIgnoreCase("diretor geral")) {
			throw new ControllerException(
					"Nao eh possivel criar mais de um Diretor Geral.");
		} else if (cargo.equals("")) {
			throw new ControllerException("Nome do cargo nao pode ser vazio.");
		} else if (!cargo.equalsIgnoreCase("diretor geral")
				&& !cargo.equalsIgnoreCase("medico")
				&& !cargo.equalsIgnoreCase("tecnico administrativo")) {
			throw new ControllerException("Cargo invalido.");
		}
	}

	/**
	 * Verifica se eh uma matricula valida
	 * 
	 * @throws ControllerException
	 * */
	public void verificaMatricula(String matricula) throws ControllerException {
		try {
			Integer.parseInt(matricula);
		} catch (Exception e) {
			throw new ControllerException("A matricula nao segue o padrao.");
		}
	}

	/**
	 * Verifica se eh uma ordenacao valida
	 * 
	 * @throws ControllerException
	 * */
	public void verificaOrdenacao(String ordenacao) throws ControllerException {

		if (!(ordenacao.toLowerCase().equals("preco") || ordenacao
				.equals("alfabetica"))) {
			throw new ControllerException("Tipo de ordenacao invalida.");
		}
	}

}
