package Exceptions;

public class BancoOrgaosException extends Exception {

	private static final long serialVersionUID = 1L;

	public BancoOrgaosException(String mensagem) {
		super("O banco de orgaos apresentou um erro. " + mensagem);
	}
	
}
