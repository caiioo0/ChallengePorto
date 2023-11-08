package portoDAO;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import dominio.cliente.Cliente;


public class ClienteTestDAO {

	@Test
	public void testarAdicionarCliente() {
		Cliente clienteCaio = new Cliente("Caio", "75999999999", "caio.rruda2019@gmail.com", "00000000000");
		ClienteDAO clienteDao = new ClienteDAO();
		
		clienteDao.adicionarCliente(clienteCaio);
		
		ArrayList<Cliente> clientes = clienteDao.obterTodosClientes();
		
		boolean contemCliente = clientes.contains(clienteCaio);
		
		assertTrue(contemCliente);	
	}
}
