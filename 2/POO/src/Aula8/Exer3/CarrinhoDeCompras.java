package Aula8.Exer3;

public class CarrinhoDeCompras {
    private Produtos[] produtos;
    private int nprodutos;

    public CarrinhoDeCompras() {
        this.produtos = new Produtos[10];
        this.nprodutos = 0;
    }

    public void adicionarProduto(Produtos produtos, int quantidade) {
        if (quantidade <= produtos.getQuantidade()) {
            if (produtos instanceof ProdutoComDesconto) {
                this.produtos[nprodutos] = new ProdutoComDesconto(produtos.getNome(), produtos.getPreco(),
                        quantidade, ((ProdutoComDesconto) produtos).getDesconto());
            } else if (produtos instanceof ProdutoGenerico) {
                this.produtos[nprodutos] = new ProdutoGenerico(produtos.getNome(), produtos.getPreco(), quantidade);
            }
            this.nprodutos++;
        } else if (quantidade > produtos.getQuantidade()) {
            System.out.println(
                    "O pruduto " + produtos.getNome() + " não tem a quantidade desejada." + " Quantidade em stock: "
                            + produtos.getQuantidade() + " unidades.\n");
        }
    }

    public void listarProdutos() {
        for (int i = 0; i < this.nprodutos; i++) {
            System.out.println(this.produtos[i]);
        }
    }

    public void calcularTotal() {
        double total = 0;
        for (int i = 0; i < this.nprodutos; i++) {
            if (this.produtos[i] instanceof ProdutoComDesconto) {
                total += (this.produtos[i].getPreco() * (1 - (this.produtos[i].getDesconto() / 100.0)))
                        * this.produtos[i].getQuantidade();
                System.out.println("Valor total: " + total + " euros.");
            } else if (this.produtos[i] instanceof ProdutoGenerico) {
                total += (this.produtos[i].getPreco() * this.produtos[i].getQuantidade());
                System.out.println("Valor total: " + total + " euros.");
            } else {
                System.out.println("Erro.");
            }
        }
    }
}
