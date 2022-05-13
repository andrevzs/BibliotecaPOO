package Emprestimo;
import java.time.LocalDate;

import Amigo.*;
import Biblioteca.*;

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
    public Emprestimo(int idAmigo, int idLivro, Biblioteca biblioteca, ListaAmigos amigos) {
        super();
        this.idLivro        = idLivro;
        this.idAmigo        = idAmigo;
        this.livro 			= biblioteca.getLivro(idLivro-1);
        this.amigo 			= amigos.getAmigo(idAmigo-1);
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao  = null;
    }
    
    
    // Getters & Setters
    public int getIdLivro() {
    	return idLivro;
    }
        
    public int getIdAmigo() {
        return idAmigo;
    }
    
    public Livro getLivro() {
    	return livro;
    }
    
    public Amigo getAmigo() {
    	return amigo;
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

    public void setDataDevolucao() {
        this.dataDevolucao = LocalDate.now();
    }


    // Redefinicao do metodo toString()
    @Override
    public String toString() {
        return "Emprestimo\n" + "Livro: " + livro + "\nAmigo: " + amigo;
    }
}
