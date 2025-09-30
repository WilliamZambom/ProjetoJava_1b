class Player {
    private String nome;
    private int moedas;
    private int energia;
    private int felicidade;

    public Player(String nome) {
        this.nome = nome;
        this.moedas = 50;
        this.energia = 100;
        this.felicidade = 50;
    }

    public void mostrarStatus() {
        System.out.println("\n=== STATUS DO JOGADOR ===");
        System.out.println("Nome: " + nome);
        System.out.println("Moedas: " + moedas);
        System.out.println("Energia: " + energia);
        System.out.println("Felicidade: " + felicidade);
    }

    public void adicionarMoedas(int quantidade) {
        moedas += quantidade;
        System.out.println("💰 Você ganhou " + quantidade + " moedas!");
    }

    public void diminuirEnergia(int quantidade) {
        energia -= quantidade;
        if (energia < 0) energia = 0;
    }

    public void aumentarEnergia(int quantidade) {
        energia += quantidade;
        if (energia > 100) energia = 100;
    }

    public void aumentarFelicidade(int quantidade) {
        felicidade += quantidade;
        if (felicidade > 100) felicidade = 100;
    }

    public void gastarMoedas(int preco) {
        moedas -= preco;
    }

    public int getMoedas() {
        return moedas;
    }

    public int getEnergia() {
        return energia;
    }
}
