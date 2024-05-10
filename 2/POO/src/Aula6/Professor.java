package Aula6;

import Aula5.DateYMD;

public class Professor extends Pessoa {

    private String area;
    private String Dep;

    public Professor(String nome, int cc, DateYMD dataNasc, String area, String Dep) {
        super(nome, cc, dataNasc);
        this.area = area;
        this.Dep = Dep;
    }

    public String getArea() {
        return area;
    }

    public String getDep() {
        return Dep;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setnFunc(String Dep) {
        this.Dep = Dep;
    }

    @Override
    public String toString() {
        return "Area: " + area + "; Departamento: " + Dep + "; Nome: " + getNome() + "; CC: " + getCc()
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

        final Professor other = (Professor) obj;
        return this.Dep == other.Dep && this.area.equals(other.area) && super.equals(obj);
    }
}
