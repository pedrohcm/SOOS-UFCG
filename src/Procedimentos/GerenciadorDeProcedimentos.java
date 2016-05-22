package Procedimentos;


import java.io.Serializable;

import Exceptions.ProcedimentoException;
import Paciente.Paciente;
/**
 * Classe responsavel por gerenciar os procedimentos
 **/
public class GerenciadorDeProcedimentos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Iprocedimentos tipoDeProcedimento;
	/**
	 * Realiza o procedimento requisitado em determinado paciente
	 * @param procedimento Tipo de procedimento a ser realizado
	 * @param paciente Paciente que sera submentido ao procedimento
	 * @return custoDoProcedimento valor cobrado pelo procedimento requisitado
	 * @throws ProcedimentoException 
	 * */
	public double realizarProcedimento(String procedimento , Paciente paciente) throws ProcedimentoException{
		definirProcedimento(procedimento);
		double custoDoProcedimento = tipoDeProcedimento.realizarProcedimento(paciente);
		return custoDoProcedimento;
	}
	
	/**
	 * Define qual o procedimento sera realizado
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
