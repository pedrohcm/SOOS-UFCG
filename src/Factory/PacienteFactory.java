package Factory;

import Exceptions.DataInvalidaException;
import Exceptions.PacienteException;
import Paciente.Paciente;

public class PacienteFactory {
	private int ID;
	public PacienteFactory(){
		ID = 1;
		
	}

	public Paciente criarPaciente(String nome,String nascimento,double peso,String sexo,String genero,String tipoSanguineo) throws PacienteException, DataInvalidaException{
		Paciente paciente = new Paciente(nome,nascimento,peso,sexo,genero,tipoSanguineo,ID);
		ID++;
		return paciente;
	}

}
