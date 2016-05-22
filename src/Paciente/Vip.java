package Paciente;

import java.io.Serializable;

public class Vip implements CartaoFidelidade,Serializable{
	
	int totalPontos;
	public Vip(int totalPontos)
	{	
		this.totalPontos = totalPontos;
	}
	@Override
	public void adicionarPontos(int pontos) {
		this.totalPontos += pontos;
		
	}

	@Override
	public double aplicarDesconto(double preco) {
		preco = preco - (preco * 0.3);
		return preco;
		
	}
	@Override
	public int getPontosCartao() {
		
		return totalPontos;
	}

}
