package exceptions;

public class StringVaziaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StringVaziaException(String atributo) {
		super(atributo + " nao pode ser vazio");
	}
}
