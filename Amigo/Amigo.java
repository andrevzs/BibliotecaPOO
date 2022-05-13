package Amigo;

/**
 * @author Andre Vinicius Zicka Schmidt
 * @version 1.0
 */

public class Amigo implements Comparable<Amigo> {
    private int idAmigo;
    private String nome;
    private String celular;

    
    // Construtor
    public Amigo(int id, String nome, String celular) {
        super();
        this.idAmigo = id;
        this.nome    = nome;
        this.celular = celular;
    }


    // Getters & Setters
    public int getIdAmigo() {
        return idAmigo;
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


    // Redefinicao do metodo toString()
    @Override
    public String toString() {
        return ("Amigo " + idAmigo + 
        		"\nNome:" + nome + 
        		"\nCelular: " + celular);
    }


	
    @Override
	public int compareTo(Amigo o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
