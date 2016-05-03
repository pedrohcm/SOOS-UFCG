package main;
import exceptions.DadoInvalidoException;
import exceptions.DataInvalidaException;
import exceptions.ErroConsultaFuncionario;
import exceptions.ErroFuncionarioLogado;
import exceptions.ErroLoginException;
import exceptions.ObjetoNaoExisteException;
import projetoRPI.Controller;

public class Facade {
	private Controller controller;
	
	public Facade() {
		controller = new Controller();
	}
	
	public void iniciaSistema() throws Exception {
		controller.iniciaSistema();
	}
	
	public String liberaSistema(String chave, String nome, String data) throws Exception {
		return controller.liberaSistema(chave, nome, data);
	}
	
	public void login(String matricula, String senha) throws ErroLoginException, ObjetoNaoExisteException, ErroFuncionarioLogado {
		controller.realizaLogin(matricula, senha);
	}
	
	public String getInfoFuncionario(String matricula, String atributo) throws DadoInvalidoException, DataInvalidaException, ErroConsultaFuncionario{
		return controller.getInfoFuncionario(matricula, atributo);
	}
	
	public String cadastraFuncionario(String nome , String cargo, String data) throws Exception{
		return controller.cadastraFuncionario(nome, cargo, data);
	}
	
	public void fechaSistema() throws Exception{
		controller.fechaSistema();
	}
	
	public void logout() throws Exception{
		controller.logout();
	}
	
}
