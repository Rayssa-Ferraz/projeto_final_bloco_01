package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Pipas;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.Linhas;
import projeto_final_bloco_01.model.CarretilhasePotes;
import projeto_final_bloco_01.Util.Cores;

public class Menu {

		private static final Scanner leia = new Scanner(System.in);

		private static final ProdutoController produtoController = new ProdutoController();
		
		public static void main(String[] args) {
			int opcao;
			
			criarProdutosTeste();

			Pipas p1 = new Pipas(1, "Flexinha", 1, 2.00f, "Raia");
			p1.visualizar();
			
			Linhas l1 = new Linhas(1, "Vera Cruz", 2, 12.00f, 500);
			l1.visualizar();
			
			CarretilhasePotes cp1 = new CarretilhasePotes(1, "Carretilha Plastica", 3, 30.00f, "MD");
			cp1.visualizar();
			
			// Laço de repetição que mantém o menu rodando até a opção sair ser acionada
			while (true) {

				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT+ Cores.ANSI_BLACK_BACKGROUND
						+ "*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                MALVADÃO PIPAS                       ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Cadastrar Produto                    ");
				System.out.println("            2 - Listar todos os Produtos             ");
				System.out.println("            3 - Buscar Produto por ID                ");
				System.out.println("            4 - Atualizar Dados do Produto           ");
				System.out.println("            5 - Apagar Produto                       ");
				System.out.println("            0 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("Entre com a opção desejada:                          ");
				System.out.println("                                                     " + Cores.TEXT_RESET);

				// Tenta capturar a opção digitada
				// Caso o usuário digite algo inválido, mostra mensagem de erro
				try {
					opcao = leia.nextInt();
					leia.nextLine();
				} catch (InputMismatchException e) {
					opcao = -1;
					System.out.println("\nDigite um número inteiro entre 0 e 8");
					leia.nextLine();
				}

				// Se a opção for 0, o sistema será finalizado (System.exit(0))
				if (opcao == 0) {
					System.out.println(Cores.TEXT_RED_BOLD + "\nMalvadão Pipas: Alegria que chega às alturas!");
					sobre();
					leia.close();
					System.exit(0);
				}

				// Verifica qual opção do menu o usuário escolheu e executa a ação
				// correspondente
				switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_RED + "Cadastrar Produto\n\n");
					
					cadastrarProduto();
					
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_RED + "Listar todos os Produtos\n\n");

					listarProdutos();
					
					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_RED + "Consultar dados do Produto - por ID\n\n");

					procurarProdutoPorId();
					
					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_RED + "Atualizar dados do Produto\n\n");

					atualizarProduto();
					
					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_RED + "Apagar o Produto\n\n");

					deletarProduto();
					
					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					keyPress();
					break;
				}
			}

		}

	

		// Exibe informações sobre o projeto e a pessoa desenvolvedora
		public static void sobre() {
			System.out.println("  ");
			System.out.println("  ");
			System.out.println(Cores.TEXT_RED_BRIGHT + "\n******************************************************");
			System.out.println(Cores.TEXT_RED_BRIGHT + "Projeto Desenvolvido por:                             ");
			System.out.println(Cores.TEXT_RED_BRIGHT + "Rayssa Ferraz - rayssa_nana@hotmail.com               ");
			System.out.println(Cores.TEXT_RED_BRIGHT + "github.com/Rayssa-Ferraz                              ");
			System.out.println(Cores.TEXT_RED_BRIGHT + "******************************************************");
		}

		// Método responsável por aguardar o usuário pressionar a tecla Enter para
		// continuar
		
		public static void keyPress() {System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			leia.nextLine();
	
	}

		private static void criarProdutosTeste() {
			produtoController.cadastrar(new Pipas(produtoController.gerarId(), "Rio Médio", 1, 3.00f, "Pipa"));
			produtoController.cadastrar(new Linhas(produtoController.gerarId(), "Aero", 2, 5.00f, 200));
			produtoController.cadastrar(new CarretilhasePotes(produtoController.gerarId(), "Pote Preto Medio", 3, 8.00f, "Pote"));

		}

		// Método responsável por listar todas as produtos
		private static void listarProdutos() {
			produtoController.listarTodas();
		}

		// Método responsável por criar uma nova produto com os dados digitados pelo
		// usuário
		private static void cadastrarProduto() {

			System.out.print("Digite o nome do Produto: ");
			String nome = leia.nextLine();
			
			
			System.out.print("Digite o Categoria da produto (1 - Pipas | 2 - Linhas | 3 - Carretilhas e Potes): ");
			int categoria = leia.nextInt();
			

			System.out.print("Digite o Preco inicial: ");
			float preco = leia.nextFloat();
			
			
			switch (categoria) {
			case 1 -> {
				System.out.print("Digite o Modelo inicial: ");
				leia.skip("\\R");
				String modelo = leia.nextLine();
				// Automatiza o id da produto através do método gerarId()
				produtoController.cadastrar(new Pipas(produtoController.gerarId(), nome, categoria, preco, modelo));
			}
			case 2 -> {
				System.out.print("Digite a quantidade de jardas do produto: ");
				int jardas = leia.nextInt();
				leia.nextLine();
				produtoController.cadastrar(new Linhas(produtoController.gerarId(), nome, categoria, preco, jardas));
			}
			case 3 -> {
				System.out.print("Digite o Modelo inicial: ");
				leia.skip("\\R");
				String modelo = leia.nextLine();
				// Automatiza o id da produto através do método gerarId()
				produtoController.cadastrar(new CarretilhasePotes(produtoController.gerarId(), nome, categoria, preco, modelo));
			}
			default -> System.out.println(Cores.TEXT_RED + "Categoria de produto inválido!" + Cores.TEXT_RESET);
			}
		}

		// Método responsável por procurar uma produto já cadastrada pelo número
		private static void procurarProdutoPorId() {

			System.out.print("Digite o número da produto: ");
			int id = leia.nextInt();
			leia.nextLine();

			produtoController.procurarPorId(id);
		}
		
		private static void deletarProduto() {

			System.out.print("Digite o número da produto: ");
			int id = leia.nextInt();
			leia.nextLine();

			// Busca a produto pelo número
			Produto produto = produtoController.buscarNaCollection(id);

			// Verifica se a produto existe
			if (produto != null) {

				// Confirmação da exclusão
				System.out.print("\nTem certeza que deseja excluir esta produto? (S/N): ");
				String confirmacao = leia.nextLine();

				if (confirmacao.equalsIgnoreCase("S")) {
					produtoController.deletar(id);
				} else {
					System.out.println("\nOperação cancelada!");
				}

			} else {
				System.out.printf("\nA produto número %d não foi encontrada!", id);
			}
		}

		// Método responsável por atualizar os dados de uma produto existentepelo id
		private static void atualizarProduto() {

			System.out.print("Digite o número do produto: ");
			int id = leia.nextInt();
			leia.nextLine();

			// Busca a produto pelo número
			Produto produto = produtoController.buscarNaCollection(id);

			// Se a produto existir
			if (produto != null) {

				// Obtém os dados atuais
				String nome = produto.getNome();
				int categoria = produto.getCategoria();
				float preco = produto.getPreco();

				// Atualiza o nome do nome (ou mantém valor atual se apertar Enter)
				System.out.printf(
						"Nome atual: %s\nDigite o novo nome do Nome (Pressione ENTER para manter o valor atual): ", nome);
				String entrada = leia.nextLine();
				nome = entrada.isEmpty() ? nome : entrada;

				// Atualiza preco (ou mantém valor atual se apertar Enter)
				System.out.printf("Preco atual: %.2f\nDigite o novo Preco (Pressione ENTER para manter o valor atual): ",
						preco);
				entrada = leia.nextLine();

				
				preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada.replace(",", "."));

				// Se a produto for do categoria Produto Pipas
				switch (categoria) {
				case 1 -> {

					String modelo = ((Pipas) produto).getModelo();

					// Atualiza o generico da produto (ou mantém valor atual se apertar Enter)
					System.out.printf(
							"Modelo atual é: %.2f\nDigite o novo Modelo (Pressione ENTER para manter o modelo atual): ",
							modelo);
					entrada = leia.nextLine();
					modelo = entrada.isEmpty() ? modelo : entrada;

					
					produtoController.atualizar(new Pipas(id, nome, categoria, preco, modelo));

				}
				// Se a produto for do categoria Produto Linhas
				case 2 -> {

					
					int jardas = ((Linhas)produto).getJardas();

					// Atualiza a jarda  (ou mantém valor atual se apertar Enter)
					System.out.printf(
							"Jardas atual é: %d\nDigite a nova Jarda (Pressione ENTER para manter a jarda atual): ",
							jardas);
					entrada = leia.nextLine();
					jardas = entrada.isEmpty() ? jardas : Integer.parseInt(entrada);
					produtoController.atualizar(new Linhas(id, nome, categoria, preco, jardas));
				}
				
				case 3 -> {

					
					String modelo = ((CarretilhasePotes) produto).getModelo();

					// Atualiza o modelo do produto (ou mantém valor atual se apertar Enter)
					System.out.printf(
							"Modelo atual é: %.2f\nDigite o novo Modelo (Pressione ENTER para manter o modelo atual): ",
							modelo);
					entrada = leia.nextLine();
					modelo = entrada.isEmpty() ? modelo : entrada;

					
					produtoController.atualizar(new CarretilhasePotes(id, nome, categoria, preco, modelo));

				}
				
				default -> System.out.println(Cores.TEXT_RED + "Categoria de produto inválido!" + Cores.TEXT_RESET);
				}

			} else {
				// Caso a produto não exista
				System.out.printf("\nA produto número %d não foi encontrada!", id);
			}
		}
}
				
