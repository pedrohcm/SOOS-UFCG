package Medicamentos;

public class MedicamentoReferencia extends Medicamento {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Construtor de medicamento por referencia
	 * @param nome associa ao nome
	 * @param preco associa ao preco
	 * @param quantidade associa a quantidade
	 * @param categorias associa as categorias
	 */
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
