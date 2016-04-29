package projetoRPI;

import java.util.LinkedList;

public class MedicamentoGenerico {
	private String nome;
	private double preco;
	private int quantidade;
	private LinkedList <TiposMedicamento> categorias = new LinkedList <TiposMedicamento>();
	
	public MedicamentoGenerico(String nome, double preco, int quantidade, TiposMedicamento categoria) {
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
	
	
}
