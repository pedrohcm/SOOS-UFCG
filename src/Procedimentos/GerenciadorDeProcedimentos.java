package Procedimentos;


import Paciente.Paciente;
/**
 * Classe responsavel por gerenciar os procedimentos
 **/
public class GerenciadorDeProcedimentos {
	private Iprocedimentos tipoDeProcedimento;
	/**
	 * Realiza o procedimento requisitado em determinado paciente
	 * @param procedimento Tipo de procedimento a ser realizado
	 * @param paciente Paciente que sera submentido ao procedimento
	 * @return custoDoProcedimento valor cobrado pelo procedimento requisitado
	 * */
	public double realizarProcedimento(String procedimento , Paciente paciente){
		definirProcedimento(procedimento);
		double custoDoProcedimento = tipoDeProcedimento.realizarProcedimento(paciente);
		return custoDoProcedimento;
	}
	
	/**
	 * Define qual o procedimento ser� realizado
	 * @param procedimento String indicando o procedimento
	 * */
	private void definirProcedimento(String procedimento){
		procedimento  = procedimento.toLowerCase();
		switch (procedimento){
			case "consulta clinica":
				tipoDeProcedimento = new ConsultaClinica();
				break;
			case "cirurgia bariatrica":
				tipoDeProcedimento = new CirurgiaBariatrica();
				break;
			case "redesignacao sexual":
				tipoDeProcedimento = new RedesignacaoSexual();
				break;
			case "transplante de orgaos":
				tipoDeProcedimento = new TransplanteDeOrgaos();
				break;
		}
	}
}	
