package projetoRPI;

import java.util.ArrayList;
import java.util.UUID;

public class Paciente {
	private String nome;
	private String dataNascimento;
	private double peso;
	private String sexoBiologico;
	private String genero;
	private String tipoSanguineo;
	private ArrayList<String> prontuario; //acho que o prontuario eh uma colecao de pacientes, onde
	//existe um metodo getInfoPaciente que recebe o objeto Paciente (ou a id) para consultar info
	//do msm (nao sei de certeza)
	private UUID idCriada;
	
	public Paciente(String nome, String data, double peso, String sexoBio, String genero, String tipo) {
		this.nome = nome;
		this.dataNascimento = data;
		this.peso = peso;
		this.sexoBiologico = sexoBio;
		this.genero = genero;
		this.tipoSanguineo = tipo;
		this.prontuario = new ArrayList<String>();
		idCriada = UUID.randomUUID();
		// lancar excecoes de valores invalidos
	}

	public String getNome() {
		return nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	
	/* ainda tem que implementar isso
	public int getIdade() {
		return 
	}
	*/

	public double getPeso() {
		return peso;
	}

	public String getSexoBiologico() {
		return sexoBiologico;
	}
	
	public int getID() {
		return idCriada.version(); //ver se essa funcao retorna o id em int
	}

	public String getGenero() {
		return genero;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public ArrayList<String> getProntuario() {
		return prontuario;
	}
	
	
	
	
	
	
	

}
