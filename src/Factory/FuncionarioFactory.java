package Factory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Exceptions.DataInvalidaException;
import Exceptions.FuncionarioException;
import Funcionarios.Diretor;
import Funcionarios.Funcionario;
import Funcionarios.Medico;
import Funcionarios.Tecnico;

public class FuncionarioFactory {
	private int numeroDeContas;
	final String prefixoDiretor = "1";
	final String prefixoMedico = "2";
	final String prefixoTecnico = "3";
	
	public FuncionarioFactory(){
		numeroDeContas = 1;
	}
	
	
	public Funcionario criaUsuario(String nome, String cargo, String data) throws DataInvalidaException, FuncionarioException{
		
		String matricula = gerarMatricula(cargo);
		LocalDate dataFormatada = dataFormatChanges(data);
		DateTimeFormatter formatadorAno =  DateTimeFormatter.ofPattern("yyyy");
		String ano = dataFormatada.format(formatadorAno);
		
		String senha = gerarSenha(matricula,ano);
		

		if(cargo.toUpperCase().equalsIgnoreCase("DIRETOR GERAL")){
			Funcionario usuario = new Diretor(nome, matricula, senha, data,cargo);
			numeroDeContas++;
			return usuario;
		}
		
		if(cargo.toUpperCase().equalsIgnoreCase("MEDICO")){
			Funcionario usuario = new Medico(nome, matricula, senha, data,cargo);
			numeroDeContas++;
			return usuario;
		}
		
		if(cargo.toUpperCase().equalsIgnoreCase("TECNICO ADMINISTRATIVO")){
			Funcionario usuario = new Tecnico(nome, matricula, senha, data,cargo);
			numeroDeContas++;
			return usuario;
		}
		
		
		return null;
	}
	
	private String gerarMatricula(String cargo){
		cargo = cargo.toLowerCase();
		String matricula;
		switch(cargo){
			case "diretor geral":
			matricula = "1" + LocalDate.now().getYear() + String.format("%03d", numeroDeContas);
			return matricula;
		case  "medico":
			matricula = "2" + LocalDate.now().getYear() + String.format("%03d", numeroDeContas);
			return matricula;
		case "tecnico administrativo":
			matricula = "3" + LocalDate.now().getYear() + String.format("%03d", numeroDeContas);
			return matricula;
		}
	return "Cargo Invalido.";
	}
	
	
	private String gerarSenha(String matricula, String ano){
		String senha = ano + matricula.subSequence(0,4);
		return senha;
	}
	

	private LocalDate dataFormatChanges(String data) throws DataInvalidaException { 

		String[] newDate = data.split("/");
	
		LocalDate hoje = LocalDate.now();
		int anoAtual = hoje.getYear();

		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);
	
		if( (dia < 1 || dia > 31)  || (mes < 1 || mes > 12) || (ano > anoAtual) ){
			throw new DataInvalidaException("Data invalida.");
		
		}
		LocalDate date;
		date = LocalDate.of(ano, mes, dia);
	
		return date;

	}
}
