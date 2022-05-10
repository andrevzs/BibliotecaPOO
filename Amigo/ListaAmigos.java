package Amigo;
import java.util.ArrayList;

public class ListaAmigos {
    public ArrayList<Amigo> alAmigos;

    
    // Construtor
    public ListaAmigos() {
        super();
        this.alAmigos = new ArrayList<Amigo>();
    }


    // Metodo para adicionar 01 amigo na lista
    public int addAmigo(String nome, String celular, ListaAmigos amigos) {
        int idAmigo = alAmigos.size() + 1;
        Amigo amigo = new Amigo(nome, celular, amigos);
        alAmigos.add(amigo);
        return idAmigo;
    }


    // Getters e Setters
    public ArrayList<Amigo> getAlAmigos() {
        return alAmigos;
    }
    
    public void addAmigo(Amigo amigo) {
    	this.alAmigos.add(amigo);
    }
    
    public int getListaAmigosSize() {
        return alAmigos.size();
    }

    public Amigo getAmigo(int i) {
        return alAmigos.get(i);
    }


    // Redefinicao do metodo toString()
    @Override
    public String toString() {
        return ("AlAmigos [" + alAmigos + "]");
    }
}
