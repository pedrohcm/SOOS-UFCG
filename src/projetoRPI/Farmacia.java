package projetoRPI;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import factories.MedicamentoFactory;

public class Farmacia {

	private MedicamentoFactory factory;
	private LinkedList<Medicamento> colecaoMedicamentos;

	public Farmacia() {
		factory = new MedicamentoFactory();
	}

	public boolean cadastraMedicamento(String nome, String tipo, double preco, int quantidade, String categoria) {
		Medicamento novo = factory.criaMedicamento(nome, tipo, preco, quantidade, categoria);
		colecaoMedicamentos.add(novo);
		return true;
	}
	
	public void atualizaMedicamento(String nome, String atributo, String novoValor) {
		//verificar se o valor eh valido (e lancar excecao se atributo for nome ou tipo)
		
		if(novoValor.equals("preco")) {
			Double valorDouble = Double.parseDouble(novoValor);
			getMedicamento(nome).setPreco(valorDouble);
		}
		if(atributo.equals("quantidade")) {
			int valorInteiro = Integer.parseInt(novoValor);
			getMedicamento(nome).setQuantidade(valorInteiro);
		}
	}
	
	public void getInfoMedicamento(String atributo, Medicamento remedio) {
		switch(atributo) {
			case "tipo":
				System.out.println(remedio.getTipo());
				break;
			case "nome":
				System.out.println(remedio.getNome());
				break;
			case "preco":
				System.out.println(remedio.getPreco());
				break;
			case "quantidade":
				System.out.println(remedio.getQuantidade());
				break;
			case "categorias":
				System.out.println(remedio.getCategorias());
				break;
			default:
				// excecao (atributo invalido)
				break;
		}
	}
	
	private Medicamento getMedicamento(String nomeRemedio) { //verifica se o remedio esta cadastrado
		for (Medicamento remedio : colecaoMedicamentos) {
			if (remedio.getNome().equals(nomeRemedio)) {
				return remedio;
			}
		}
		return null; // lancar excecao aqui
	}

	public String consultaMedCategoria(String categoria) {
		String listaMedicamentos = "";
		verificaCategoria(categoria);
		for (Medicamento medicamento : colecaoMedicamentos) {
			if (medicamento.contemCategoria(categoria)) {
				listaMedicamentos += medicamento.getNome() + ",";
			}
		}
		// ver se a string ainda esta vazia. Se estiver, exception
		return listaMedicamentos.substring(0, listaMedicamentos.length()-1);
	}

	private boolean verificaCategoria(String categoria) {
		for(TiposMedicamento tipo: TiposMedicamento.values()) {
			if(!tipo.toString().equalsIgnoreCase(categoria)) {
				//lancar excecao (categoria invalida);
			}
		}
		return true;
	}

	public String consultaMedNome(String nomeRemedio) {
		return getMedicamento(nomeRemedio).toString();
	}
	// organiza os medicamentos

	public void sortedMedicamentos() {
		Collections.sort(colecaoMedicamentos);
	}

	// organiza por ordem alfabetica

	public void sortedOrdemAlfabetica() {
		Collections.sort(colecaoMedicamentos, new Comparator<Medicamento>() {
			@Override
			public int compare(Medicamento o1, Medicamento o2) {
				return o1.getNome().compareToIgnoreCase(o2.getNome());
			}
		});
	}
}
