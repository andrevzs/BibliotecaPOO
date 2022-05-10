package Emprestimo;
import java.util.ArrayList;

/**
 * @author Andre Vinicius Zicka Schmidt
 * @version 1.0
 */

public class ListaEmprestimos {
    private ArrayList<Emprestimo> alEmprestimos;

    
    // Construtor
    public ListaEmprestimos() {
        super();
        this.alEmprestimos = new ArrayList<Emprestimo>();
    }


    // Metodo para adicionar 01 emprestimo na lista
    public void addEmprestimo(Emprestimo emprestimo) {
    	this.alEmprestimos.add(emprestimo);
    }

    // Getters & Setters
    public ArrayList<Emprestimo> getAlEmprestimos() {
    	return alEmprestimos;
    }
    
    public int getEmprestimosSize() {
    	return alEmprestimos.size();
    }


    // Redefinicao do metodo toString
    @Override
    public String toString() {
        return "foo";
    }
}
