package factories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exceptions.DataInvalidaException;
import projetoRPI.Diretor;
import projetoRPI.Medico;
import projetoRPI.Tecnico;
import projetoRPI.Funcionario;

public class UsuarioFactory {

	
	final String prefixoDiretor = "1";
	final String prefixoMedico = "2";
	final String prefixoTecnico = "3";

	public UsuarioFactory() {

	}

	public Funcionario criaUsuario(String nome, String cargo, String data) throws DataInvalidaException{
		
		String matricula = "";
		String senha = "";
		LocalDate dataFormatada = dataFormatChanges(data);
		DateTimeFormatter formatador =  DateTimeFormatter.ofPattern("yyyy");
		String ano = dataFormatada.format(formatador);
		
		LocalDate hoje = LocalDate.now();
		String anoAtual = hoje.format(formatador);
		

		if(cargo.toUpperCase().equalsIgnoreCase("DIRETOR")){
			matricula = prefixoDiretor + anoAtual + "001" ;
			senha = ano + matricula.subSequence(0,4);
			Funcionario usuario = new Diretor(nome, matricula, senha, data);
			return usuario;
		}
		
		if(cargo.toUpperCase().equalsIgnoreCase("MEDICO")){
			matricula = prefixoMedico + anoAtual + "001" ;
			senha = ano + matricula.subSequence(0,4);
			Funcionario usuario = new Medico(nome, matricula, senha, data);
			return usuario;
		}
		
		if(cargo.toUpperCase().equalsIgnoreCase("TECNICO")){
			matricula = prefixoTecnico + anoAtual + "001" ;
			senha = ano + matricula.subSequence(0,4);
			Funcionario usuario = new Tecnico(nome, matricula, senha, data);
			return usuario;
		}
		
		// LANCAR EXCECAO AQUI
		return null;
	}
	

	public LocalDate dataFormatChanges(String data) throws DataInvalidaException { 

		String[] newDate = data.split("/");
		
		LocalDate hoje = LocalDate.now();
		int anoAtual = hoje.getYear();

		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);
		
		if( (dia < 1 || dia > 31)  || (mes < 1 || mes > 12) || (ano > anoAtual) ){
			throw new DataInvalidaException();
			
		}
		LocalDate date;
		date = LocalDate.of(ano, mes, dia);
		
		return date;

	}
}
