package dominio.porto;

import java.util.ArrayList;

public class OrdemServico {

	private String endereco;
	private String descricao;
	private String problemaVeiculo;
	private ArrayList <Funcionario> funcionariosNoServico;
	
	OrdemServico(String endereco, String descricao, String problemaVeiculo,ArrayList <Funcionario> funcionariosNoServico ) {
		
		this.endereco = endereco;
		this.descricao = descricao;
		this.problemaVeiculo = problemaVeiculo;
		this.funcionariosNoServico = funcionariosNoServico;
	}
	
	public OrdemServico() {
	}

	public OrdemServico(String string, String string2, String string3) {
	}
	
	public void exibirOrdemServico() {
		
		System.out.println(endereco + ", " + descricao + ", " + problemaVeiculo);
		for(Funcionario funcionario : funcionariosNoServico) {
			  funcionario.exibirFuncionario();
			} 
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getProblemaVeiculo() {
		return problemaVeiculo;
	}

	public void setProblemaVeiculo(String problemaVeiculo) {
		this.problemaVeiculo = problemaVeiculo;
	}

	public ArrayList<Funcionario> getFuncionariosNoServico() {
		return funcionariosNoServico;
	}

	public void setFuncionariosNoServico(ArrayList<Funcionario> funcionariosNoServico) {
		this.funcionariosNoServico = funcionariosNoServico;
	}
	
	
	

}