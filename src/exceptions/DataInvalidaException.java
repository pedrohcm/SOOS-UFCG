package exceptions;

public class DataInvalidaException extends ErroCadastroException{
	
	private static final long serialVersionUID = 1L;

	public DataInvalidaException(){
		super("Data invalida.");
	}

}
