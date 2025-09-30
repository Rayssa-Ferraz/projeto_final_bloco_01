package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.Util.Cores;

public class Menu {

			private static final Scanner leia = new Scanner(System.in);

		public static void main(String[] args) {

			int opcao;

			// Laço de repetição que mantém o menu rodando até a opção sair ser acionada
			while (true) {

				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT+ Cores.ANSI_BLACK_BACKGROUND
						+ "*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                MALVADÃO PIPAS                       ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Criar Produto                        ");
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
					System.out.println(Cores.TEXT_RED + "Criar Produto\n\n");

					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_RED + "Listar todos os Produtos\n\n");

					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_RED + "Consultar dados do Produto - por ID\n\n");

					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_RED + "Atualizar dados do Produto\n\n");

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_RED + "Apagar o Produto\n\n");

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
		public static void keyPress() {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			leia.nextLine();
	



	}

}
