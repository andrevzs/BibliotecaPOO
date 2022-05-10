package Emprestimo;
import java.time.LocalDate;
import Amigo.Amigo;
import Biblioteca.Livro;

/**
 * @author Andre Vinicius Zicka Schmidt
 * @version 1.0
 */

public class Emprestimo {
    private int idAmigo;
    private int idLivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Amigo amigo;

    // Construtor
    public Emprestimo(int idAmigo, int idLivro, Amigo amigo) {
        super();
        this.idAmigo        = idAmigo;
        this.idLivro        = idLivro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao  = null;
        this.livro = null;
        this.amigo = amigo;
    }
    
    public Emprestimo(int idAmigo, int idLivro, Livro livro, Amigo amigo) {
        super();
        this.idAmigo        = idAmigo;
        this.idLivro        = idLivro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao  = null;
        this.livro = livro;
        this.amigo = amigo;
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

    public void setDataEmprestimo() {
        this.dataEmprestimo = LocalDate.now();
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


    // Redefinicao do metodo toString()
    @Override
    public String toString() {
        return "Emprestimo\n" + "Livro: " + livro + "\nAmigo: " + amigo;
    }
}
