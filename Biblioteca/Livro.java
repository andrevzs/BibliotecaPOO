package Biblioteca;

/**
 * @author Andre Vinicius Zicka Schmidt
 * @version 1.0
 */

public class Livro {
    private int idLivro;
    private String titulo;
    private String autor;
    private float preco;
    private Disponibilidade dispLivro;


    // Construtor
    public Livro(String titulo, String autor, float preco, Disponibilidade dispLivro, Biblioteca biblioteca) {
        super();
        this.idLivro   = biblioteca.getAlLivrosSize() + 1;
        this.titulo    = titulo;
        this.autor     = autor;
        this.preco     = preco;
        this.dispLivro = dispLivro;
    }


    // Getters & Setters
    public int getIdLivro() {
        return idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Disponibilidade getDispLivro() {
        return dispLivro;
    }

    public void setDispLivro(Disponibilidade disponibilidade) {
        this.dispLivro = disponibilidade;
    }


    // Redefinicao do metodo toString
    @Override
    public String toString() {
    	return ("ID: " + this.idLivro + 
    			"\nTitulo: " + this.titulo +
    			"\nAutor: " + this.autor +
    			"\nPreco: R$" + this.preco +
    			"\nDisponibilidade: " + this.dispLivro);
    }

    // Metodo compareTo (para ordenacao)
    public int compareTo(Livro livro) {
    	return this.titulo.compareTo(livro.getTitulo());
    }
}
