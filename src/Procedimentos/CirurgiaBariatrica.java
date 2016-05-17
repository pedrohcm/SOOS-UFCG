package Procedimentos;

import Exceptions.ProcedimentoException;
import Paciente.Paciente;
/**
 * Classe responsavel pelas caracteristicas do procedimento de cirurgia bariatrica
 * */
public class CirurgiaBariatrica implements Iprocedimentos{
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
