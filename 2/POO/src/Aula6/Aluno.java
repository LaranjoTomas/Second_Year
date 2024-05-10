package Aula6;

import java.time.LocalDate;

import Aula5.DateYMD;

public class Aluno extends Pessoa {
    private final int nMec;
    private DateYMD dataInsc;
    private static int nMecCounter = 100;

    public Aluno(String name, int cc, DateYMD dataNasc, DateYMD dataInsc) {
        super(name, cc, dataNasc);
        this.nMec = nMecCounter++;
        this.dataInsc = dataInsc;
    }

    public Aluno(String name, int cc, DateYMD dataNasc) {
        super(name, cc, dataNasc);
        this.nMec = nMecCounter++;
        this.dataInsc = getCurrentDate();
    }

    // nota: neste caso deve assumir a data atual
    public int getNMec() {
        return nMec;
    }

    public DateYMD getDataInsc() {
        return dataInsc;
    }

    public void setDataInsc(DateYMD dataInsc) {
        this.dataInsc = dataInsc;
    }

    @Override
    public String toString() {
        return "nMec: " + nMec + "; dataInsc: " + dataInsc + "; Nome: " + getNome() + "; CC: " + getCc()
                + "; dataNasc: " + getDataNasc();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final Aluno other = (Aluno) obj;
        return this.nMec == other.nMec && this.dataInsc.equals(other.dataInsc) && super.equals(obj);
    }

    private DateYMD getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        return new DateYMD(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
    }
}
