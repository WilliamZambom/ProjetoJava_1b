import java.util.Random;
import java.util.Scanner;

class NumberGuessGame {
    private Random aleatorio = new Random();
    private Scanner entrada;

    public NumberGuessGame(Scanner entrada) {
        this.entrada = entrada;
    }

    public int iniciarJogo(int nivel, Player jogador) {
        if (jogador.getEnergia() < 10) {
            System.out.println("💤 Energia insuficiente! Precisa de pelo menos 10 pontos.");
            return 0;
        }
        jogador.diminuirEnergia(10);

        int max, tentativas, recompensa;
        switch (nivel) {
            case 1: // Fácil
                max = 10;
                tentativas = 5;
                recompensa = 10;
                break;
            case 2: // Médio
                max = 50;
                tentativas = 8;
                recompensa = 25;
                break;
            case 3: // Difícil
                max = 100;
                tentativas = 10;
                recompensa = 50;
                break;
            default:
                return 0;
        }

        System.out.println("\n🎯 === ADIVINHE O NÚMERO - " + getNomeNivel(nivel) + " ===");
        int secreto = aleatorio.nextInt(max + 1);
        int tentativasUsadas = jogarNivel(secreto, max, tentativas);
        if (tentativasUsadas > 0 && tentativasUsadas <= tentativas) {
            System.out.println("🎉 Parabéns! Você acertou em " + tentativasUsadas + " tentativas!");
            return recompensa;
        } else {
            System.out.println("😞 Você esgotou as tentativas. O número era " + secreto + ".");
            return 0;
        }
    }

    private int jogarNivel(int secreto, int max, int tentativas) {
        for (int i = 1; i <= tentativas; i++) {
            System.out.print("Tentativa " + i + "/" + tentativas + ": Digite um número de 0 a " + max + ": ");
            int palpite = entrada.nextInt();
            if (palpite == secreto) {
                return i;
            } else if (palpite < secreto) {
                System.out.println("📈 O número é MAIOR!");
            } else {
                System.out.println("📉 O número é MENOR!");
            }
        }
        return -1; // Falhou
    }

    private String getNomeNivel(int nivel) {
        switch (nivel) {
            case 1:
                return "Fácil";
            case 2:
                return "Médio";
            case 3:
                return "Difícil";
            default:
                return "";
        }
    }
}
