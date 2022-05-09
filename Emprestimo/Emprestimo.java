package Emprestimo;
import java.time.LocalDate;
import Amigo.Amigo;
import Biblioteca.Livro;

public class Emprestimo {
    private int idAmigo;
    private int idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    
    private Livro livro;
    private Amigo amigo;

    // Construtor
    public Emprestimo(int idAmigo, int idLivro, LocalDate dataEmprestimo, LocalDate dataDevolucao, Livro livro, Amigo amigo) {
        super();
        this.idAmigo        = idAmigo;
        this.idLivro        = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao  = dataDevolucao;
    }
    
    // Getters & Setters
    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int id) {
        this.idAmigo = id;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int id) {
        this.idLivro = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate data) {
        this.dataEmprestimo = data;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate data) {
        this.dataDevolucao = data;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }


    // Redefiniçção do método toString()
    @Override
    public String toString() {
        return "foo";
    }
}
