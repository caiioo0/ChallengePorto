package portoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.porto.Funcionario;

public class FuncionarioDAO {
		
	private Connection conexao;
			
	public FuncionarioDAO() {
			
		conexao = new ConnectionFactory().obterConexao();
}
		
		public void adicionarFuncionario(Funcionario funcionario) {
			String sqlInsert = "INSERT INTO funcionarios (nomeF, telefoneF, emailF, cpfF, cargo) VALUES (?, ?, ?, ?, ?)";
			try {
				PreparedStatement comandoDeInsercao = conexao.prepareStatement(sqlInsert);
				comandoDeInsercao.setString(1, funcionario.getNomeF());
				comandoDeInsercao.setString(2, funcionario.getTelefoneF());
				comandoDeInsercao.setString(3, funcionario.getEmailF());
				comandoDeInsercao.setString(4, funcionario.getCpfF());
				comandoDeInsercao.setString(5, funcionario.getCargo());
				comandoDeInsercao.execute();
				comandoDeInsercao.close();
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		public ArrayList<Funcionario> obterTodosFuncionarios(){
			ArrayList<Funcionario> funcionarios = new ArrayList<>();
			try {
				String sqlSelect = "SELECT * FROM funcionarios";
				PreparedStatement comandoDeSelecao = conexao.prepareStatement(sqlSelect);
				ResultSet resultado = comandoDeSelecao.executeQuery();
				while(resultado.next()) {
					Funcionario funcionario = new Funcionario();
					funcionario.setNomeF(resultado.getString("nome"));
					funcionario.setTelefoneF(resultado.getString("telefone"));
					funcionario.setEmailF(resultado.getString("email"));
					funcionario.setCpfF(resultado.getString("cpf"));
					funcionario.setNomeF(resultado.getString("cargo"));
					funcionarios.add(funcionario);
				}
				resultado.close();
				comandoDeSelecao.close();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
			return funcionarios;
		}

		public void desconectar() {
			try {
				conexao.close();
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
