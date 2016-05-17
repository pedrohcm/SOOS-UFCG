package Paciente;

import java.time.LocalDate;
import java.util.LinkedList;

import Exceptions.ProcedimentoException;


public class Prontuario{
	private String nome;
	private String nascimento;
	private double peso;
	private String tipoSanguineo;
	private String sexo;
	private String genero;
	private int id;
	private LinkedList<String> listadeprocedimentos;
	

	
	
	
	/**
	 * Construtor de Prontuario
	 * @param nome associa ao nome
	 * @param nascimento associa a data de nascimento
	 * @param peso associa ao peso
	 * @param sexo associa ao sexo
	 * @param genero associa ao genero
	 * @param tipoSanguineo associa ao tipo sanguineo
	 * @param id
	 */
	public Prontuario(String nome,String nascimento,double peso,String sexo,String genero,String tipoSanguineo,int id){
		this.nome = nome;
		this.nascimento = nascimento;
		this.peso = peso;
		this.tipoSanguineo = tipoSanguineo;
		this.sexo = sexo;
		this.genero = genero;
		this.id = id;
		
		listadeprocedimentos = new LinkedList<String>();
		
	}
	
	/**
	 * Recupera o nome.
	 * @return nome
	 */
	public String getNome(){
		return this.nome;
	}
	/**
	 * Recupera a data de nascimento.
	 * @return data de nascimento
	 */
	public String getNascimento(){
		return this.nascimento;
	}
	/**
	 * Recupera o peso.
	 * @return peso.
	 */
	public Double getPeso(){
		return this.peso;
	}
	/**
	 * Recupera o tipo sanguineo
	 * @return tipo sanguineo
	 */
	public String getTipoSanguineo(){
		return this.tipoSanguineo;
	}
	/**
	 * Recupera o sexo
	 * @return sexo
	 */
	public String getSexo(){
		return this.sexo;
	}
	/**
	 * Recupera o genero.
	 * @return genero.
	 */
	public String getGenero(){
		return this.genero;
	}
	
	/**
	 * Recupera o id
	 * @return id
	 */
	public int getID(){
		return this.id;
	}
	/**
	 * Recupera a data de nascimento
	 * @return data de nascimento
	 */
	public String getData(){
		return formataData(this.nascimento);
	}
	/**
	 * Formata a data de nascimento
	 * @param data Data de nascimento do paciente
	 * @return data formatada
	 */
	private String formataData(String data) {
		
		String[] newDate = data.split("/");
		
		String dia = newDate[0];
		String mes = newDate[1];
		String ano = newDate[2];
		String dataFormatada = ano + "-" + mes + "-" + dia;
		
		return dataFormatada;
	}
	/**
	 * Recupera a idade
	 * @return idade
	 */
	public String getIdade(){
		String[] newDate = this.nascimento.split("/");
		int mesNascimento = Integer.parseInt(newDate[1]);
		int anoNascimento = Integer.parseInt(newDate[2]);
		int mesAtual = LocalDate.now().getMonthValue();
		int anoAtual = LocalDate.now().getYear();
		
		int idade = anoAtual - anoNascimento;
		if (mesAtual < mesNascimento){
			idade = idade - 1;
			String idadeString = String.format("%d", idade);
			return idadeString;
		}
		String idadeString = String.format("%d", idade);
		return idadeString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prontuario other = (Prontuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Prontuario [nome=" + nome + ", nascimento=" + nascimento + ", peso=" + peso + ", tipoSanguineo="
				+ tipoSanguineo + ", sexo=" + sexo + ", genero=" + genero + ", id=" + id + "]";
	}
	/**
	 * Adiciona o procedimento efetuado na lista de procedimentos do prontuario
	 * @throws ProcedimentoException 
	 * */
	public void adicionarProcedimentoALista(String procedimento) throws ProcedimentoException{
		
		listadeprocedimentos.add(procedimento);

	}
		
	/**
	 * Modifica o peso do paciente
	 * */
	public void setPeso(double peso){
		this.peso = peso;
	}
	/**
	 * Modifica o Genero do Paciente
	 * */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * Recupera o tamanho da lista de procedimentos do prontuario
	 * @return Quantidade de procedimentos
	 * */
	public int getProcedimentosSize() {
		return listadeprocedimentos.size();
	}
}
