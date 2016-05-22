package Procedimentos;

import Exceptions.ProcedimentoException;
import Paciente.Paciente;
/**
 * Interface responsavel pela variacao dos tipos de procedimento
 * */
public interface Iprocedimentos {
	public double realizarProcedimento(Paciente paciente) throws ProcedimentoException;
}