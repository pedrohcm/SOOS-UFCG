package factories;

import projetoRPI.Medicamento;

public class MedicamentoFactory {

	public MedicamentoFactory() {
		
	}
	
	public Medicamento criaMedicamento(String nome, String tipo, double preco, int quantidade, String categorias) {
		if(tipo.trim().equals("Generico")) {
			return criaMedicamentoGenerico(nome, preco, quantidade, categorias);
		}
		if(tipo.trim().equals("Referencia")) {
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
		Medicamento novoReferencia = new Medicamento(nome, preco, quantidade, categorias);
		return novoReferencia;
	}
}
