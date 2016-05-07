package Paciente;

import java.util.ArrayList;
import java.util.Collections;

import Exceptions.ControllerException;
import Exceptions.DataInvalidaException;
import Exceptions.PacienteException;
import Factory.PacienteFactory;

public class BancoPacientes {
	private ArrayList<Paciente> pacientes;
	private PacienteFactory factoryPacientes;
	
	public BancoPacientes() {
		pacientes = new ArrayList<Paciente>();
		factoryPacientes = new PacienteFactory();
	}
	
	public String cadastrarPaciente(String nome,String nascimento,double peso,String sexo,String genero,String tipoSanguineo) throws PacienteException, DataInvalidaException{
		existePaciente(nome);
		Paciente paciente = factoryPacientes.criarPaciente(nome, nascimento, peso, sexo, genero,tipoSanguineo);
		pacientes.add(paciente);
		String mensagem = String.format("%d", paciente.getID());
		return mensagem;
	}
	
	public String getInfoPaciente(String id, String atributo) {
		Paciente paciente = buscaPaciente(id);
		atributo = atributo.toLowerCase();
		switch(atributo){
			case "nome":
				return paciente.AcessarInformacoes(atributo);
			case "data":
				return paciente.AcessarInformacoes(atributo);
			case "sexo":
				return paciente.AcessarInformacoes(atributo);
			case "genero":
				return paciente.AcessarInformacoes(atributo);
			case "tiposanguineo":
				return paciente.AcessarInformacoes(atributo);
			case "idade":
				return paciente.AcessarInformacoes(atributo);
			case "peso":
				String peso = String.format("%.1f", paciente.getPeso());
				peso =  peso.replace(",", ".");
				return peso;
			default:
				return "Atributo invalido.";
		}
	}
	
	public void existePaciente(String nome) throws PacienteException{
		if(getPaciente(nome) != null){
			throw new PacienteException("Paciente ja cadastrado.");
		}
	}
	
	public Paciente buscaPaciente(String id){
		for (Paciente paciente : pacientes){
			String ID = String.format("%d",paciente.getID());
			if (ID.equals(id)){
				return paciente;
			}
		}
		return null;
	}
	
	public Paciente getPaciente(String nome){
		for (Paciente paciente : pacientes){
			if (paciente.AcessarInformacoes("nome").equals(nome)){
				return paciente;
			}
		}
		return null;
	}
	
	public String getProntuario(int posicao) throws ControllerException, PacienteException {
		ordernaListaPacientes();
		Paciente paciente = getPaciente(posicao);
		int ID = paciente.getID();
		String IDString = String.format("%d", ID);
		return IDString;
	}
	
	public Paciente getPaciente(int posicao) throws PacienteException{
		verificaTamanhoLista(posicao);
		return pacientes.get(posicao);
	}
	
	public void adicionaNoBancoDeDados(Paciente paciente) throws PacienteException{
		verificaPaciente(paciente);
		pacientes.add(paciente);
	}
	
	public void ordernaListaPacientes() {
		Collections.sort(pacientes);
	}
	
	private void verificaPaciente(Paciente paciente) throws PacienteException{
		if (paciente == null){
			throw new PacienteException("Paciente nulo");
		}
	}
	
	
	private void verificaTamanhoLista(int posicao) throws PacienteException{
		if (pacientes.size() < posicao){
			throw new PacienteException("Nao ha prontuarios suficientes (max = " + pacientes.size() + ").");
		}
	}

}
