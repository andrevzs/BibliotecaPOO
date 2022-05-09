package Biblioteca;

public class Livro {
    private int idLivro;
    private String titulo;
    private String autor;
    private float preco;
    private Disponibilidade dispLivro;


    // Construtor
    public Livro(int idLivro, String titulo, String autor, float preco, Disponibilidade dispLivro) {
        super();
        this.idLivro   = idLivro;
        this.titulo    = titulo;
        this.autor     = autor;
        this.preco     = preco;
        this.dispLivro = dispLivro;
    }


    // Getters & Setters
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int id) {
        this.idLivro = id;
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


    // Redefinição do método toString


    // Método compareTo (para ordenação)
}
