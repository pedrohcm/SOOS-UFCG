package projetoRPI;

import java.util.LinkedList;

import exceptions.ChaveInvalidaException;
import exceptions.DadoInvalidoException;
import exceptions.DataInvalidaException;
import exceptions.ErroCadastroException;
import exceptions.ErroConsultaFuncionario;
import exceptions.ErroFuncionarioLogado;
import exceptions.ErroLoginException;
import exceptions.ErroLogoutException;
import exceptions.ObjetoNaoExisteException;
import exceptions.SistemaLiberadoException;
import factories.UsuarioFactory;
import factories.MedicamentoFactory;

public class Controller {

	private final String CHAVE_PRINCIPAL = "c041ebf8";
	private Funcionario diretor;;
	private boolean iniciado = false;
	private Funcionario logado;
	private Util util;
	private UsuarioFactory factoryUsuarios = new UsuarioFactory();
	private LinkedList<Funcionario> funcionarios;

	MedicamentoFactory factoryMedicamentos = new MedicamentoFactory();

	public Controller() {
		diretor = null;
		iniciado = false;
		logado = null;
		util = new Util();
		funcionarios = new LinkedList<Funcionario>();
	}

	public String liberaSistema(String chave, String nome, String data)
			throws Exception {

		if (diretor == null) {
			if (chave.equals(CHAVE_PRINCIPAL)) {
				return cadastraFuncionario(nome, "Diretor", data);
			}
			throw new ChaveInvalidaException();
		} else {
			throw new SistemaLiberadoException();
		}
	}

	public void iniciaSistema() throws Exception {
		if (iniciado) {
			throw new Exception("Sistema nao esta iniciado");
		}
		iniciado = true;
	}

	public void realizaLogin(String matricula, String senha)
			throws ErroLoginException, ObjetoNaoExisteException, ErroFuncionarioLogado {
		try {
			if(logado != null){
				throw new ErroFuncionarioLogado("Nao foi possivel realizar o login.",logado.getNome());
			}
			util.verificaMatricula(matricula);
			util.verificaSenha(senha);
			
			Funcionario usuario = getFuncionario(matricula);
			
			if (usuario == null) {
				throw new ObjetoNaoExisteException("Funcionario");
			} 
			else if (!senha.equals(usuario.getSenha())) {
				throw new ErroLoginException("Senha incorreta.");
			}
			logado = usuario;
		} catch (DadoInvalidoException | ObjetoNaoExisteException e) {
			throw new ErroLoginException(e.getMessage());
		}
	}

	public String cadastraFuncionario(String nome, String cargo, String data)
			throws Exception {
		try {
			
			if (diretor != null && cargo.equalsIgnoreCase("Diretor Geral")) {
				throw new ErroCadastroException(
						"Nao eh possivel criar mais de um Diretor Geral.");
			}
			
			util.verificaNome(nome);
			util.verificaCargo(cargo);
			
			Funcionario funcionario = factoryUsuarios.criaUsuario(nome, cargo,
					data);
			if (funcionario.getCargo().equalsIgnoreCase("diretor geral")) {
				diretor = funcionario;
			}
			funcionarios.add(funcionario);
			return funcionario.getMatricula();
		} catch (DadoInvalidoException e) {
			throw new ErroCadastroException(e.getMessage());
		}
	}

	public Funcionario getFuncionario(String matricula) {
		for (Funcionario funcionario : funcionarios) {
			
			if (funcionario.getMatricula().equals(matricula)) {
				return funcionario;
			}
		}
		return null;
	}

	public String getInfoFuncionario(String matricula, String atributo)
			throws DadoInvalidoException, DataInvalidaException, ErroConsultaFuncionario {
		util.verificaMatricula(matricula);
		util.verificaAtributo(atributo);
		Funcionario usuario = getFuncionario(matricula);
		atributo = atributo.toLowerCase();
		
		switch (atributo) {

		case "nome":
			return usuario.getNome();

		case "cargo":
			return usuario.getCargo();

		case "data":

			return usuario.getDataNascimento();

		case "senha":
			if (usuario.equals(logado)) {
				return usuario.getSenha();
			} else {
				throw new ErroConsultaFuncionario("A senha do funcionario eh protegida.");
			}
		default:
			throw new DadoInvalidoException("Atributo Invalido");
		}

	}
	
	public void fechaSistema() throws Exception{
		if(!(logado == null)){
			throw new Exception("Nao foi possivel fechar o sistema. Um funcionario ainda esta logado: " + logado.getNome() + ".");
		}
		iniciado = false;
	}
	public void logout() throws Exception{
		
		if (logado == null){
			
			throw new ErroLogoutException("Nao ha um funcionario logado.");
		}
		logado = null;
		
	}
	/*
	 * Nao sei se isso sera aqui ou numa classe farmacia (que seria a
	 * controller) // -------------------Farmacia----------------
	 * 
	 * public void cadastraMedicamento(String nome, String tipo, double preco,
	 * int quantidade, String categoria) { // verificar se tem permissao
	 * factoryMedicamentos.criaMedicamento(nome, tipo, preco, quantidade,
	 * categoria); }
	 * 
	 * public String consultaMedNome(String nome) { return }
	 * 
	 * 
	 * 
	 * public void getNomeMedicamento(String id ) { return }
	 * 
	 * public double getPrecoMedicamento(String id) { return }
	 * 
	 * public String getCategoriasMedicamento(String id) { return }
	 * 
	 * public int getQuantidadeMedicamento(String id) { return }
	 */
}
