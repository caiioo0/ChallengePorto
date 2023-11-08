package portoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.cliente.Endereco;

public class EnderecoDAO {

private Connection conexao;
	
	public EnderecoDAO() {
		conexao = new ConnectionFactory().obterConexao();
	}
	
	public void adicionarEndereco(Endereco endereco) {
		String sqlInsert = "INSERT INTO endereco (logradouro, numero, complemento, cep) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
			comandoDeInsercao.setString(1, endereco.getLogradouro());
			comandoDeInsercao.setInt(2, endereco.getNumero());
			comandoDeInsercao.setString(3, endereco.getComplemento());
			comandoDeInsercao.setString(4, endereco.getCep());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public ArrayList<Endereco> obterTodosEnderecos(){
		ArrayList<Endereco> enderecos = new ArrayList<>();
		try {
			String sqlSelect = "SELECT * FROM endereco";
			PreparedStatement comandoDeSelecao = conexao.prepareStatement(sqlSelect);
			ResultSet resultado = comandoDeSelecao.executeQuery();
			while(resultado.next()) {
				Endereco endereco = new Endereco();
				endereco.setLogradouro(resultado.getString("logradouro"));
				endereco.setNumero(resultado.getInt("numero"));
				endereco.setComplemento(resultado.getString("complemento"));
				endereco.setCep(resultado.getString("cep"));
				enderecos.add(endereco);
			}
			resultado.close();
			comandoDeSelecao.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return enderecos;
	}

	public void desconectar() {
		try {
			conexao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
