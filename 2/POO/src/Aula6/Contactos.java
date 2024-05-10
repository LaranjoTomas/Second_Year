package Aula6;

//Pretende-se criar um sistema que permita gerir uma lista de contactos dos alunos e 
//professores de uma instituição. Cada contacto vai conter um ID (número sequencial 
//começando em 1), a pessoa correspondente, o número de telemóvel e o endereço de email.
//Reutilize as classes do exercício anterior e considere que:
//• Cada contacto tem de estar associado a uma pessoa;
//• Cada contacto deve conter pelo menos o número de telemóvel ou o endereço de 
//email;
//• O número de telemóvel deve ser validado, considerando 9 algarismos começados por 
//‘9’;
//• O endereço de email deve ser validado, devendo conter um caracter ‘@’ e terminar
//com o domínio (‘.pt’, ‘.com’, ...).

public class Contactos {

    private Pessoa pessoa;
    private int id;
    private String telemovel;
    private String email;

    // validates email and telemovel
    public Contactos(Pessoa pessoa, int id, String telemovel, String email) {
        this.pessoa = pessoa;
        this.id = id;
        this.telemovel = telemovel;
        this.email = email;
    }

    public Contactos(Pessoa pessoa, int id, String email) {
        this.pessoa = pessoa;
        this.id = id;
        this.email = email;
    }

    public Contactos(Pessoa pessoa, String telemovel, int id) {
        this.pessoa = pessoa;
        this.id = id;
        this.telemovel = telemovel;
    }

    public int getID() {
        return id;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean validaTelemovel() {
        if (telemovel.length() == 9 && telemovel.charAt(0) == '9') {
            return true;
        } else {
            return false;
        }
    }

    public boolean validaEmail() {
        if (email.contains("@") && email.endsWith(".pt") || email.endsWith(".com") || email.endsWith(".org")
                || email.endsWith(".net") || email.endsWith(".edu")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Contactos [" + pessoa + "; id: " + id + "; telemovel: " + telemovel + "; email: " + email + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contactos) {
            Contactos contact = (Contactos) obj;
            if (contact.getPessoa().getNome().equals(pessoa.getNome()) && contact.getTelemovel().equals(telemovel)
                    && contact.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
