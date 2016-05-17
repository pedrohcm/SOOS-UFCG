package Paciente;

public class Vip implements CartaoFidelidade{
	
	int totalPontos;
	public Vip(int totalPontos)
	{	
		this.totalPontos = totalPontos;
	}
	@Override
	public void adicionarPontos(int pontos) {
		pontos = pontos + (int)(pontos * 0.1);
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
