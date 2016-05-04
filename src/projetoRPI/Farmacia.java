package projetoRPI;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import exceptions.AtributoInalteravelException;
import exceptions.AtualizaMedicamentoException;
import exceptions.DadoInvalidoException;
import exceptions.ObjetoNaoExisteException;
import factories.MedicamentoFactory;

public class Farmacia {

	private MedicamentoFactory factory;
	private LinkedList<Medicamento> medicamentos;
	private Util util;

	public Farmacia() {
		factory = new MedicamentoFactory();
		util = new Util();
	}

	public boolean cadastraMedicamento(String nome, String tipo, double preco, int quantidade, String categoria) {
		Medicamento novo = factory.criaMedicamento(nome, tipo, preco, quantidade, categoria);
		medicamentos.add(novo);
		return true;
	}
	
	public void atualizaMedicamento(String nome, String atributo, String novoValor) throws ObjetoNaoExisteException, AtualizaMedicamentoException {
		try {
			switch(atributo) {
			case "nome":
				throw new AtributoInalteravelException("Nome do medicamento");
			case "tipo":
				throw new AtributoInalteravelException("Tipo do medicamento");
			case "preco":
				Double valorDouble = Double.parseDouble(novoValor);
				getMedicamento(nome).setPreco(valorDouble);
				break;
			case "quantidade":
				int valorInteiro = Integer.parseInt(novoValor);
				util.verificaQuantidade(valorInteiro);
				getMedicamento(nome).setQuantidade(valorInteiro);
				break;
			default:
				throw new DadoInvalidoException("Atributo invalido");
			}
		} catch (AtributoInalteravelException | DadoInvalidoException e) {
			throw new AtualizaMedicamentoException(e.getMessage());
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
	
	private Medicamento getMedicamento(String nomeRemedio) throws ObjetoNaoExisteException {
		for (Medicamento remedio : medicamentos) {
			if (remedio.getNome().equals(nomeRemedio)) {
				return remedio;
			}
		}
		throw new ObjetoNaoExisteException("Medicamento");
	}

	public String consultaMedCategoria(String categoria) {
		String listaMedicamentos = "";
		verificaCategoria(categoria);
		for (Medicamento medicamento : medicamentos) {
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

	public String consultaMedNome(String nomeRemedio) throws ObjetoNaoExisteException {
		return getMedicamento(nomeRemedio).toString();
	}
	// organiza os medicamentos

	public void sortedMedicamentos() {
		Collections.sort(medicamentos);
	}

	// organiza por ordem alfabetica

	public void sortedOrdemAlfabetica() {
		Collections.sort(medicamentos, new Comparator<Medicamento>() {
			@Override
			public int compare(Medicamento o1, Medicamento o2) {
				return o1.getNome().compareToIgnoreCase(o2.getNome());
			}
		});
	}
}
