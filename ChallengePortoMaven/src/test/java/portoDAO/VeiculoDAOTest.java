package portoDAO;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.Test;

import dominio.cliente.Veiculo;

public class VeiculoDAOTest {

	@Test
	public void testarAdiconarVeiculo() {
		Veiculo veiculo1 = new Veiculo(1000.0, "Pesado", "Nenhuma", "abc123", 4);
		VeiculoDAO veiculoDao = new VeiculoDAO();

		veiculoDao.adicionarVeiculo(veiculo1);

		ArrayList<Veiculo> veiculos = veiculoDao.obterTodosVeiculos();

		boolean contemVeiculo = veiculos.contains(veiculo1);

		assertTrue(contemVeiculo);
	}

}
