package Aula8.Exer3;

public class Main {
    public static void main(String[] args) {
        Produtos p1 = new ProdutoGenerico("Camisolas", 10, 3);
        Produtos p2 = new ProdutoGenerico("Calças", 30, 1);
        Produtos p3 = new ProdutoComDesconto("Sapatilhas", 50, 2, 50);
        Produtos p4 = new ProdutoComDesconto("Casacos", 100, 1, 10);

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionarProduto(p1, 1);
        carrinho.adicionarProduto(p2, 5);
        carrinho.adicionarProduto(p3, 2);
        carrinho.adicionarProduto(p4, 1);

        carrinho.listarProdutos();
        carrinho.calcularTotal();
    }
}
