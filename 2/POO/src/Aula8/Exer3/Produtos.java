package Aula8.Exer3;

public class Produtos {
    private String nome;
    private double preco;
    private int quantidade;

    public Produtos(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

    @Override

    public String toString() {
        return "Produto : " + "nome = " + nome + ", preco = " + preco + ", quantidade = " + quantidade + "\n";
    }

    // equals() and hashCode() methods

    @Override

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Produtos produtos = (Produtos) o;

        if (Double.compare(produtos.preco, preco) != 0)
            return false;
        if (quantidade != produtos.quantidade)
            return false;
        return nome != null ? nome.equals(produtos.nome) : produtos.nome == null;
    }

    public int hashCode() {
        int result;
        long temp;
        result = nome != null ? nome.hashCode() : 0;
        temp = Double.doubleToLongBits(preco);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantidade;
        return result;
    }

    public double getDesconto() {
        return 0;
    }

}
