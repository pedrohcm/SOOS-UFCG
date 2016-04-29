package factories;

import projetoRPI.Medicamento;
import projetoRPI.TiposMedicamento;

public class MedicamentoFactory {

	public MedicamentoFactory() {
		
	}
	
	public Medicamento criaMedicamento(String nome, double preco, int quantidade, TiposMedicamento categoria, String tipo) {
		if(tipo.trim().equals("Generico")) {
			return criaMedicamentoGenerico(nome, preco, quantidade, categoria);
		}
		if(tipo.trim().equals("Referencia")) {
			return criaMedicamentoReferencia(nome, preco, quantidade, categoria);
		}
		return null;
		// lancar excecao aqui (caso nao seja nenhum dos tipos)
	}
	
	
	private Medicamento criaMedicamentoGenerico(String nome, double preco, int quantidade, TiposMedicamento categoria) {
		Medicamento novoGenerico = new Medicamento(nome, preco, quantidade, categoria);
		return novoGenerico;
	}
	
	private Medicamento criaMedicamentoReferencia(String nome, double preco, int quantidade, TiposMedicamento categoria) {
		Medicamento novoReferencia = new Medicamento(nome, preco, quantidade, categoria);
		return novoReferencia;
	}
}
