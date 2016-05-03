package projetoRPI;

import java.time.LocalDate;


import exceptions.DadoInvalidoException;
import exceptions.DataInvalidaException;

public class Util {

	public boolean verificaLogin(Funcionario logado) {
		if (logado == null) {
			return false;
		}
		return true;
	}

	public void verificaSenha(String senha) throws DadoInvalidoException {
		if (senha == null) {
			throw new DadoInvalidoException("Senha nao pode ser nula.");
		} else if (senha.trim().equals("")) {
			throw new DadoInvalidoException("Senha nao pode ser vazia");
		}
	}

	public void verificaSenhaAtualizada(String senha)
			throws DadoInvalidoException {
		verificaSenha(senha);
		if (senha.length() < 8 || senha.length() > 12) {
			throw new DadoInvalidoException(
					"senha deve ter entre 8 - 12 caracteres alfanumericos.");
		}
	}

	public void verificaMatricula(String matricula)
			throws DadoInvalidoException {
		if (matricula == null) {
			throw new DadoInvalidoException("Matricula nao pode ser nula.");
		} else if (matricula.trim().equals("")) {
			throw new DadoInvalidoException("Matricula nao pode ser vazia");
		}
	}

	public void verificaPadraoMatricula(String matricula)
			throws DadoInvalidoException {
		verificaMatricula(matricula);
		if (!matricula.matches("^(\\d{8})$")) { // so pode ter 8 numeros
			throw new DadoInvalidoException("Matricula nao segue o padrao");
		}
	}

	public void verificaAtributo(String atributo) throws DadoInvalidoException {

		if (atributo == null) {
			throw new DadoInvalidoException("Atributo nao pode ser nulo.");
		} else if (atributo.equals("")) {
			throw new DadoInvalidoException("Atributo nao pode ser vazio.");
		} 
	}
	
	public void verificaNome(String nome) throws DadoInvalidoException{
		if(nome == null){
			throw new DadoInvalidoException("Nome do funcionario nao pode ser nulo.");
		}else if (nome.equals("")) {
			throw new DadoInvalidoException("Nome do funcionario nao pode ser vazio.");
		} 
	}
	public void verificaCargo(String cargo) throws DadoInvalidoException{
		if(cargo == null){
			throw new DadoInvalidoException("Nome do cargo nao pode ser nulo.");
		}else if (cargo.equals("")) {
			throw new DadoInvalidoException("Nome do cargo nao pode ser vazio.");
		}else if(!(cargo.equalsIgnoreCase("Medico") || cargo.equalsIgnoreCase("Tecnico Administrativo") || cargo.equalsIgnoreCase("Diretor") || cargo.equalsIgnoreCase("Tecnico")))
			throw new DadoInvalidoException("Cargo invalido.");
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
	
	public String formataData(String data) {
		
		String[] newDate = data.split("/");
		
		String dia = newDate[0];
		String mes = newDate[1];
		String ano = newDate[2];
		String dataFormatada = ano + "-" + mes + "-" + dia;
		
		return dataFormatada;
	}
	
	
}
