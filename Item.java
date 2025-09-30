class Item {
    private String nome;
    private String tipo; // COMIDA, POCAO, BRINQUEDO, ENERGETICO
    private int preco;
    private int valor;

    public Item(String nome, String tipo, int preco, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPreco() {
        return preco;
    }

    public int getValor() {
        return valor;
    }
}
