package Aula8.Exer3;

public interface Produto {
    String getNome();

    double getPreco();

    int getQuantidade();

    void adicionarQuantidade(int quantidade);

    void removerQuantidade(int quantidade);

}
