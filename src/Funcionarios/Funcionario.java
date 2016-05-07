package Funcionarios;

import Exceptions.FuncionarioException;

public class Funcionario {
	private String nome;
	private String matricula;
	private String senha;
	private String data;
	private String cargo;
	
	public Funcionario(String nome,String matricula,String senha,String data,String cargo) throws FuncionarioException{
		verifica(nome,matricula,senha);
		this.nome = nome;
		this.matricula = matricula;
		this.data = data;
		this.senha = senha;
		this.cargo = cargo;
	}
	private void verifica(String nome,String matricula,String senha) throws FuncionarioException{
		verificaNome(nome);
		verificaMatricula(matricula);
		verificaSenha(senha);
	}
	public String getMatricula(){
		return this.matricula;
	}
	public String getSenha(){
		return this.senha;
	}
	public String getNome(){
		return this.nome;
	}
	public String getCargo(){
		return this.cargo;
	}
	public String getData(){
		return formataData(this.data);
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setSenha(String senha){
		this.senha = senha;
	}
	public void setData(String data){
		this.data = data;
	}
	
	private void verificaSenha(String senha) throws FuncionarioException{
		if (senha.equals("") || senha == null){
			throw new FuncionarioException("Senha invalida.");
		}
	}
	private void verificaMatricula(String matricula) throws FuncionarioException{
		if (matricula.equals("") || matricula == null){
			throw new FuncionarioException("Matricula Inválida!");
		}
	}
	private void verificaNome(String nome) throws FuncionarioException{
		if (nome.equals("") || nome == null){
			throw new FuncionarioException("Nome do funcionario nao pode ser vazio.");
		}
	}
	private String formataData(String data) {
		
		String[] newDate = data.split("/");
		
		String dia = newDate[0];
		String mes = newDate[1];
		String ano = newDate[2];
		String dataFormatada = ano + "-" + mes + "-" + dia;
		
		return dataFormatada;
	}
	public void confirmarSenha(String senha) throws FuncionarioException{
		if (!senha.equals(this.senha)){
			throw new FuncionarioException("Senha invalida.");
		}
	}
}
