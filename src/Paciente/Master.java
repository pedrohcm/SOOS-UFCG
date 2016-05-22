package Paciente;

import java.io.Serializable;

public class Master implements CartaoFidelidade,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int totalPontos;
	public Master(int totalPontos)
	{	
		this.totalPontos = totalPontos;
	}
	@Override
	public void adicionarPontos(int pontos) {
		
		totalPontos += pontos;
		
	}

	@Override
	public double aplicarDesconto(double preco) {
		preco = preco - (preco * 0.15);
		return preco;
		
	}
	@Override
	public int getPontosCartao() {
		
		return totalPontos;
	}

}
