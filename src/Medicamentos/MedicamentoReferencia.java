package Medicamentos;

public class MedicamentoReferencia extends Medicamento {

	public MedicamentoReferencia(String nome, double preco, int quantidade, String categorias) {
		super(nome, preco, quantidade, categorias);
	}
	
	@Override
	public String getTipo() {
		return "de Referencia";
	}
	
	@Override
	public double getPreco() {
		return getPrecoBase();
	}
	

	@Override
	public String toString() {
		String texto = String.format("Medicamento de Referencia: %s - Preco: R$ %.2f - Disponivel: %d - Categorias: %s", getNome(), getPreco(), getQuantidade(), getCategorias());
		return texto;
	}
	
}
