package exceptions;

public class ErroConsultaFuncionario extends Exception {

	private static final long serialVersionUID = 1L;

	public ErroConsultaFuncionario(String mensagem){
		super("Erro na consulta de funcionario." + " " + mensagem);
	}

}