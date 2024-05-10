package Aula8.Exer2;

public class PratoVegetariano extends Prato {

    public PratoVegetariano(String nome) {
        super(nome);
    }

    @Override
    public boolean adicionarIngrediente(Alimento a) {
        if (a instanceof Cereal || a instanceof Legume)
            return super.adicionarIngrediente(a);
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PratoVegetariano other = (PratoVegetariano) obj;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        return result;
    }
}
