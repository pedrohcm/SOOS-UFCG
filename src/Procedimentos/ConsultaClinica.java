package Procedimentos;

import Paciente.Paciente;
/**
 * Classe responsavel pelas caracteristicas do procedimento de consulta clinica
 * */
public class ConsultaClinica implements Iprocedimentos{
	private final double PRECO = 12500;
	/**
	 * Realiza uma consulta, armazena no prontuario e retorna o valor do procedimento
	 * @param paciente que sera submetido ao procedimento
	 * @return valor referente ao procedimento
	 * */
	@Override
	public double realizarProcedimento(Paciente paciente) {
		paciente.registrarProcedimento("Consulta Clinica");
		return PRECO;
	}

}
