import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Player jogador = new Player("Jogador");
        Loja loja = new Loja();
        NumberGuessGame jogoAdivinhacao = new NumberGuessGame(entrada);

        System.out.println("🎮 Bem-vindo ao Jogo!");
        boolean jogando = true;

        while (jogando) {
            System.out.println("\n==============================");
            System.out.println("1. Jogar");
            System.out.println("2. Loja");
            System.out.println("3. Status do jogador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o nível de dificuldade:");
                    System.out.println("1. Fácil");
                    System.out.println("2. Médio");
                    System.out.println("3. Difícil");
                    int nivel = entrada.nextInt();
                    int recompensa = jogoAdivinhacao.iniciarJogo(nivel, jogador);
                    jogador.adicionarMoedas(recompensa);
                    break;
                case 2:
                    loja.entrarNaLoja(jogador, entrada);
                    break;
                case 3:
                    jogador.mostrarStatus();
                    break;
                case 0:
                    jogando = false;
                    System.out.println("👋 Obrigado por jogar!");
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
        }

        entrada.close();
    }
}
