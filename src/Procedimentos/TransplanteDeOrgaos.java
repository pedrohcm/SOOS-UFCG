package Procedimentos;

import java.io.Serializable;

import Exceptions.ProcedimentoException;
import Paciente.Paciente;
/**
 * Classe responsavel pelas caracteristicas do procedimento de transplante de orgaos
 * */
public class TransplanteDeOrgaos implements Iprocedimentos,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double PRECO = 12500;
	/**
	 * Realiza um procedimento de transplante de orgaos, armazena no prontuario e retorna o valor do procedimento
	 * @param paciente que sera submetido ao procedimento
	 * @return valor referente ao procedimento
	 * @throws ProcedimentoException 
	 * */
	@Override
	public double realizarProcedimento(Paciente paciente) throws ProcedimentoException {
		paciente.registrarProcedimento("Transplante de Orgaos");
		return PRECO;
	}
	
}
