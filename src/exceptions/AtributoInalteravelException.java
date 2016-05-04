package exceptions;

public class AtributoInalteravelException extends Exception {
	private static final long serialVersionUID = 1L;

	public AtributoInalteravelException(String atributo) {
		super(atributo + " nao pode ser alterado.");
	}

}
