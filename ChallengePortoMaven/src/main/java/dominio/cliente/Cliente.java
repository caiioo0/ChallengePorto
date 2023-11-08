package dominio.cliente;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private ArrayList<Veiculo> veiculosDoCliente;

	public Cliente(String nome, String telefone, String email, String cpf, ArrayList<Veiculo> veiculosDoCliente) {

		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.veiculosDoCliente = veiculosDoCliente;
	}

	public Cliente(String nome, String telefone, String email, String cpf) {

		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}

	public Cliente() {
	}

	public void exibirCliente() {

		System.out.println(nome + ", " + telefone + ", " + email + ", " + cpf);
		for (Veiculo veiculo : veiculosDoCliente) {
			veiculo.exibirVeiculo();
		}
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public ArrayList<Veiculo> getVeiculosDoCliente() {
		return veiculosDoCliente;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setVeiculosDoCliente(ArrayList<Veiculo> veiculosDoCliente) {
		this.veiculosDoCliente = veiculosDoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", cpf=" + cpf + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, nome, telefone, veiculosDoCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone)
				&& Objects.equals(veiculosDoCliente, other.veiculosDoCliente);
	}
}
