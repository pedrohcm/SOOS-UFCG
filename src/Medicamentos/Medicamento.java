package Medicamentos;



public class Medicamento implements Comparable<Medicamento> { 
	private String nome;
	private double preco;
	private int quantidade;
	private String listaCategorias;
	
	public Medicamento(String nome, double preco, int quantidade, String categorias) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		associaCategoria(categorias);
	}
	
	public boolean contemCategoria(String categoria) {
		if(listaCategorias.contains(categoria)) {
			return true;
		}
		return false;
	}
	
	private void associaCategoria(String tipos) {
		String[] categoriasSeparadas = tipos.split(",");
		
		for(TiposMedicamento tipo: TiposMedicamento.values()) {
			for(String categoria: categoriasSeparadas) {
				if(tipo.name().equalsIgnoreCase(categoria)) {
					
					listaCategorias += tipo.toString().toLowerCase() + ",";
				}
			}
		}
	}
	
	public void adicionaQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public String getTipo() {
		return "Generico";
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPrecoBase() {
		return preco;
	}
	
	public double getPreco() {
		return preco * 0.6; 
		}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getCategorias() {
		return listaCategorias.substring(4, (listaCategorias.length()-1));
	}
	
	@Override
	public String toString() {
		String texto = String.format("Medicamento Generico: %s - Preco: R$ %.2f - Disponivel: %d - Categorias: %s", getNome(), getPreco(), getQuantidade(), getCategorias());
		return texto;
	}

	@Override
	public int compareTo(Medicamento medicamento) { //compara pelo menor preco
		if(this.preco < medicamento.getPreco()) {
			return 1;
		}
		if(this.preco > medicamento.getPreco()) {
			return -1;
		}
		return 0;
	}
	
	
}
