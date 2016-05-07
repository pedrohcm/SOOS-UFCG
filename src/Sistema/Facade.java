package Sistema;



public class Facade {
	Controller control;

	public Facade() {
		control = new Controller();
	}

	public void iniciaSistema() {

	}
	/**
	 * Libera Sistema
	 * @param chave associa a chave
	 * @param nome associa ao nome
	 * @param nascimento associa a data de nascimento
	 * @return
	 * @throws Exception
	 */
	public String liberaSistema(String chave, String nome, String nascimento) throws Exception {
		try {
			String mensagem = control.liberaSistema(chave, nome, nascimento);
			return mensagem;
		} catch (Exception e) {
			throw new Exception("Erro ao liberar o sistema. " + e.getMessage());
		}
	}
	/**
	 * Faz login
	 * @param matricula associa a matricula
	 * @param senha associa a senha
	 * @throws Exception
	 */
	public void login(String matricula, String senha) throws Exception {
		try {
			control.realizarLogin(matricula, senha);
		} catch (Exception e) {
			throw new Exception("Nao foi possivel realizar o login. " + e.getMessage());
		}
	}
	/**
	 * Recupera informacao do usuario
	 * @param matricula associa a matricula
	 * @param atributo associa ao atributo
	 * @return
	 * @throws Exception
	 */
	public String getInfoFuncionario(String matricula, String atributo) throws Exception {
		try {
			return control.getInfoFuncionario(matricula, atributo);
		} catch (Exception e) {
			throw new Exception("Erro na consulta de funcionario. " + e.getMessage());
		}
	}
	/**
	 * Cadastra Funcionario
	 * @param nome associa ao nome
	 * @param cargo associa ao cargo
	 * @param nascimento associa a data de nascimento
	 * @return
	 * @throws Exception
	 */
	public String cadastraFuncionario(String nome, String cargo, String nascimento) throws Exception {
		try {
			return control.cadastrarFuncionarios(nome, cargo, nascimento);
		} catch (Exception e) {
			throw new Exception("Erro no cadastro de funcionario. " + e.getMessage());
		}
	}

	public void atualizaInfoFuncionario(String matricula, String atributo, String novoValor) throws Exception {
		try {
			control.atualizaInfoFuncionario(matricula, atributo, novoValor);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar funcionario. " + e.getMessage());
		}
	}

	public void atualizaInfoFuncionario(String atributo, String novoValor) throws Exception {
		try {
			control.atualizaFuncionario(atributo, novoValor);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar funcionario. " + e.getMessage());
		}
	}

	public String cadastraPaciente(String nome, String nascimento, double peso, String sexo, String genero,
			String tipoSanguineo) throws Exception {
		try {
			return control.cadastraPaciente(nome, nascimento, peso, sexo, genero, tipoSanguineo);
		} catch (Exception e) {
			throw new Exception("Nao foi possivel cadastrar o paciente. " + e.getMessage());
		}
	}

	public void atualizaSenha(String senhaAntiga, String senhaNova) throws Exception {
		try {
			control.atualizaSenha(senhaAntiga, senhaNova);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar funcionario. " + e.getMessage());
		}
	}

	public String getInfoPaciente(String id, String atributo) throws Exception {
		try {
			return control.getInfoPaciente(id, atributo);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String getProntuario(String posicao) throws Exception {
		try {
			return control.getProntuario(posicao);
		} catch (Exception e) {
			throw new Exception("Erro ao consultar prontuario. " + e.getMessage());
		}
	}

	public String cadastraMedicamento(String nome, String tipo, double preco, int quantidade, String categorias)
			throws Exception {
		try {
			return control.cadastraMedicamento(nome, tipo, preco, quantidade, categorias);
		} catch (Exception e) {
			throw new Exception("Erro no cadastro de medicamento. " + e.getMessage());
		}
	}

	public String getInfoMedicamento(String atributo, String nome) throws Exception {
		try {
			return control.getInfoMedicamento(atributo, nome);
		} catch (Exception e) {
			throw new Exception("Erro ao consultar medicamento. " + e.getMessage());
		}
	}

	public void atualizaMedicamento(String nome, String atributo, String novoValor) throws Exception {
		try {
			control.atualizaMedicamento(nome, atributo, novoValor);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar medicamento. " + e.getMessage());
		}
	}

	public String consultaMedCategoria(String categoria) throws Exception {
		try {
			return control.consultaMedCategoria(categoria);
		} catch (Exception e) {
			throw new Exception("Erro na consulta de medicamentos. " + e.getMessage());
		}
	}

	public String consultaMedNome(String nome) throws Exception {
		try {
			return control.consultaMedNome(nome);
		} catch (Exception e) {
			throw new Exception("Erro na consulta de medicamentos. " + e.getMessage());
		}
	}

	public void logout() throws Exception {
		try {
			control.logout();
		} catch (Exception e) {
			throw new Exception("Nao foi possivel realizar o logout. " + e.getMessage());
		}
	}

	public void excluiFuncionario(String matricula, String senha) throws Exception {
		try {
			control.excluirFuncionario(matricula, senha);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir funcionario. " + e.getMessage());
		}
	}

	public void fechaSistema() throws Exception {
		try {
			control.verificaLogin();
		} catch (Exception e) {
			throw new Exception("Nao foi possivel fechar o sistema. " + e.getMessage());
		}
	}

	public String getEstoqueFarmacia(String ordenacao) throws Exception {
		try {
			return control.getEstoqueFarmacia(ordenacao);
		} catch (Exception e) {
			throw new Exception("Erro na consulta de medicamentos. " + e.getMessage());
		}
	}
}
