package projetoRPI;

import factories.UsuarioFactory;

public class Controller {
	
	final String CHAVE_PRINCIPAL = "c041ebf8";
	UsuarioFactory factory = new UsuarioFactory();
	
	public String liberaSistema(String chave){
		String novaMatricula = "";
		return novaMatricula;
	}
	
	public void realizaLogin(){
		
	}
	
	public void cadastraFuncionario(String nome, String cargo, String data){
		factory.criaUsuario(nome, cargo, data);
	}
}
