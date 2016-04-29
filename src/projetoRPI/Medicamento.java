package projetoRPI;

import java.util.LinkedList;

public class Medicamento implements Comparable<Medicamento> { //generico
	private String nome;
	private double preco;
	private int quantidade;
	private LinkedList <TiposMedicamento> categorias = new LinkedList <TiposMedicamento>();
	
	public Medicamento(String nome, double preco, int quantidade, TiposMedicamento categoria) {
		// lembrar das excecoes aqui de valores invalidos		
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		categorias.add(categoria);
		// obs: como pode ter mais de uma categoria, criei um metodo que adiciona mais
		// categorias ao medicamento, mas tambem da pra colocar pra receber uma colecao
		// de categorias logo no construtor, mas nao sei se estaria certo...
	}
	
	public boolean adicionaCategoria(TiposMedicamento novaCategoria) {
		categorias.add(novaCategoria);
		return true;
	}
	
	public void adicionaQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public boolean contemCategoria(TiposMedicamento categoria) {
		if(categorias.contains(categoria)) {
			return true;
		}
		return false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	private String listaCategorias() {
		String lista = "";
		for(TiposMedicamento tipo: categorias) {
			lista += tipo.toString();
			lista += " ";
		}
		return lista;
	}
	
	@Override
	public String toString() {
		String texto = String.format("Nome: %s | Preco: %.2f | Quantidade: %i | Categorias: %s", nome, preco, quantidade, listaCategorias());
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
