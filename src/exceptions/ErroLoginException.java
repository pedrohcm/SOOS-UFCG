package exceptions;

public class ErroLoginException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ErroLoginException(String mensagem) {
		super("Nao foi possivel realizar o login." + " " + mensagem);
	}
}
