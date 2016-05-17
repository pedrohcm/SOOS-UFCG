package Paciente;

public class Master implements CartaoFidelidade{

	int totalPontos;
	public Master(int totalPontos)
	{	
		this.totalPontos = totalPontos;
	}
	@Override
	public void adicionarPontos(int pontos) {
		pontos = pontos + (int)(pontos * 0.05);

		totalPontos += pontos;
		
	}

	@Override
	public double aplicarDesconto(double preco) {
		preco = preco - (preco * 0.2);
		return preco;
		
	}
	@Override
	public int getPontosCartao() {
		
		return totalPontos;
	}

}
