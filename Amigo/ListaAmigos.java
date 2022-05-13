package Amigo;
import java.util.ArrayList;

/**
 * @author Andre Vinicius Zicka Schmidt
 * @version 1.0
 */

public class ListaAmigos {
    public ArrayList<Amigo> alAmigos;

    
    // Construtor
    public ListaAmigos() {
        super();
        this.alAmigos = new ArrayList<Amigo>();
    }


    // Metodo para adicionar 01 amigo na lista
    public void addAmigo(String nome, String celular) {
        int idAmigo = alAmigos.size() + 1;
        this.alAmigos.add(new Amigo(idAmigo, nome, celular));
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
