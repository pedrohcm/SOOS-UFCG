package Factory;

import Medicamentos.Medicamento;
import Medicamentos.MedicamentoReferencia;

public class MedicamentoFactory {

	public MedicamentoFactory() {
		
	}
	
	public Medicamento criaMedicamento(String nome, String tipo, double preco, int quantidade, String categorias) {
		if(tipo.trim().equalsIgnoreCase("generico")) {
			return criaMedicamentoGenerico(nome, preco, quantidade, categorias);
		}
		if(tipo.trim().equalsIgnoreCase("Referencia")) {
			return criaMedicamentoReferencia(nome, preco, quantidade, categorias);
		}
		return null;
		// lancar excecao aqui (caso nao seja nenhum dos tipos)
	}
	
	
	private Medicamento criaMedicamentoGenerico(String nome, double preco, int quantidade, String categorias) {
		Medicamento novoGenerico = new Medicamento(nome, preco, quantidade, categorias);
		return novoGenerico;
	}
	
	private Medicamento criaMedicamentoReferencia(String nome, double preco, int quantidade, String categorias) {
		Medicamento novoReferencia = new MedicamentoReferencia(nome, preco, quantidade, categorias);
		return novoReferencia;
	}
}
