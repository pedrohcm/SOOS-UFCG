package Sistema;

/**
 * Raquel Rufino
 * Ionesio Junior
 * Pedro Maia
 */

import Exceptions.ControllerException;
import Exceptions.DataInvalidaException;
import Exceptions.FuncionarioException;
import Exceptions.MedicamentoException;
import Funcionarios.BancoFuncionarios;
import Funcionarios.Funcionario;
import Medicamentos.Farmacia;
import Medicamentos.Medicamento;
import Paciente.BancoPacientes;
import Paciente.Paciente;

/**
 * Construtor
 * 
 *
 */
public class Controller {
	private boolean sistemaLiberado;
	private Funcionario usuarioLogado;
	private BancoPacientes bancoPacientes;
	private BancoFuncionarios bancoFuncionarios;
	private Farmacia farmacia;
	private Util util;
	
	public Controller(){
		sistemaLiberado = false;
		util = new Util();
		bancoPacientes = new BancoPacientes();
		bancoFuncionarios = new BancoFuncionarios();
		farmacia = new Farmacia();
	}
	
	/**
	 * Libera Sistema
	 * @param chave associa a chave
	 * @param nome associa ao nome
	 * @param data associa a data de Nascimento
	 * @return matricula da primeira conta
	 * @throws DataInvalidaException
	 * @throws FuncionarioException
	 * @throws ControllerException
	 */
	public String liberaSistema(String chave,String nome , String data) throws DataInvalidaException, FuncionarioException, ControllerException{
		verificaSistema();
		util.verificaChave(chave);
		String matricula = bancoFuncionarios.criarPrimeiraConta(nome, data);
		sistemaLiberado = true;
		return matricula;
	}
	
	/**
	 * Realiza Login do Funcionario
	 * @param matricula associa a matricula dele
	 * @param senha associa a senha dele
	 * @throws ControllerException
	 */
	public void realizarLogin(String matricula,String senha) throws ControllerException{
		bancoFuncionarios.validarUsuario(matricula,senha);
		verificaLogin();
		usuarioLogado = bancoFuncionarios.getFuncionario(matricula);
	}
	
	/**
	 * Recupera informacoes do usuario
	 * @param matricula associa a matricula do funcionario
	 * @param atributo associa ao atributo
	 * @return a informa��o referente ao que foi pedido
	 * @throws ControllerException
	 */
	public String getInfoFuncionario(String matricula, String atributo) throws ControllerException{
		util.verificaMatricula(matricula);
		return bancoFuncionarios.getInfoFuncionario(matricula, atributo);
	}
	
	/**
	 * Recupera informacoes do Medicamentos
	 * @param atributo associa ao atributo
	 * @param nome associa ao nome 
	 * @return a informa��o pedida
	 * @throws ControllerException
	 */
	public String getInfoMedicamento(String atributo, String nome) throws ControllerException {
		return farmacia.getInfoMedicamento(atributo, nome);
	}
	
	/**
	 * Consulta ao tipo de Medicamento
	 * @param categoria associa a categoria
	 * @return 
	 * @throws MedicamentoException
	 */
	public String consultaMedCategoria(String categoria) throws MedicamentoException {
		return farmacia.buscaMedicamentoCategoria(categoria);
	}
	
	/**
	 * Consulta Medicamento pelo nome
	 * @param nome associa ao nome
	 * @return	informa��es do medicamento caso exista
	 * @throws ControllerException
	 */
	public String consultaMedNome(String nome) throws ControllerException {
		return farmacia.consultaMedNome(nome);
	}
	
	/**
	 * Cadastra Funcionarios
	 * @param nome associa ao nome
	 * @param cargo associa ao cargo
	 * @param nascimento associa a data de nascimento
	 * @return matricula gerada pelo cadastro
	 * @throws DataInvalidaException
	 * @throws FuncionarioException
	 * @throws ControllerException
	 */
	public String cadastrarFuncionarios(String nome,String cargo ,String nascimento) throws DataInvalidaException, FuncionarioException, ControllerException{
		if(util.verificaPermissao(usuarioLogado,"Diretor Geral")){
			verificaCargo(cargo);
			return bancoFuncionarios.cadastrarFuncionarios(nome, cargo, nascimento);
		}else{
			throw new ControllerException("O funcionario " + usuarioLogado.getNome() + " nao tem permissao para cadastrar funcionarios.");
		}
	}
	/**
	 * Cadastra Medicamentos
	 * @param nome associa ao nome
	 * @param tipo associa ao tipo
	 * @param preco associa do preco
	 * @param quantidade associa a quantidade
	 * @param categorias associa a categorias
	 * @return	nome do medicamento
	 * @throws ControllerException
	 * @throws MedicamentoException
	 */
	public String cadastraMedicamento(String nome, String tipo, double preco, int quantidade, String categorias) throws ControllerException, MedicamentoException {
		if(util.verificaPermissao(usuarioLogado, "Tecnico Administrativo")) {
			util.nomeMedicamento(nome);
			util.precoMedicamento(preco);
			util.quantidadeMedicamento(quantidade);
			return farmacia.cadastrarMedicamento(nome, tipo, preco, quantidade, categorias);
		} else {
			throw new ControllerException("O funcionario " + usuarioLogado.getNome() + " nao tem permissao para cadastrar medicamentos.");
		}
	}
	/**
	 * Verifica se ja Existe alguem logado
	 * @throws ControllerException
	 * */
	public void verificaLogin() throws ControllerException{
		if (usuarioLogado != null){
			throw new ControllerException("Um funcionario ainda esta logado: " + usuarioLogado.getNome() + "." );
		}
	}
	/**
	 * Realiza o logout do sistema
	 * @throws ControllerException
	 * */
	public void logout() throws ControllerException{
		if (usuarioLogado == null){
			throw new ControllerException("Nao ha um funcionario logado.");
		}
		usuarioLogado = null;
	}
	/**
	 * Exclui um funcionario caso exista
	 * @param matricula associa a matricula do usuario a ser excluido
	 * @param senha associa a senha do diretor
	 * @throws ControllerException
	 * */
	public void excluirFuncionario(String matricula,String senha) throws ControllerException{
		util.verificaMatricula(matricula);
		if(util.verificaPermissao(usuarioLogado,"Diretor Geral")){
			usuarioLogado.confirmarSenha(senha);
			bancoFuncionarios.excluiFuncionario(matricula);
		}else{
				throw new ControllerException("O funcionario "+ usuarioLogado.getNome() + " nao tem permissao para excluir funcionarios.");
			}
	}
	/**
	 * Atualiza informacoes de um funcionario
	 * @param matricula associa a matricula na busca ao usuario
	 * @param atributo associa ao atributo que sera atualizado
	 * @param valor associa um novo valor a ser atribuido
	 * @throws ControllerException
	 * */
	public void atualizaInfoFuncionario(String matricula,String atributo , String valor) throws ControllerException{
		atributo = atributo.toLowerCase();
		switch (atributo){
			case "nome":
				util.verificaNome(valor);
				break;
			case "data":
				util.verificaData(valor);
				break;
			case "":
				throw new ControllerException("Atributo invalido!");
		}
		bancoFuncionarios.atualizaInfoFuncionario(matricula, atributo, valor);
	}
	/**
	 * Atualiza informacoes de um Medicamento
	 * @param nome associa ao nome do medicamento a ser atualizado
	 * @param atributo associa ao atributo a ser atualizado
	 * @param novoValor define um novo valor para esse atributo
	 * @throws ControllerException
	 * */
	public void atualizaMedicamento(String nome, String atributo, String novoValor) throws ControllerException {
		atributo = atributo.toLowerCase();
		switch (atributo) {
			case "nome":
				throw new ControllerException("Nome do medicamento nao pode ser alterado.");
			case "tipo":
				throw new ControllerException("Tipo do medicamento nao pode ser alterado.");
			case "preco":
				double valor = Double.valueOf(novoValor);
				util.verificaPreco(valor);
				farmacia.atualizaPrecoMedicamento(nome, valor);
				break;
			case "quantidade":
				int quantidade = Integer.valueOf(novoValor);
				util.verificaQuantidade(quantidade);
				farmacia.atualizaQuantMedicamento(nome, quantidade);
				break;
			default:
				throw new ControllerException("Atributo invalido.");
		}
	}
	
	/**
	 * Atualiza a Senha de um usu�rio
	 * @param senhaAntiga associa a antiga senha do usuario para confirma��o
	 * @param senhaNova associa a nova senha que sera definida
	 * @throws ControllerException
	 * */
	public void atualizaSenha(String senhaAntiga , String senhaNova) throws ControllerException{
		usuarioLogado.confirmarSenha(senhaAntiga);
		util.verificaSenha(senhaNova);
		usuarioLogado.setSenha(senhaNova);
	}
	
	/**
	 * Atualiza um atributo do usuario logado
	 * @param atributo associa ao atributo que sera atualizado
	 * @param valor associa ao valor que sera definido para o atributo
	 * @throws ControllerException
	 * */
	public void atualizaFuncionario(String atributo , String valor) throws ControllerException{
		atributo = atributo.toLowerCase();
		switch(atributo){
			case "nome":
				util.verificaNome(valor);
				usuarioLogado.setNome(valor);
				break;
			case "data":
				util.verificaData(valor);
				usuarioLogado.setData(valor);
				break;
		}
	}
	/**
	 * Cadastra um novo Paciente
	 * @param nome sera usado como nome do novo paciente
	 * @param nascimento sera usado como data de nascimento do novo paciente
	 * @param peso sera usado como peso do novo paciente
	 * @param sexo sera usado como sexo do novo paciente
	 * @param genero sera usado como genero do novo paciente
	 * @param tipoSanguineo sera usado como tipo sanguineo do novo paciente
	 * @return o ID do novo paciente gerado
	 * @throws ControllerException
	 * */
	public String cadastraPaciente(String nome, String nascimento, double peso, String sexo, String genero, String tipoSanguineo) throws ControllerException{
		if(util.verificaPermissao(usuarioLogado,"Diretor Geral") || util.verificaPermissao(usuarioLogado,"Tecnico Administrativo")){
			util.Nomepaciente(nome);
			util.data(nascimento);
			util.peso(peso);
			util.tipoSanguineo(tipoSanguineo);
			return bancoPacientes.cadastrarPaciente(nome, nascimento, peso, sexo, genero, tipoSanguineo);
		}else{
			throw new ControllerException("O funcionario " + usuarioLogado.getNome() +" nao tem permissao para cadastrar pacientes.");
		}
	}
	/**
	 *  Pega informacoes de um paciente
	 *  @param id ser� usado para buscar o paciente em questao
	 *  @param atributo associado ao atributo que sera retornado
	 *  @return String do atributo
	 *  @throws ControllerException
	 *  */
	public String getInfoPaciente(String id,String atributo) throws ControllerException{
		return bancoPacientes.getInfoPaciente(id, atributo);
	}
	
	/**
	 *  Pega a ID do paciente com determinado prontuario
	 *  @param posicao associa a posicao que esse prontuario esta armazenado
	 *  @throws ControllerException
	 *  */
	public String getProntuario(String posicao) throws ControllerException{
		util.verificaID(posicao);
		int index = Integer.parseInt(posicao);
		return bancoPacientes.getProntuario(index);
	}
	
	/**
	 * Retorna o estoque de medicamentos
	 * @param ordenacao define o tipo de ordenacao que ser� retornada
	 * @throws ControlerException
	 * */
	public String getEstoqueFarmacia(String ordenacao) throws ControllerException{
		util.verificaOrdenacao(ordenacao);
		return farmacia.getListaOrdenada(ordenacao);
	}
	
	/**
	 * Verifica se o sistema ja foi liberado anteriormente
	 * @throws ControllerException
	 * */
	private void verificaSistema() throws ControllerException{
		if (sistemaLiberado == true){
			throw new ControllerException("Sistema liberado anteriormente.");
		}
	}
	
	/**
	 * Verifica se o cargo � valido para criacao de um novo funcionario
	 * @throws ControllerException
	 * */
	private void verificaCargo(String cargo) throws ControllerException{
		if (cargo.equalsIgnoreCase("diretor geral")){
			throw new ControllerException("Nao eh possivel criar mais de um Diretor Geral.");
		}
		else if (cargo.equals("")){
			throw new ControllerException("Nome do cargo nao pode ser vazio.");
		}
		else if(!cargo.equalsIgnoreCase("diretor geral") && !cargo.equalsIgnoreCase("medico") && !cargo.equalsIgnoreCase("tecnico administrativo")){
			throw new ControllerException("Cargo invalido.");
		}
	}
	
	
}

