package exceptions;

public class DadoInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DadoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
