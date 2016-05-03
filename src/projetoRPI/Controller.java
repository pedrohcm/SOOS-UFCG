package projetoRPI;

import java.util.LinkedList;

import exceptions.ChaveInvalidaException;
import exceptions.DadoInvalidoException;
import exceptions.ErroCadastroException;
import exceptions.DataInvalidaException;
import exceptions.ErroLoginException;
import exceptions.ErroSistemaException;
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
	
	
	public String liberaSistema(String chave, String nome, String data) throws ErroSistemaException, ErroCadastroException{
		
		if (diretor == null){
			if(chave.equals(CHAVE_PRINCIPAL)){
				return cadastraFuncionario(nome, "Diretor", data);				
			}
			throw new ChaveInvalidaException();
		} else {
			throw new SistemaLiberadoException();
		}
	}
	
	public void iniciaSistema() {
		if(iniciado) {
			//lancar excecao q ta iniciado
		}
		iniciado = true;		
	}
	
	public void realizaLogin(String matricula, String senha) throws ErroLoginException, ObjetoNaoExisteException {
		try {
			util.verificaSenha(senha);
			util.verificaMatricula(matricula);
			Funcionario usuario = getFuncionario(matricula);
			if(usuario == null) {
				throw new ObjetoNaoExisteException("Funcionario");
			}
			else if(!senha.equals(usuario.getSenha())) {
				throw new DadoInvalidoException("Senha incorreta.");
			}
			logado = usuario;
		} catch(DadoInvalidoException | ObjetoNaoExisteException e) {
			throw new ErroLoginException(e.getMessage());
		}
	}
	
	public String cadastraFuncionario(String nome, String cargo, String data) throws DataInvalidaException{
		Funcionario funcionario = factoryUsuarios.criaUsuario(nome, cargo, data);
		if(funcionario.getCargo().equalsIgnoreCase("diretor geral")) {
			diretor = funcionario;
		}
		funcionarios.add(funcionario);
		return funcionario.getMatricula();
	}
	
	public Funcionario getFuncionario(String matricula) {
		for(Funcionario funcionario: funcionarios) {
			if(funcionario.getMatricula().equals(matricula)) {
				return funcionario;
			}
		}
		return null;
	}
	
	/* Nao sei se isso sera aqui ou numa classe farmacia (que seria a controller)
	// -------------------Farmacia----------------
	
	public void cadastraMedicamento(String nome, String tipo, double preco, int quantidade, String categoria) {
		// verificar se tem permissao
		factoryMedicamentos.criaMedicamento(nome, tipo, preco, quantidade, categoria);
	}
	
	public String consultaMedNome(String nome) {
		return 
	}
	
	
	
	public void getNomeMedicamento(String id ) {
		return
	}
	
	public double getPrecoMedicamento(String id) {
		return
	}
	
	public String getCategoriasMedicamento(String id) {
		return
	}
	
	public int getQuantidadeMedicamento(String id) {
		return
	}
	*/
}
