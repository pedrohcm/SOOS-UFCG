package exceptions;

public class ErroLogoutException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ErroLogoutException(String mensagem) {
		super("Nao foi possivel realizar o logout." + " " + mensagem);
	}
}
