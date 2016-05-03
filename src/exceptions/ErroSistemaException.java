package exceptions;

public class ErroSistemaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ErroSistemaException(String mensagem){
		super("Erro ao liberar o sistema." + " " + mensagem);
	}

}
