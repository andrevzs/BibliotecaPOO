package Amigo;
import java.util.ArrayList;

public class ListaAmigos {
    public ArrayList<Amigo> alAmigos;

    
    // Construtor
    public ListaAmigos() {
        super();
        this.alAmigos = new ArrayList<Amigo>();
    }


    // Método para adicionar 01 amigo na lista
    public int addAmigo(String nome, String celular) {
        int idAmigo = alAmigos.size() + 1;
        Amigo amigo = new Amigo(idAmigo, nome, celular);
        alAmigos.add(amigo);
        return idAmigo;
    }


    // Getters e Setters
    public ArrayList<Amigo> getAlAmigos() {
        return alAmigos;
    }
    
    public int getListaAmigosSize() {
        return alAmigos.size();
    }

    public Amigo getAmigo(int i) {
        return alAmigos.get(i);
    }


    // Redefinição do método toString()
    @Override
    public String toString() {
        return ("AlAmigos [" + alAmigos + "]");
    }
}
