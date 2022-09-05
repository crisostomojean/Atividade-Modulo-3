package Agencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDeDestino {

	public static void main(String[] args) {

		DestinoDAO destinoDAO = new DestinoDAO();
		Destino destino = new Destino(0, null, 0);

		ArrayList<Destino> Destino = new ArrayList<Destino>();
		try (Scanner entrada = new Scanner(System.in)) {
			Boolean c = true;

			while (c) {
				System.out.println("------------------------------------");
				System.out.println("         ======Destinos======");
				System.out.println("------------------------------------");
				System.out.println("Digite uma opção: ");
				System.out.println("1 - Cadastrar Destinos ");
				System.out.println("2 - Excluir Destinos ");
				System.out.println("3 - Mostrar Todos os Destinos ");
				System.out.println("4 - Alterar os Destinos ");
				System.out.println("5 - Encerrar ");
				System.out.println("------------------------------------");
				System.out.println("");

				int opcao = entrada.nextInt();

				switch (opcao) {
				case 1: {

					System.out.println("Digite o id do Destino");
					int id = entrada.nextInt();
					System.out.println("Digite o nome do Destino");
					entrada.nextLine();

					String nome = entrada.nextLine();

					System.out.println("Informe o valor ");
					double valor = entrada.nextDouble();
					Destino d = new Destino(id, nome, valor);
					Destino.add(d);
					System.out.println("");
					System.out.println("O seu Destino Foi Cadastrado com sucesso ");
					destino.setId(id);
					destino.setNome(nome);
					destino.setValor(valor);

					destinoDAO.save(destino);

					break;
				}
				case 2: {
					DestinoDAO dao2 = new DestinoDAO();
					System.out.println("Informe o id do destino para excluir");
					int id = entrada.nextInt();

					dao2.removeById(id);
					System.out.println("");
					System.out.println("Destino removido com sucesso!");
				}
					break;
				case 3: {
					System.out.println("       Destinos Cadastrados ");
					System.out.println("");
					try {
						ResultSet resultado = destinoDAO.getDestino();
						while (resultado.next()) {

							System.out.printf("id: " + resultado.getInt(1));
							System.out.printf(" nome: " + resultado.getString(2));
							System.out.printf(": O  valor do Destino  è :  " + resultado.getDouble(3) + "\n");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

					break;
				case 4: {
					System.out.println("Digite o id do Destino");
					int id = entrada.nextInt();
					System.out.println("Digite o nome do Destino");
					String nome = entrada.next();

					System.out.println("Informe o valor ");
					double valor = entrada.nextDouble();

					System.out.println("");
					System.out.println("O seu Destino Foi Alterado com sucesso ");
					destino.setId(id);
					destino.setNome(nome);
					destino.setValor(valor);

					destinoDAO.update(destino);

				}
					break;

				case 5: {
					System.out.println("Programa Ecerrado");
					c = false;
					break;
				}
				default: {
					System.out.println("Opçao invalida ");
				}

				}

			}
		}

	}

}
