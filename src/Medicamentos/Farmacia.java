package Medicamentos;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import Exceptions.ControllerException;
import Exceptions.MedicamentoException;
import Factory.MedicamentoFactory;

public class Farmacia {
	private LinkedList<Medicamento> listaMedicamentos;
	private MedicamentoFactory factoryMedicamentos;
	
	public Farmacia() {
		listaMedicamentos = new LinkedList<Medicamento>();
		factoryMedicamentos = new MedicamentoFactory();
	}
	

	public String cadastrarMedicamento(String nome, String tipo, double preco, int quantidade, String categorias) throws MedicamentoException {
		Medicamento remedio = factoryMedicamentos.criaMedicamento(nome, tipo, preco, quantidade, categorias);
		listaMedicamentos.add(remedio);
		return remedio.getNome();
	}
	
	
	/**
	 * Recupera o Medicamento
	 * @param nome associa ao nome do medicamento
	 * @return
	 */
	public Medicamento getMedicamento(String nome) {
		for(Medicamento medicamento: listaMedicamentos) {
			if(medicamento.getNome().equalsIgnoreCase(nome)) {
				return medicamento;
			}	
		}
		return null;
	}
	
	/**
	 * Recupera informacoes do Medicamentos
	 * @param atributo associa ao atributo
	 * @param nome associa ao nome 
	 * @return a informação pedida
	 * @throws ControllerException
	 */
	public String getInfoMedicamento(String atributo, String nome) throws ControllerException {
		Medicamento remedio = verificarMedicamento(nome);
		atributo = atributo.toLowerCase();
		switch (atributo) {
			case "tipo":
				return remedio.getTipo();
			case "preco":
				String valor = String.format("%.1f", remedio.getPreco());
				valor =  valor.replace(",", ".");
				return valor;
			case "quantidade":
				return String.valueOf(remedio.getQuantidade());
			case "categorias":
				return remedio.getCategorias();
			default:
				return "Atributo Invalido.";
		}
	}
	
	public void atualizaPrecoMedicamento(String nome, double novoPreco) throws ControllerException {
		Medicamento remedio = verificarMedicamento(nome);
		remedio.setPreco(novoPreco);
	}
	
	public void atualizaQuantMedicamento(String nome, int novaQuant) throws ControllerException {
		Medicamento remedio = verificarMedicamento(nome);
		remedio.setQuantidade(novaQuant);
	}
	
	/**
	 * Consulta Medicamento pelo nome
	 * @param nome associa ao nome
	 * @return	informações do medicamento caso exista
	 * @throws ControllerException
	 */
	public String consultaMedNome(String nome) throws ControllerException {
		Medicamento remedio = getMedicamento(nome);
		if(remedio == null) {
			throw new ControllerException("Medicamento nao cadastrado.");
		}
		return remedio.toString();
	}
	
	
	public void adicionaNoBancoDeDados(Medicamento remedio) throws MedicamentoException {
		verificaMedicamento(remedio);
		listaMedicamentos.add(remedio);
	}
	
	private void verificaMedicamento(Medicamento remedio) throws MedicamentoException {
		if(remedio == null) {
			throw new MedicamentoException("Medicamento nulo");
		}
	}
	
	private void verificaCategoria(String tipos) throws MedicamentoException {
		String[] categoriasSeparadas = tipos.split(",");
		boolean contem = false;
		for(TiposMedicamento tipo: TiposMedicamento.values()) {
			for(String categoria: categoriasSeparadas) {
				if(tipo.name().equalsIgnoreCase(categoria)) {
					contem = true;
				}
			}
		}
		if(!contem) {
			throw new MedicamentoException("Categoria invalida.");
		}
		
	}
	
	/**
	 * Busca medicamento por categoria
	 * @param categoria associa a categoria dele
	 * @return
	 * @throws MedicamentoException
	 */
	public String buscaMedicamentoCategoria(String categoria) throws MedicamentoException {
		verificaCategoria(categoria);
		String remedios = "";
		sortedMedicamentosPreco();
		for(Medicamento medicamento: listaMedicamentos) {
			if(medicamento.contemCategoria(categoria)) {
				remedios += medicamento.getNome() + ",";
			}
		}
		if(remedios == "") {
			throw new MedicamentoException("Nao ha remedios cadastrados nessa categoria.");
		}
		 return remedios.substring(0, (remedios.length()-1));
	}
	
	/**
	 * Organiza os medicamentos pelo nome
	 */
	private void sortedMedicamentosNome(){
		Collections.sort(listaMedicamentos, new Comparator<Medicamento>() {
			public int compare(Medicamento o1, Medicamento o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
	}
	
	public void sortedMedicamentos() {
		Collections.sort(listaMedicamentos);
	}
	
	/**
	 * Organiza pelo preco
	 */
	public void sortedMedicamentosPreco() {
		Collections.sort(listaMedicamentos, new Comparator<Medicamento>() {
			
			public int compare(Medicamento o1, Medicamento o2) {
				if (o1.getPreco() > o2.getPreco()) {
					return 1;
				} else if (o1.getPreco() < o2.getPreco()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
	}
	
	/**
	 * Ordenar a lista de Medicamentos
	 * @param ordenacao
	 * @return
	 */
	public String getListaOrdenada(String ordenacao){
		
		if(ordenacao.equalsIgnoreCase("alfabetica")){
			sortedMedicamentosNome();
			
		}
		else{
			sortedMedicamentosPreco();
			
		}
		String nomedosmedicamentos = "";
		for (Medicamento medicamento : listaMedicamentos){
				nomedosmedicamentos += medicamento.getNome() + ",";
		}
		nomedosmedicamentos = (String) nomedosmedicamentos.subSequence(0, nomedosmedicamentos.length() - 1);
		return nomedosmedicamentos;
	}
	

	/**
	 * Verifica se o Objeto Medicamento é um objeto válido
	 * @throws ControllerException
	 * */
	private Medicamento verificarMedicamento(String nome) throws ControllerException {
		if(getMedicamento(nome) == null) {
			throw new ControllerException("Medicamento nao cadastrado.");
		}
		return getMedicamento(nome);
	}
	
	
}
