package Biblioteca;
import java.util.ArrayList;

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

    public float getInvestimento() {
        return investimento;
    }

    public void setInvestimento(float investimento) {
        this.investimento = investimento;
    }


    // Redefinição do método toString
    @Override
    public String toString() {
        return ("Biblioteca [Nome: " + nome + "Livros: " + alLivros + "Investimento: " + investimento);
    }


    // Método compareTo (para ordenação)
}
