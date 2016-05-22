package Paciente;

import java.io.Serializable;

public class Padrao implements CartaoFidelidade, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int totalPontos;
	public Padrao(int totalPontos)
	{	
		this.totalPontos = totalPontos;
	}
	@Override
	public void adicionarPontos(int pontos) {
		totalPontos += pontos;
		
	}

	@Override
	public double aplicarDesconto(double preco) {
		return preco;
		
	}
	@Override
	public int getPontosCartao() {
		
		return totalPontos;
	}
	
}
