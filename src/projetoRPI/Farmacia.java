package projetoRPI;

import java.util.Collections;
import java.util.LinkedList;

import factories.MedicamentoFactory;

public class Farmacia {
	
	private MedicamentoFactory factory;
	private LinkedList<Medicamento> colecaoMedicamentos;

	public Farmacia() {
		factory = new MedicamentoFactory();
	}
	
	public boolean adicionaMedicamento(String nome, double preco, int quantidade, TiposMedicamento categoria, String tipo) {
		 Medicamento novo = factory.criaMedicamento(nome, preco, quantidade, categoria, tipo);
		 colecaoMedicamentos.add(novo);
		 return true;
	}
	
	private Medicamento getMedicamento(String nomeRemedio) {
		for(Medicamento remedio: colecaoMedicamentos) {
			if(remedio.getNome().equals(nomeRemedio)) {
				return remedio;
			}
		}
		return null; // lancar excecao aqui
	}
	
	public LinkedList<Medicamento> consultaPorCategoria(TiposMedicamento categoria) {
		LinkedList<Medicamento> listaCategoria = new LinkedList<Medicamento>();
		for(Medicamento medicamento: colecaoMedicamentos) {
			if(medicamento.contemCategoria(categoria)) {
				listaCategoria.add(medicamento);
			}
		}
		Collections.sort(listaCategoria);
		return listaCategoria;
	}
	
	public String consultaInfo(String nomeRemedio) {
		return getMedicamento(nomeRemedio).toString();
	}
	
}
