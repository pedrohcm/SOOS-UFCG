package projetoRPI;

public class MedicamentoReferencia extends Medicamento {

	public MedicamentoReferencia(String nome, double preco, int quantidade, TiposMedicamento categoria) {
		super(nome, preco, quantidade, categoria);
	}
	
	@Override
	public double getPreco() {
		return super.getPreco() * 0.6; // 40% de desconto
	}

}
