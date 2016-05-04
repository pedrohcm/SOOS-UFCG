package exceptions;

public class AtualizaMedicamentoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AtualizaMedicamentoException(String mensagem) {
		super("Erro ao atualizar medicamento." + " " + mensagem);
	}

}
