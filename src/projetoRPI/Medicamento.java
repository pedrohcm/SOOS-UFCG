package projetoRPI;

public class Medicamento implements Comparable<Medicamento> { //generico
	private String nome;
	private double preco;
	private int quantidade;
	private String listaCategorias;
	
	public Medicamento(String nome, double preco, int quantidade, String categorias) {
		// lembrar das excecoes aqui de valores invalidos		
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
	
	private boolean associaCategoria(String tipos) {
		String[] categoriasSeparadas = tipos.split(",");
		boolean contem = false;
		for(TiposMedicamento tipo: TiposMedicamento.values()) {
			for(String categoria: categoriasSeparadas) {
				if(tipo.toString().equalsIgnoreCase(categoria)) {
					contem = true;
					listaCategorias += tipo.toString().toLowerCase() + ",";
				}
			}
		}
		if(contem) {
			return true;
		}
		return false;
		//lancar excecao (categorias n existem) e tirar o return false
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
	
	public double getPreco() {
		return preco;
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
		return listaCategorias.substring(0, listaCategorias.length()-1); //tira a ultima virgula
	}
	
	@Override
	public String toString() {
		String texto = String.format("Medicamento Generico: %s - Preço: %.2f - Disponivel: %d - Categorias: %s", getNome(), getPreco(), getQuantidade(), getCategorias());
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
