package Procedimentos;

import java.io.Serializable;

import Exceptions.ProcedimentoException;
import Paciente.Paciente;
/**
 * Classe responsavel pelas caracteristicas do procedimento de cirurgia bariatrica
 * */
public class CirurgiaBariatrica implements Iprocedimentos,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double PRECO = 7600;
	/**
	 * Realiza uma cirurgia bariatrica, armazena no prontuario e retorna o valor do procedimento
	 * @param paciente que sera submetido ao procedimento
	 * @return valor referente ao procedimento
	 * @throws ProcedimentoException 
	 * */
	@Override
	public double realizarProcedimento(Paciente paciente) throws ProcedimentoException {
		paciente.registrarProcedimento("Cirurgia Bariatrica");
		double pesoAposProcedimento  = paciente.getPeso() * 0.85;
		paciente.setPeso(pesoAposProcedimento);
		return PRECO;
	}

}
