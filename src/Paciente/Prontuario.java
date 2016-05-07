package Paciente;

import java.time.LocalDate;
import java.time.Month;

public class Prontuario{
	private String nome;
	private String nascimento;
	private double peso;
	private String tipoSanguineo;
	private String sexo;
	private String genero;
	private int id;
	
	
	public Prontuario(String nome,String nascimento,double peso,String sexo,String genero,String tipoSanguineo,int id){
		this.nome = nome;
		this.nascimento = nascimento;
		this.peso = peso;
		this.tipoSanguineo = tipoSanguineo;
		this.sexo = sexo;
		this.genero = genero;
		this.id = id;
	}
	
	public String getNome(){
		return this.nome;
	}
	public String getNascimento(){
		return this.nascimento;
	}
	public Double getPeso(){
		return this.peso;
	}
	public String getTipoSanguineo(){
		return this.tipoSanguineo;
	}
	public String getSexo(){
		return this.sexo;
	}
	public String getGenero(){
		return this.genero;
	}
	public int getID(){
		return this.id;
	}
	public String getData(){
		return formataData(this.nascimento);
	}
	private String formataData(String data) {
		
		String[] newDate = data.split("/");
		
		String dia = newDate[0];
		String mes = newDate[1];
		String ano = newDate[2];
		String dataFormatada = ano + "-" + mes + "-" + dia;
		
		return dataFormatada;
	}
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
	
}
