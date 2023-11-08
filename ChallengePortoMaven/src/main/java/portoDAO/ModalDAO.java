package portoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.porto.Modal;

public class ModalDAO {
	
private Connection conexao;
	
	public ModalDAO() {
		conexao = new ConnectionFactory().obterConexao();
	}
	
	public void adicionarModal(Modal modal) {
		String sqlInsert = "INSERT INTO modal (nome, descricao) VALUES (?, ?)";
		try {
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
			comandoDeInsercao.setString(1, modal.getNome());
			comandoDeInsercao.setString(2, modal.getDescricao());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public ArrayList<Modal> obterModal(){
		ArrayList<Modal> modais = new ArrayList<>();
		try {
			String sqlSelect = "SELECT * FROM modal";
			PreparedStatement comandoDeSelecao = conexao.prepareStatement(sqlSelect);
			ResultSet resultado = comandoDeSelecao.executeQuery();
			while(resultado.next()) {
				Modal modal = new Modal();
				modal.setNome(resultado.getString("nome"));
				modal.setDescricao(resultado.getString("descricao"));
				modais.add(modal);
			}
			resultado.close();
			comandoDeSelecao.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return modais;
	}

	public void desconectar() {
		try {
			conexao.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
