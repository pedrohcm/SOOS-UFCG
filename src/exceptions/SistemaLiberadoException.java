package exceptions;

public class SistemaLiberadoException extends ErroSistemaException {
	
	private static final long serialVersionUID = 1L;

	public SistemaLiberadoException(){
		super("Sistema liberado anteriormente.");
	}

}
