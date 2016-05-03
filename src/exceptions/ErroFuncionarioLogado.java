package exceptions;

public class ErroFuncionarioLogado extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	public ErroFuncionarioLogado(String mensagem,String nome){
		super(mensagem + " Um funcionario ainda esta logado: " + nome + ".");
	}
}
