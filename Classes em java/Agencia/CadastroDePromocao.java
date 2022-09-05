package Agencia;

import java.lang.ProcessHandle.Info;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDePromocao {

	public static void main(String[] args) {

		PromocaoDAO promocaoDAO = new PromocaoDAO();
		Promocao promocao = new Promocao(0, null, 0);

		ArrayList<Promocao> Promocao = new ArrayList<Promocao>();
		try (Scanner entrada = new Scanner(System.in)) {
			Boolean c = true;

			while (c) {
				System.out.println("----------------------------------------");
				System.out.println("         ======Promoções======");
				System.out.println("----------------------------------------");
				System.out.println("        DIGITE UMA OPÇÃO ");
				System.out.println("1 - Cadastrar Promoção ");
				System.out.println("2 - Excluir Promoção ");
				System.out.println("3 - Mostrar Todos as Promoções ");
				System.out.println("4 - Alterar as Promoções ");
				System.out.println("5 - Encerrar ");
				System.out.println("------------------------------------------");
				System.out.println("");

				int opcao = entrada.nextInt();

				switch (opcao) {
				case 1: {

					System.out.println("Digite o ID da Promoção");
					int id = entrada.nextInt();

					System.out.println("Digite o nome da Promoção");
					entrada.nextLine();
					String nome = entrada.nextLine();

					System.out.println("Informe o valor da Promoção ");
					double valor = entrada.nextDouble();

					Destino destino1 = new Destino();
					System.out.println("Informe o id do Destino Para cadastrar na Promoção");
					int id1 = entrada.nextInt();
					destino1.setId(id1);
					System.out.println();
					Promocao d = new Promocao(id, nome, valor);
					Promocao.add(d);
					System.out.println("");
					System.out.println("A sua Promocao Foi Cadastrada com sucesso ");

					promocao.setNome(nome);
					promocao.setValor(valor);
					promocao.setId(id);
					promocao.setDestino(destino1);
					promocaoDAO.save(promocao);

					break;
				}
				case 2: {
					PromocaoDAO dao2 = new PromocaoDAO();
					System.out.println("Informe o id da promocao para excluir");
					int id = entrada.nextInt();

					dao2.removeById(id);
					System.out.println("");
					System.out.println("Promoção removida com sucesso!");
				}
					break;
				case 3: {
					System.out.println("      Promoções Cadastradas ");
					System.out.println("");
					try {
						ResultSet resultado = promocaoDAO.getPromocao();
						while (resultado.next()) {

							System.out.printf(" Nome: " + resultado.getString(1));
							System.out.printf(": O  valor da Promoção è:  " + resultado.getDouble(2));
							System.out.printf("  id: " + resultado.getInt(3) + "\n");

						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

					break;
				case 4: {
					System.out.println("Digite o id da Promoção");
					int id = entrada.nextInt();
					System.out.println("Digite o nome da Promoção");
					entrada.nextLine();
					String nome = entrada.nextLine();

					System.out.println("Informe o valor da promoção ");
					double valor = entrada.nextDouble();

					System.out.println("");
					System.out.println("A sua Promoção foi alterada com sucesso ");
					promocao.setId(id);
					promocao.setNome(nome);
					promocao.setValor(valor);

					promocaoDAO.update(promocao);

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
