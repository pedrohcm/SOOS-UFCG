package exceptions;

public class ErroCadastroException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErroCadastroException(String mensagem){
		super("Erro no cadastro de funcionario." + " " + mensagem);
	}

}
