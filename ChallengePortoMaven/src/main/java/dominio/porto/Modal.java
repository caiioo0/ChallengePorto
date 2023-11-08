package dominio.porto;


public class Modal {
	
	private String nome;
	private String descricao;
	
	
	
	public Modal() {
	}

	public Modal(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void exibirModalDoServico() {
		System.out.println(nome + ", " + descricao);  
	}

	
		
}
