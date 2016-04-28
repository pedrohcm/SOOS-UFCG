package projetoRPI;
// Neto : Que coisa sebosa kkkkkkk

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioFactory {

	final String prefixoMedico = "1";
	final String prefixoDiretor = "2";
	final String prefixoTecnico = "3";

	public UsuarioFactory() {

	}

	public Usuario criaUsuario(String nome, String cargo, String data){
		
		String matricula = "";
		String senha = "";
		LocalDate dataFormatada = dataFormatChanges(data);
		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy");
		String ano = dataFormatada.format(formatter);
		
		LocalDate hoje = LocalDate.now();
		String anoAtual = hoje.format(formatter);
		
		if(cargo.toUpperCase().equals("DIRETOR")){
			matricula = prefixoDiretor + anoAtual + "001" ;// falta ajeitar aqui 
			senha = ano + matricula.subSequence(0,5); // Fazer os testes para ver se ta ok mesmo a data
			Usuario usuario = new Diretor(matricula,senha);
			return usuario;
		}
		
		if(cargo.toUpperCase().equals("MEDICO")){
			matricula = prefixoMedico + anoAtual + "001" ;// falta ajeitar aqui 
			senha = ano + matricula.subSequence(0,5);
			Usuario usuario = new Medico(matricula,senha);
			return usuario;
		}
		
		if(cargo.toUpperCase().equals("TECNICO")){
			matricula = prefixoTecnico + anoAtual + "001" ;// falta ajeitar aqui 
			senha = ano + matricula.subSequence(0,5);
			Usuario usuario = new Tecnico(matricula,senha);
			return usuario;
		}
		
		// LANCAR EXCEÇAO AQUI
		
		
		return null;
	}

	public LocalDate dataFormatChanges(String data) { // Credito a Sueallany. Ela me deu essa implementação

		String[] newDate = data.split("/");

		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);

		LocalDate date;
		date = LocalDate.of(ano, mes, dia);
		// try{
		// date = LocalDate.of(ano, mes, dia);
		// } catch(DateTimeException e){
		// throw new DadoInvalidoException("Data nao existe.");
		// }
		return date;

	}
}
