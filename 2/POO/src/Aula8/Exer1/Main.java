package Aula8.Exer1;

public class Main {
    public static void main(String[] args) {

        EmpresaDeAluguerDeViaturas empresa = new EmpresaDeAluguerDeViaturas("AuraBellaFiora", "1234-567",
                "Laranjo@ua.pt");

        Motociclo motociclo = new Motociclo("11-11-AA", "Honda", "CBR", 100, "Deportiva");
        System.out.println(motociclo);

        Táxi táxi = new Táxi("22-22-BB", "Ford", "Focus", 100, 123, 4, 123);
        System.out.println(táxi);

        Viatura viatura = new Viatura("33-33-CC", "Ford", "Focus", 100);
        System.out.println(viatura);

        PesadoDeMercadorias pesadoDeMercadorias = new PesadoDeMercadorias("44-44-DD", "Ford", "Focus", 100, 123, 4,
                123);
        System.out.println(pesadoDeMercadorias);

        PesadoDePassageiros PesadoDePassageiros = new PesadoDePassageiros("55-55-EE", "Ford", "Focus", 100, 123, 4,
                123);
        System.out.println(PesadoDePassageiros);

        AutomóvelLigeiro automóvelLigeiro = new AutomóvelLigeiro("66-66-FF", "Ford", "Focus", 100, 123, 4);
        System.out.println(automóvelLigeiro);

        empresa.addVeiculos(motociclo, automóvelLigeiro, táxi, pesadoDeMercadorias, PesadoDePassageiros);

        System.out.println(empresa.toString());

        System.out.println("\n\n");

        for (Viatura veiculo : empresa.getVeiculos()) {
            System.out.println(veiculo.toString());
        }

        System.out.println("\n\n");

        Viatura veiculoComMaiorDistancia = null;
        for (Viatura veiculo : empresa.getVeiculos()) {
            if (veiculoComMaiorDistancia == null) {
                veiculoComMaiorDistancia = veiculo;
            } else if (veiculo.distanciaTotal() > veiculoComMaiorDistancia.distanciaTotal()) {
                veiculoComMaiorDistancia = veiculo;
            }
        }

        System.out.println(veiculoComMaiorDistancia.toString());

    }
}
