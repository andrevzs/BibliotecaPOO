package Amigo;

public class Amigo {
    private int idAmigo;
    private String nome;
    private String celular;

    
    // Construtor
    public Amigo(int idAmigo, String nome, String celular) {
        super();
        this.idAmigo = idAmigo;
        this.nome    = nome;
        this.celular = celular;
    }


    // Getters & Setters
    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int id) {
        this.idAmigo = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }


    // Redefinição do método toString()
    @Override
    public String toString() {
        return "Amigo [idAmigo =" + idAmigo + ", nome =" + nome + "]";
    }
}
