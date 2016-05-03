package projetoRPI;

import exceptions.DadoInvalidoException;

public class Util {
		
	public boolean verificaLogin(Funcionario logado) {
		if(logado == null) {
			return false;
		}
		return true;
	}
	
	public void verificaSenha(String senha) throws DadoInvalidoException {
		if(senha == null) {
			throw new DadoInvalidoException("Senha nao pode ser nula.");
		} else if(senha.trim().equals("")) {
			throw new DadoInvalidoException("Senha nao pode ser vazia");
		}
	}
	
	public void verificaSenhaAtualizada(String senha) throws DadoInvalidoException {
		verificaSenha(senha);
		if(senha.length() < 8 || senha.length() > 12) {
			throw new DadoInvalidoException("senha deve ter entre 8 - 12 caracteres alfanumericos.");
		}
	}
	
	public void verificaMatricula(String matricula) throws DadoInvalidoException {
		if(matricula == null) {
			throw new DadoInvalidoException("Matricula nao pode ser nula.");
		} else if(matricula.trim().equals("")) {
			throw new DadoInvalidoException("Matricula nao pode ser vazia");
		}
	}
	
	public void verificaPadraoMatricula(String matricula) throws DadoInvalidoException {
		verificaMatricula(matricula);
		if(!matricula.matches("^(\\d{8})$")) { //so pode ter 8 numeros
			throw new DadoInvalidoException("Matricula nao segue o padrao");
		}
	}
	
	
}
