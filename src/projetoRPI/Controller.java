package projetoRPI;

import factories.UsuarioFactory;
import factories.MedicamentoFactory;

public class Controller {
	
	final String CHAVE_PRINCIPAL = "c041ebf8";
	UsuarioFactory factoryUsuarios = new UsuarioFactory();
	MedicamentoFactory factoryMedicamentos = new MedicamentoFactory();
	//tera o banco de dados ou as colecoes de usuarios e medicamentos estarao aqui?
	
	public String liberaSistema(String chave){
		String novaMatricula = "";
		return novaMatricula;
	}
	
	public void realizaLogin(){
		
	}
	
	public void cadastraFuncionario(String nome, String cargo, String data){
		factoryUsuarios.criaUsuario(nome, cargo, data);
	}
	
	/* Nao sei se isso sera aqui ou numa classe farmacia (que seria a controller)
	// -------------------Farmacia----------------
	
	public void cadastraMedicamento(String nome, String tipo, double preco, int quantidade, String categoria) {
		// verificar se tem permissao
		factoryMedicamentos.criaMedicamento(nome, tipo, preco, quantidade, categoria);
	}
	
	public String consultaMedNome(String nome) {
		return 
	}
	
	
	
	public void getNomeMedicamento(String id ) {
		return
	}
	
	public double getPrecoMedicamento(String id) {
		return
	}
	
	public String getCategoriasMedicamento(String id) {
		return
	}
	
	public int getQuantidadeMedicamento(String id) {
		return
	}
	*/
}
