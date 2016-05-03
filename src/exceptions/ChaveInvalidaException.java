package exceptions;

public class ChaveInvalidaException extends ErroSistemaException {

	private static final long serialVersionUID = 1L;
	
	public ChaveInvalidaException() {
		super("Chave invalida.");
	}

}
