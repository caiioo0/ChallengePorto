package dominio.cliente;

import java.util.Objects;

public class Veiculo {

	private	double pesoVeiculo;
	private String modelo;
	private String modificacoes;
	private String placa;
	private int quantidadeEixos;

	public Veiculo(double pesoVeiculo, String modelo, String modificacoes,String placa, 
			int quantidadeEixos) {
		
		this.pesoVeiculo = pesoVeiculo;
		this.modelo = modelo;
		this.modificacoes = modificacoes;
		this.placa = placa;
		this.quantidadeEixos = quantidadeEixos;
}
	
	public Veiculo() {
		
	}
	
	public void exibirVeiculo() {
		System.out.println(pesoVeiculo + ", " + modelo + ", " + modificacoes + " " + placa  + ", " + quantidadeEixos); 
	}

	public double getPesoVeiculo() {
		return pesoVeiculo;
	}

	public void setPesoVeiculo(double pesoVeiculo) {
		this.pesoVeiculo = pesoVeiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModificacoes() {
		return modificacoes;
	}

	public void setModificacoes(String modificacoes) {
		this.modificacoes = modificacoes;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getQuantidadeEixos() {
		return quantidadeEixos;
	}

	public void setQuantidadeEixos(int quantidadeEixos) {
		this.quantidadeEixos = quantidadeEixos;
	}

	@Override
	public String toString() {
		return "Veiculo [pesoVeiculo=" + pesoVeiculo + ", modelo=" + modelo + ", modificacoes=" + modificacoes
				+ ", placa=" + placa + ", quantidadeEixos=" + quantidadeEixos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(modelo, modificacoes, pesoVeiculo, placa, quantidadeEixos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(modelo, other.modelo) && Objects.equals(modificacoes, other.modificacoes)
				&& Double.doubleToLongBits(pesoVeiculo) == Double.doubleToLongBits(other.pesoVeiculo)
				&& Objects.equals(placa, other.placa) && quantidadeEixos == other.quantidadeEixos;
	}
}	
