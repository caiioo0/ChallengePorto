package portoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.porto.OrdemServico;

public class OrdemServicoDAO {

	
private Connection conexao;
	
	public OrdemServicoDAO() {
		conexao = new ConnectionFactory().obterConexao();
	}
	
	public void adicionarOrdemServico(OrdemServico ordemServico) {
		String sqlInsert = "INSERT INTO ordens_servico (endereco, descricao, problemaVeiculo) VALUES (?, ?, ?)";
		try {
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
			comandoDeInsercao.setString(1, ordemServico.getEndereco());
			comandoDeInsercao.setString(2, ordemServico.getDescricao());
			comandoDeInsercao.setString(3, ordemServico.getProblemaVeiculo());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public ArrayList<OrdemServico> obterTodasOrdensDeServico(){
		ArrayList<OrdemServico> ordensServico = new ArrayList<>();
		try {
			String sqlSelect = "SELECT * FROM ordens_servico";
			PreparedStatement comandoDeSelecao = conexao.prepareStatement(sqlSelect);
			ResultSet resultado = comandoDeSelecao.executeQuery();
			while(resultado.next()) {
				OrdemServico ordemServico = new OrdemServico();
				ordemServico.setEndereco(resultado.getString("endereco"));
				ordemServico.setDescricao(resultado.getString("descricao"));
				ordemServico.setProblemaVeiculo(resultado.getString("problemaVeiculo"));
				ordensServico.add(ordemServico);
			}
			resultado.close();
			comandoDeSelecao.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return ordensServico;
	}

	public void desconectar() {
		try {
			conexao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
