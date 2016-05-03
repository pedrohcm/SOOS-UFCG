package exceptions;

public class ObjetoNaoExisteException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ObjetoNaoExisteException(String nomeObjeto) {
		super(nomeObjeto + " nao cadastrado.");
	}
}
