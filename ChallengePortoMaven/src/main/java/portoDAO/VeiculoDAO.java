package portoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.cliente.Veiculo;

public class VeiculoDAO {

private Connection conexao;
	
	public VeiculoDAO() {
		conexao = new ConnectionFactory().obterConexao();
	}
	
	public void adicionarVeiculo(Veiculo veiculo) {
		String sqlInsert = "INSERT INTO veiculos (peso, modelo, modificacoes, placa, qtdEixos) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
			comandoDeInsercao.setDouble(1, veiculo.getPesoVeiculo());
			comandoDeInsercao.setString(2, veiculo.getModelo());
			comandoDeInsercao.setString(3, veiculo.getModificacoes());
			comandoDeInsercao.setString(4, veiculo.getPlaca());
			comandoDeInsercao.setInt(5, veiculo.getQuantidadeEixos());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public ArrayList<Veiculo> obterTodosVeiculos(){
		ArrayList<Veiculo> veiculos = new ArrayList<>();
		try {
			String sqlSelect = "SELECT * FROM veiculos";
			PreparedStatement comandoDeSelecao = conexao.prepareStatement(sqlSelect);
			ResultSet resultado = comandoDeSelecao.executeQuery();
			while(resultado.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setPesoVeiculo(resultado.getDouble("peso"));
				veiculo.setModelo(resultado.getString("modelo"));
				veiculo.setModificacoes(resultado.getString("modificacoes"));
				veiculo.setPlaca(resultado.getString("placa"));
				veiculo.setQuantidadeEixos(resultado.getInt("qtdEixos"));
				veiculos.add(veiculo);
			}
			resultado.close();
			comandoDeSelecao.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return veiculos;
	}

	public void desconectar() {
		try {
			conexao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
