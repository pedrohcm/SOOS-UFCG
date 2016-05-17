package Paciente;

import java.util.Locale;

import Exceptions.ProcedimentoException;


public class Paciente implements Comparable<Paciente>{
	Prontuario prontuario;
	private double valorGasto;
	private CartaoFidelidade cartao;
	private final int CONSULTACLINICA = 50;
	
	/**
	 * Construtor de Paciente.
	 * @param nome associa ao nome.
	 * @param nascimento associa a data de nascimento.
	 * @param peso associa ao peso.
	 * @param sexo associa ao sexo.
	 * @param genero associa ao genero.
	 * @param tipoSanguineo associa ao tipoSanguineo.
	 * @param id associa ao id.
	 */
	public Paciente(String nome,String nascimento,double peso,String sexo,String genero,String tipoSanguineo,int id) {
		prontuario = new Prontuario(nome,nascimento,peso,sexo,genero,tipoSanguineo,id);
		valorGasto = 0;
		cartao = new Padrao(0);
	}
	
	/**
	 * Recupera informacoes do paciente
	 * @param atributo associa ao atributo desejado
	 * @return informacao deseja do paciente
	 */
	public String AcessarInformacoes(String atributo){
		atributo = atributo.toLowerCase();
		switch(atributo){
			case "nome":
				return prontuario.getNome();
			case "nascimento":
				return prontuario.getNascimento();
			case "tiposanguineo":
				return prontuario.getTipoSanguineo();
			case "sexo":
				return prontuario.getSexo();
			case "genero":
				return prontuario.getGenero();
			case "data":
				return prontuario.getData();
			case "idade":
				return prontuario.getIdade();
			default:
				return "Atributo invalido.";
		}
	}
	
	/**
	 * Recupera o peso do paciente.
	 * @return o peso.
	 */
	public double getPeso(){
		return prontuario.getPeso();
	}
	/**
	 * Modifica o peso do paciente
	 * */
	public void setPeso(double peso){
		prontuario.setPeso(peso);
	}
	/**
	 * Modifica o Genero do Paciente
	 * */
	public void setGenero(String genero){
		prontuario.setGenero(genero);
	}
	/**
	 * Armazena os gastos referentes a um procedimento
	 * */
	public void armazenarGastos(double gasto){
		gasto = calculaDesconto(gasto);
		this.valorGasto = this.valorGasto + gasto;
	}
	
	/**
	 * Recupera todos os gastos
	 */
	public String getValorGasto(){
		
		return 	String.format(Locale.US,"%.2f",valorGasto);

	}
	
	public void strategy(){
		
		if(cartao.getPontosCartao() >= 150 && cartao.getPontosCartao() <= 350){
			setCartao(new Master(cartao.getPontosCartao()));
			
		}
		else if (cartao.getPontosCartao() > 350){
			setCartao(new Vip(cartao.getPontosCartao()));
		}
		
	}
	
	private void setCartao(CartaoFidelidade cartaoFidelidade) {
		this.cartao = cartaoFidelidade;
		
	}
	
	/**
	 * Adiciona pontos no cartao fidelidade
	 * @throws ProcedimentoException 
	 */
	
	public void adicionaPontosCartao(String procedimento) throws ProcedimentoException{
		
		if(procedimento.equalsIgnoreCase("Consulta clinica")){
			cartao.adicionarPontos(CONSULTACLINICA);
		}
		else if(procedimento.equalsIgnoreCase("Cirurgia bariatrica")){
			cartao.adicionarPontos(100);
		}
		else if(procedimento.equalsIgnoreCase("Redesignacao sexual")){
			cartao.adicionarPontos(130);

		}
		else if(procedimento.equalsIgnoreCase("Transplante de orgaos")){
			cartao.adicionarPontos(160);
		}
		
		else{
			throw new ProcedimentoException(procedimento);
		}
	}
	
	public int getPontosCartaoFidelidade(){
		return cartao.getPontosCartao();
	}
	/**
	 * Recupera o id do paciente.
	 * @return o id.
	 */
	public int getID(){
		return prontuario.getID();
	}
	/**
	 * Recupera o tamanho da lista de procedimentos do prontuario
	 * @return Quantidade de procedimentos
	 * */
	public int getProcedimentosSize(){
		return prontuario.getProcedimentosSize();
	}
	/**
	 * Compara dois pacientes.
	 * @param conta associa ao paciente 1.
	 * @param outraConta associa ao paciente 2.
	 * @return
	 */
	public int compare(Paciente conta, Paciente outraConta) {
	        return conta.AcessarInformacoes("nome").compareTo(outraConta.AcessarInformacoes("nome"));
	    }

	@Override
	public int compareTo(Paciente o) {
		return this.AcessarInformacoes("nome").compareTo(o.AcessarInformacoes("nome"));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prontuario == null) ? 0 : prontuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (prontuario == null) {
			if (other.prontuario != null)
				return false;
		} else if (!prontuario.equals(other.prontuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paciente [Prontuario=" + prontuario + "]";
	}
	
	/**
	 * Registra o procedimento efetuado na lista de procedimentos do prontuario
	 * @throws ProcedimentoException 
	 * */
	public void registrarProcedimento(String procedimento) throws ProcedimentoException{
		adicionaPontosCartao(procedimento);
		prontuario.adicionarProcedimentoALista(procedimento);
	}
	
	
	
	/**
	 * Calcula Desconto
	 */
	
	public double calculaDesconto(double preco){
		return cartao.aplicarDesconto(preco);
	}
	
}

