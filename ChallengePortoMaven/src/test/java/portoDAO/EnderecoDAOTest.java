package portoDAO;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.Test;

import dominio.cliente.Endereco;


public class EnderecoDAOTest {
	
	@Test
	public void testarAdiconarEndereco() {
		Endereco endereco1 = new Endereco("Rua", 100, "Ap 100", "123456789");
		EnderecoDAO enderecoDao = new EnderecoDAO();
		
		enderecoDao.adicionarEndereco(endereco1);
		
		ArrayList<Endereco> enderecos = enderecoDao.obterTodosEnderecos();
		
		boolean contemEndereco = enderecos.contains(endereco1);
		
		assertTrue(contemEndereco);	
	}

}
