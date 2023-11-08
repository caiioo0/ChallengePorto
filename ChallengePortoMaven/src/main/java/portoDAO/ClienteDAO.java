package portoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.cliente.Cliente;

public class ClienteDAO {

	private Connection conexao;
	
	public ClienteDAO() {
		conexao = new ConnectionFactory().obterConexao();
	}
	
	public void adicionarCliente(Cliente cliente) {
		String sqlInsert = "INSERT INTO clientes (nome, telefone, email, cpf) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
			comandoDeInsercao.setString(1, cliente.getNome());
			comandoDeInsercao.setString(2, cliente.getTelefone());
			comandoDeInsercao.setString(3, cliente.getEmail());
			comandoDeInsercao.setString(4, cliente.getCpf());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public ArrayList<Cliente> obterTodosClientes(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		try {
			String sqlSelect = "SELECT * FROM clientes";
			PreparedStatement comandoDeSelecao = conexao.prepareStatement(sqlSelect);
			ResultSet resultado = comandoDeSelecao.executeQuery();
			while(resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(resultado.getString("nome"));
				cliente.setTelefone(resultado.getString("telefone"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setCpf(resultado.getString("cpf"));
				clientes.add(cliente);
			}
			resultado.close();
			comandoDeSelecao.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return clientes;
	}

	public void desconectar() {
		try {
			conexao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}