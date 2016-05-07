package Paciente;

public class Paciente implements Comparable<Paciente>{
	Prontuario prontuario;
	
	public Paciente(String nome,String nascimento,double peso,String sexo,String genero,String tipoSanguineo,int id) {
		prontuario = new Prontuario(nome,nascimento,peso,sexo,genero,tipoSanguineo,id);
	}
	
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
	public double getPeso(){
		return prontuario.getPeso();
	}
	
	public int getID(){
		return prontuario.getID();
	}
	
	public int compare(Paciente conta, Paciente outraConta) {
	        return conta.AcessarInformacoes("nome").compareTo(outraConta.AcessarInformacoes("nome"));
	    }

	@Override
	public int compareTo(Paciente o) {
		return this.AcessarInformacoes("nome").compareTo(o.AcessarInformacoes("nome"));
	}

	
}
