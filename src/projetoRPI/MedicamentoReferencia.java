package projetoRPI;

public class MedicamentoReferencia extends Medicamento {

	public MedicamentoReferencia(String nome, double preco, int quantidade, String categorias) {
		super(nome, preco, quantidade, categorias);
	}
	
	@Override
	public String getTipo() {
		return "Referencia";
	}
	
	@Override
	public double getPreco() {
		return super.getPreco() * 0.6; // 40% de desconto
	}

	@Override
	public String toString() {
		String texto = String.format("Medicamento de Referencia: %s - Preço: %.2f - Disponivel: %d - Categorias: %s", getNome(), getPreco(), getQuantidade(), getCategorias());
		return texto;
	}
	
}
