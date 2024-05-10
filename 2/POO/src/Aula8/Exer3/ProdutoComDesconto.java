package Aula8.Exer3;

public class ProdutoComDesconto extends Produtos implements Produto {

    public double desconto;

    public ProdutoComDesconto(String nome, double preco, int quantidade, double desconto) {
        super(nome, preco, quantidade);
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Produto com desconto : " + "nome = " + getNome() + ", preco = " + getPreco() + ", quantidade = "
                + getQuantidade() + ", com desconto de " + desconto + "%.\n";
    }

}
