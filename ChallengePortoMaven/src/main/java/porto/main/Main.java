package porto.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.cliente.Cliente;
import dominio.cliente.Endereco;
import dominio.cliente.Veiculo;
import portoDAO.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);
		Connection conexao = new ConnectionFactory().obterConexao();
		ClienteDAO clienteDAO = new ClienteDAO();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();

		int opcao;
		do {
			System.out.println("Menu:");
			System.out.println("1 - Cadastrar o cliente");
			System.out.println("2 - Listar os cadastros");
			System.out.println("3 - Encerrar programa");
			System.out.println("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite seu nome: ");
				String nome = sc.nextLine();
				System.out.println("Digite o seu telefone: ");
				String telefone = sc.nextLine();
				System.out.println("Digite o seu email: ");
				String email = sc.nextLine();
				System.out.println("Digite o seu cpf: ");
				String cpf = sc.nextLine();

				Cliente cliente = new Cliente(nome, telefone, email, cpf);
				System.out.println("Cadastro no sistema realizado");
				clienteDAO.adicionarCliente(cliente);

				System.out.println("Deseja cadastrar seu veículo ? (S) para SIM, (N) para NÃO");
				char cadastroVeiculo = sc.nextLine().charAt(0);

				if (cadastroVeiculo == 'S' || cadastroVeiculo == 's') {
					System.out.println("Digite o peso do seu veículo: ");
					double pesoVeiculo = sc.nextDouble();
					sc.nextLine();
					System.out.println("Digite o modelo do seu veículo: ");
					String modelo = sc.nextLine();
					System.out.println("Digite as modificações do seu veículo: ");
					String modificacoes = sc.nextLine();
					System.out.println("Digite placa do seu veículo: ");
					String placa = sc.nextLine();
					System.out.println("Digite a quantidade de eixos do seu veículo: ");
					int quantidadeEixos = sc.nextInt();
					sc.nextLine();

					Veiculo veiculo = new Veiculo(pesoVeiculo, modelo, modificacoes, placa, quantidadeEixos);
					System.out.println("Cadastro do veículo no sistema realizado");
					veiculoDAO.adicionarVeiculo(veiculo);

				} else if (cadastroVeiculo == 'N' || cadastroVeiculo == 'n') {
					System.out.println("Cadastro encerrado.");

				} else {
					System.out.println("Opção inválida!");
				}

				System.out.println("Deseja cadastrar seu endereço ? (S) para SIM, (N) para NÃO");
				char cadastroEndereco = sc.nextLine().charAt(0);

				if (cadastroEndereco == 'S' || cadastroEndereco == 's') {
					System.out.println("Digite o logradouro do seu endereço: ");
					String logradouro = sc.nextLine();
					System.out.println("Digite o número da sua propriedade: ");
					int numero = sc.nextInt();
					sc.nextLine();
					System.out.println("Digite o complemento, caso seja necessário: ");
					String complemento = sc.nextLine();
					System.out.println("Digite o seu CEP: ");
					String cep = sc.nextLine();

					Endereco endereco = new Endereco(logradouro, numero, complemento, cep);
					System.out.println("Cadastro do veículo no sistema realizado");
					enderecoDAO.adicionarEndereco(endereco);

				} else if (cadastroEndereco == 'N' || cadastroEndereco == 'n') {
					System.out.println("Cadastro encerrado.");

				} else {
					System.out.println("Opção inválida!");
				}
				break;

			case 2:

				System.out.println(
						"Deseja puxar os cadastros ? (C) para os CLIENTES, (V) para VEÍCULOS e (E) para ENDEREÇOS ?");
				char puxarCadastro = sc.nextLine().charAt(0);

				if (puxarCadastro == 'C' || puxarCadastro == 'c') {

					ArrayList<Cliente> clientes = clienteDAO.obterTodosClientes();

					System.out.println("Listando todos os clientes:");
					for (Cliente clienteCadastrado : clientes) {
						System.out.println(clienteCadastrado);
					}
				} else if (puxarCadastro == 'V' || puxarCadastro == 'v') {
					ArrayList<Veiculo> veiculos = veiculoDAO.obterTodosVeiculos();

					System.out.println("Listando todos os veículos:");
					for (Veiculo veiculoCadastrado : veiculos) {
						System.out.println(veiculoCadastrado);
					}
				} else if (puxarCadastro == 'E' || puxarCadastro == 'e') {
					ArrayList<Endereco> enderecos = enderecoDAO.obterTodosEnderecos();

					System.out.println("Listando todos os endereços:");
					for (Endereco enderecoCadastrado : enderecos) {
						System.out.println(enderecoCadastrado);
					}
				} else {
					System.out.println("Opção inválida, programa encerrado.");
				}
				break;

			case 3:
				System.out.println("Encerrando o programa.");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 3);

		conexao.close();
		sc.close();

	}
}
