package Biblioteca;
import java.util.ArrayList;

/**
 * @author Andre Vinicius Zicka Schmidt
 * @version 1.0
 */

public class Biblioteca {
    private String nome;
    private ArrayList<Livro> alLivros;
    private float investimento;


    // Construtor
    public Biblioteca(String nome) {
        this.nome     = nome;
        this.alLivros = new ArrayList<Livro>();
        investimento  = 0;
    }


    // Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Livro> getAlLivros() {
        return alLivros;
    }
    
    public int getAlLivrosSize() {
    	return alLivros.size();
    }
    
    public Livro getLivro(int i) {
    	return alLivros.get(i); 
    }
    
    public void addLivro(Livro livro) {
    	this.alLivros.add(livro);
    }

    public float getInvestimento() {
        return investimento;
    }

    public void setInvestimento() {
    	for (int i=0; i<alLivros.size(); i++) {
    		this.investimento += alLivros.get(i).getPreco();    		
    	}
    }


    // Redefinicao do metodo toString
    @Override
    public String toString() {
        return ("Biblioteca [Nome: " + nome + "Livros: " + alLivros + "Investimento: " + investimento);
    }


    // Metodo compareTo (para ordenacao)
}
