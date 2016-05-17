package Procedimentos;

import Exceptions.ProcedimentoException;
import Paciente.Paciente;
/**
 * Classe responsavel pelas caracteristicas do procedimento de redesignacao sexual
 * */
public class RedesignacaoSexual implements Iprocedimentos{
	private final double PRECO = 9300;
	/**
	 * Realiza um procedimento de redesignacao sexual, armazena no prontuario e retorna o valor do procedimento
	 * @param paciente que sera submetido ao procedimento
	 * @return valor referente ao procedimento
	 * @throws ProcedimentoException 
	 * */
	@Override
	public double realizarProcedimento(Paciente paciente) throws ProcedimentoException {
		paciente.registrarProcedimento("Redesignacao Sexual");
		if(paciente.AcessarInformacoes("genero").equals("masculino")){
			paciente.setGenero("feminino");
		}
		else{
			paciente.setGenero("masculino");
		}
		return PRECO;
	}
	
}
