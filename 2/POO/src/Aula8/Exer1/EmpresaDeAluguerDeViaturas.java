package Aula8.Exer1;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class EmpresaDeAluguerDeViaturas {
    // mpresa de aluguer de viaturas, caracterizada um nome, código postal, email e
    // por um
    // conjunto de viaturas, que pode incluir qualquer um dos elementos anteriores.

    private String nome;
    private String CPostal;
    private String email;

    private ArrayList<Viatura> veiculos;

    public EmpresaDeAluguerDeViaturas(String nome, String CPostal, String email) {
        validarEmail(email);
        this.nome = nome;
        this.CPostal = CPostal;
        this.veiculos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPostal() {
        return CPostal;
    }

    public void setCPostal(String cPostal) {
        this.CPostal = cPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Viatura> getVeiculos() {
        return veiculos;
    }

    public void addVeiculo(Viatura veiculo) {
        this.veiculos.add(veiculo);
    }

    public void addVeiculos(Viatura... veiculos) {
        for (Viatura v : veiculos) {
            addVeiculo(v);
        }
    }

    private void validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser vazio");
        }
        Pattern regex = Pattern.compile("^[\\w-+\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        if (!regex.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    @Override
    public String toString() {
        return "Empresa{" + "nome=" + nome + ", codigoPostal=" + CPostal + ", email=" + email + ", veiculos="
                + veiculos + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final EmpresaDeAluguerDeViaturas other = (EmpresaDeAluguerDeViaturas) obj;
        return this.getNome().equals(other.getNome()) &&
                this.getCPostal().equals(other.getCPostal()) &&
                this.getEmail().equals(other.getEmail()) &&
                this.getVeiculos().equals(other.getVeiculos());
    }
}
