package dominio.porto;

public class Funcionario {

	private	String nomeF;
	private String telefoneF;
	private String emailF;
	private String cpfF;
	private String cargo;

	public Funcionario(){
	}
	
	public Funcionario(String nomeF, String telefoneF, String emailF,
			String cpfF, String cargo){
		
		this.nomeF = nomeF;
		this.telefoneF = telefoneF;
		this.emailF = emailF;
		this.cpfF = cpfF;
		this.cargo = cargo;
	
	}	
	
	public void exibirFuncionario() {
		System.out.println(nomeF + ", " + telefoneF + ", " + emailF + " " + cpfF  + ", " + cargo); 
	}

	public String getNomeF() {
		return nomeF;
	}

	public void setNomeF(String nomeF) {
		this.nomeF = nomeF;
	}

	public String getTelefoneF() {
		return telefoneF;
	}

	public void setTelefoneF(String telefoneF) {
		this.telefoneF = telefoneF;
	}

	public String getEmailF() {
		return emailF;
	}

	public void setEmailF(String emailF) {
		this.emailF = emailF;
	}

	public String getCpfF() {
		return cpfF;
	}

	public void setCpfF(String cpfF) {
		this.cpfF = cpfF;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}