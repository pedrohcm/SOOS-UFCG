package Paciente;

public class Padrao implements CartaoFidelidade{
	
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
