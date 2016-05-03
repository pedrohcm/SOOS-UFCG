package main;
import exceptions.ErroCadastroException;
import exceptions.ErroLoginException;
import exceptions.ErroSistemaException;
import exceptions.ObjetoNaoExisteException;
import projetoRPI.Controller;

public class Facade {
	private Controller controller;
	
	public Facade() {
		controller = new Controller();
	}
	
	public void iniciaSistema() {
		controller.iniciaSistema();
	}
	
	public String liberaSistema(String chave, String nome, String data) throws ErroSistemaException, ErroCadastroException {
		return controller.liberaSistema(chave, nome, data);
	}
	
	public void login(String matricula, String senha) throws ErroLoginException, ObjetoNaoExisteException {
		controller.realizaLogin(matricula, senha);
	}
	
}
