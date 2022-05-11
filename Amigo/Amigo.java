package Amigo;

/**
 * @author Andre Vinicius Zicka Schmidt
 * @version 1.0
 */

public class Amigo implements Comparable<Amigo> {
    private int idAmigo;
    private String nome;
    private String celular;
    private ListaAmigos amigos;

    
    // Construtor
    public Amigo(String nome, String celular, ListaAmigos amigos) {
        super();
        this.idAmigo = amigos.getListaAmigosSize() + 1;
        this.nome    = nome;
        this.celular = celular;
        this.setAmigos(amigos);
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
    

	public ListaAmigos getAmigos() {
		return amigos;
	}

	public void setAmigos(ListaAmigos amigos) {
		this.amigos = amigos;
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
