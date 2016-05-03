package factories;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import exceptions.DataInvalidaException;
import projetoRPI.Diretor;
import projetoRPI.Medico;
import projetoRPI.Tecnico;
import projetoRPI.Funcionario;
import projetoRPI.Util;
public class UsuarioFactory {

	
	final String prefixoDiretor = "1";
	final String prefixoMedico = "2";
	final String prefixoTecnico = "3";
	private Util util;
	
	public UsuarioFactory() {
		util = new Util();
	}

	public Funcionario criaUsuario(String nome, String cargo, String data) throws DataInvalidaException{
		
		String matricula = "";
		String senha = "";
		LocalDate dataFormatada = util.dataFormatChanges(data);
		DateTimeFormatter formatadorAno =  DateTimeFormatter.ofPattern("yyyy");
		String ano = dataFormatada.format(formatadorAno);
		
		LocalDate hoje = LocalDate.now();
		String anoAtual = hoje.format(formatadorAno);
		

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
		
		if(cargo.toUpperCase().equalsIgnoreCase("TECNICO ADMINISTRATIVO")){
			matricula = prefixoTecnico + anoAtual + "001" ;
			senha = ano + matricula.subSequence(0,4);
			Funcionario usuario = new Tecnico(nome, matricula, senha, data);
			return usuario;
		}
		
		// LANCAR EXCECAO AQUI
		return null;
	}
	

	
}
