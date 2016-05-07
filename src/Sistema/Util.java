package Sistema;

import Exceptions.ControllerException;
import Exceptions.DataInvalidaException;
import Exceptions.MedicamentoException;
import Exceptions.PacienteException;
import Funcionarios.Funcionario;
import Medicamentos.Medicamento;


public class Util {
	
	public void Nomefuncionario(String valor) throws ControllerException{
		if (valor.equals("") || valor == null){
			throw new ControllerException("Nome do funcionario nao pode ser vazio.");
		}
	}
	public void Nomepaciente(String valor) throws PacienteException{
		if (valor.equals("") || valor.equals(" ") || valor == null){
			throw new PacienteException("Nome do paciente nao pode ser vazio.");
		}
	}
	
	public void nomeMedicamento(String valor) throws MedicamentoException {
		if(valor.equals("") || valor.equals(" ") || valor == null){
			throw new MedicamentoException("Nome do medicamento nao pode ser vazio.");
		}
	}
	
	public void precoMedicamento(double valor) throws MedicamentoException {
		if(valor < 0) {
			throw new MedicamentoException("Preco do medicamento nao pode ser negativo.");
		}
	}
	
	public void quantidadeMedicamento(int quantidade) throws MedicamentoException {
		if(quantidade < 0) {
			throw new MedicamentoException("Quantidade do medicamento nao pode ser negativo.");
		}
	}
	
	public void data(String data) throws DataInvalidaException{
		String[] newDate = data.split("/");
		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);
		if( (dia < 1 || dia > 31)  || (mes < 1 || mes > 12) || (ano > 2016) ){
			throw new DataInvalidaException("Data invalida.");
		}
	}
	public void peso(double peso) throws PacienteException{
		if (peso <= 0){
			throw new PacienteException("Peso do paciente nao pode ser negativo.");
		}
	}
	public boolean tipoSanguineo(String tiposanguineo) throws PacienteException{
		tiposanguineo = tiposanguineo.toLowerCase();
		switch (tiposanguineo){
			case "ab+":
				return true;
			case "ab-":
				return true;
			case "a+":
				return true;
			case "a-":
				return true;
			case "b+":
				return true;
			case "b-":
				return true;
			case "o+":
				return true;
			case "o-":
				return true;
			default:
				throw new PacienteException("Tipo sanguineo invalido.");
		}
	}
	
	public void verificaSenha(String senha) throws ControllerException{
		if(senha.contains("@#!")){
			throw new ControllerException("A nova senha deve ter entre 8 - 12 caracteres alfanumericos.");
		}
}
	public void verificaNome(String valor) throws ControllerException{
		if (valor.equals("") || valor == null){
			throw new ControllerException("Nome do funcionario nao pode ser vazio.");
		}
	}
	
	public void verificaData(String data) throws DataInvalidaException{
		String[] newDate = data.split("/");
		int dia = Integer.parseInt(newDate[0]);
		int mes = Integer.parseInt(newDate[1]);
		int ano = Integer.parseInt(newDate[2]);
		if( (dia < 1 || dia > 31)  || (mes < 1 || mes > 12) || (ano > 2016) ){
			throw new DataInvalidaException("Data invalida.");
		}
	}
	
	public void verificaID(String ID) throws ControllerException{
		int id = Integer.parseInt(ID);
		if (id < 0){
			throw new ControllerException("Indice do prontuario nao pode ser negativo.");
		}
	}
	
	public boolean verificaPermissao(Funcionario usuariologado,String requisito) throws ControllerException{
		requisito = requisito.toLowerCase();
		String cargo = usuariologado.getCargo();
		if (!(cargo.equalsIgnoreCase(requisito))){
			return false;
		}else{
			return true;
		}
	}
	
	
	/**
	 * Verifica se é um preço válido.
	 * @throws ControllerException
	 * */
	public void verificaPreco(double valor) throws ControllerException {
		if(valor < 0) {
			throw new ControllerException("Preco nao pode ser negativo.");
		}
	}
	
	/**
	 * Verifica se é uma quantidade válida.
	 * @throws ControllerException
	 * */
	public void verificaQuantidade(int quantidade) throws ControllerException {
		if(quantidade < 0) {
			throw new ControllerException("Quantidade nao pode ser negativa.");
		}
	}
	/**
	 * Verifica se a chave para liberar o sistema é valida
	 * @param chave sera comparada a chave do sistema 
	 * */
	
	public void verificaChave(String chave) throws ControllerException{
		if (!(chave.equals("c041ebf8"))){
			throw new ControllerException("Chave invalida.");
		}
	}
	
	/**
	 * Verifica se o cargo é valido para criacao de um novo funcionario
	 * @throws ControllerException
	 * */
	public void verificaCargo(String cargo) throws ControllerException{
		if (cargo.equalsIgnoreCase("diretor geral")){
			throw new ControllerException("Nao eh possivel criar mais de um Diretor Geral.");
		}
		else if (cargo.equals("")){
			throw new ControllerException("Nome do cargo nao pode ser vazio.");
		}
		else if(!cargo.equalsIgnoreCase("diretor geral") && !cargo.equalsIgnoreCase("medico") && !cargo.equalsIgnoreCase("tecnico administrativo")){
			throw new ControllerException("Cargo invalido.");
		}
	}
	
	/**
	 * Verifica se é uma matricula válida
	 * @throws ControllerException
	 * */
	public void verificaMatricula(String matricula) throws ControllerException{
		try{
			Integer.parseInt(matricula);
		}catch(Exception e){
			throw new ControllerException("A matricula nao segue o padrao.");
		}
	}
	
	/**
	 * Verifica se é uma ordenação válida
	 * @throws ControllerException
	 * */
	public void verificaOrdenacao(String ordenacao) throws ControllerException{
		
		if(!(ordenacao.toLowerCase().equals("preco") || ordenacao.equals("alfabetica"))){
			throw new ControllerException("Tipo de ordenacao invalida.");
		}
	}
	
	
	
	
	
}
