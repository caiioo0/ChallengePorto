package dominio.cliente;

import java.util.Objects;

public class Endereco {
	
	String logradouro;
	int numero;
	String complemento;
	String cep;
	
	public Endereco(String logradouro, int numero, String complemento, String cep) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}
	
	public Endereco() {
		super();
	}

	public void exibirEndereco() {
		System.out.println(logradouro + ", " + complemento + ", " + cep + ", " + numero);  
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cep="
				+ cep + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, complemento, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(logradouro, other.logradouro) && numero == other.numero;
	}
	
	
	
	
}
