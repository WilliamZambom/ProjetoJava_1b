import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Loja {
    private List<Item> itens;

    public Loja() {
        itens = new ArrayList<>();
        itens.add(new Item("Maçã", "COMIDA", 10, 10));
        itens.add(new Item("Poção de Energia", "POCAO", 20, 20));
        itens.add(new Item("Bola", "BRINQUEDO", 15, 15));
        itens.add(new Item("Café", "ENERGETICO", 25, 30));
    }

    public void entrarNaLoja(Player jogador, Scanner entrada) {
        boolean comprando = true;

        while (comprando) {
            System.out.println("\n=== LOJA ===");
            System.out.println("💰 Quantidade de moedas: " + jogador.getMoedas());
            for (int i = 0; i < itens.size(); i++) {
                Item item = itens.get(i);
                System.out.println((i + 1) + ". " + item.getNome() + " - " + item.getPreco() + " moedas");
            }
            System.out.println((itens.size() + 1) + ". Sair da loja");
            System.out.print("Digite aqui: ");

            int escolha = entrada.nextInt();

            if (escolha == itens.size() + 1) {
                comprando = false;
            } else if (escolha > 0 && escolha <= itens.size()) {
                Item itemEscolhido = itens.get(escolha - 1);
                if (jogador.getMoedas() >= itemEscolhido.getPreco()) {
                    jogador.gastarMoedas(itemEscolhido.getPreco());
                    aplicarItem(jogador, itemEscolhido);
                } else {
                    System.out.println("❌ Moedas insuficientes!");
                }
            } else {
                System.out.println("❌ Opção inválida!");
            }
        }
    }

    private void aplicarItem(Player jogador, Item item) {
        switch (item.getTipo()) {
            case "COMIDA":
                jogador.aumentarEnergia(item.getValor());
                System.out.println("🍎 Energia aumentada!");
                break;
            case "POCAO":
                jogador.aumentarEnergia(item.getValor());
                System.out.println("🧪 Energia restaurada!");
                break;
            case "BRINQUEDO":
                jogador.aumentarFelicidade(item.getValor());
                System.out.println("⚽ Felicidade aumentada!");
                break;
            case "ENERGETICO":
                jogador.aumentarEnergia(item.getValor());
                System.out.println("☕ Energia turbinada!");
                break;
        }
    }
}
