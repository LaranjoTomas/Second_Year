package Aula8.Exer3;

public class Compras {
    private Produtos[] produtos;
    private int quantidade;

    public Compras() {
        this.produtos = new Produtos[10];
        this.quantidade = 0;
    }

    public void adicionarProduto(Produtos produtos, int quantidade) {
        if (this.quantidade < this.produtos.length) {
            this.produtos[this.quantidade] = produtos;
            this.quantidade++;
        }
    }

    public void listarProdutos() {
        for (int i = 0; i < this.quantidade; i++) {
            System.out.println(this.produtos[i]);
        }
    }

    public void calcularTotal() {
        double total = 0;
        for (int i = 0; i < this.quantidade; i++) {
            total += this.produtos[i].getPreco() * this.produtos[i].getQuantidade();
        }
        System.out.println("Total: " + total);
    }
}
