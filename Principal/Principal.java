package Principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

import Amigo.*;
import Emprestimo.*;
import Biblioteca.*;

/**
 * @author Andre Vinicius Zicka Schmidt
 * @version 1.0
 * Programacao Orientada a Objetos (POO)
 * Trabalho 1 - Controle de Biblioteca Pessoal
 */

public class Principal {
	
	private static Biblioteca biblioteca 		 = new Biblioteca("Biblioteca Pessoal");
	private static ListaEmprestimos emprestimos  = new ListaEmprestimos();
	private static ListaAmigos amigos 			 = new ListaAmigos();
	private static ListaEmprestimos emprestados  = new ListaEmprestimos();
	
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean rodar   = true;
		
		// Criacao de livros como exemplo
		biblioteca.addLivro("Hamlet", "William Shakespeare", 24.90f);
		biblioteca.addLivro("O Retrato de Dorian Gray", "Oscar Wilde", 29.86f);
		biblioteca.addLivro("O Medico e o Monstro", "Robert Louis Stevenson", 18.64f);
		biblioteca.addLivro("Os Sofrimentos do Jovem Werther", "Goethe", 17.52f);
		
		// Criacao de amigos como exemplo
		amigos.addAmigo("Eduardo Scaburi Costa Barros", "41 9 9851-1409");
		amigos.addAmigo("Luiz Felipe Sprada de Medeiros", "41 9 9208-8710");
		
		while(rodar == true) {
			int opcao = 0;
			
			limparConsole();
			System.out.println();
			System.out.println("========= Bem vindo a Biblioteca POO! =========");
			System.out.println("~~~~~    Escolha uma das opcoes abaixo    ~~~~~");
			System.out.println("1- Cadastrar livro");
			System.out.println("2- Cadastrar amigo");
			System.out.println("3- Emprestar");
			System.out.println("4- Devolver");
			System.out.println("5- Listar emprestimos atuais");
			System.out.println("6- Listar historico de emprestimos");
			System.out.println("7- Listar biblioteca");
			System.out.println("8- Alterar estado");
			System.out.println("0- Sair");
			System.out.println("");

			System.out.print("Digite aqui sua escolha: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			System.out.println("");
			
			switch(opcao) {
				case 0:  // Sair
					sair();
					break;
				
				case 1:  // Cadastrar livro
					System.out.println("********** Cadastro de Livro **********");
					cadastrarLivro();
					break;
				
				case 2:  // Cadastrar amigo
					System.out.println("********** Cadastro de Amigo **********");
					cadastrarAmigo();
					break;
				
				case 3:  // Emprestar
					System.out.println("********* Emprestimo de Livro *********");
					emprestar();
					break;
				
				case 4:  // Devolver
					System.out.println("********* Devolucao de Livro **********");
					devolver();
					break;
					
				case 5:  // Listar emprestimos atuais
					System.out.println("********* Listar Emprestimos **********");
					listarEmprestimos();
					break;
					
				case 6:  // Listar historico de emprestimos
					System.out.println("********** Listar Historico ***********");
					listarHistorico();
					break;
					
				case 7:  // Listar biblioteca
					System.out.println("********** Listar Biblioteca **********");
					listarBiblioteca();
					break;
					
				case 8:  // Alterar estado
					System.out.println("*********** Alterar Estado ************");
					alterarEstado();
					break;
					
				default:
					System.out.println("Camarada, voce digitou uma opcao que nao tem no menu!");
					break;
			}		
		}
	}

		
	private static void cadastrarLivro() {
	
		// perguntar titulo
		System.out.println("Digite o titulo do livro: ");
		String titulo = entrada.nextLine();
		
		// perguntar autor
		System.out.println("Digite o autor do livro: ");
		String autor = entrada.nextLine();
		
		// perguntar preco
		System.out.println("Digite o preco do livro (R$XX,XX): ");
		float preco = entrada.nextFloat();
		entrada.nextLine();
		
		// Instanciar o livro cadastrado
		biblioteca.addLivro(titulo, autor, preco);
		
		
		// Mostrar os dados do livro cadastrado
		limparConsole();
		System.out.println("\n**********************************************");
		System.out.println("O livro com os seguintes dados foi cadastrado:");
		System.out.println();
		System.out.println("Titulo: " + titulo);
		System.out.println("Autor: " + autor);
		System.out.println("Preco: R$" + String.format("%.2f", preco));
		
		System.out.println("\n***** Tecle enter para continuar *****");
		entrada.nextLine();
	}
	
	private static void cadastrarAmigo() {
		
		// perguntar nome
		System.out.println("Digite o nome do amigo: ");
		String nome = entrada.nextLine();
		
		// perguntar celular
		System.out.println("Digite o celular do amigo (DDD XXXXX-XXXX): ");
		String celular = entrada.nextLine();
				
		// adicionar o amigo na lista de amigos 
		amigos.addAmigo(nome, celular);
		
		// mostrar os dados do amigo cadastrado
		limparConsole();
		System.out.println("\n**********************************************");
		System.out.println("O amigo com os seguintes dados foi cadastrado:");
		System.out.println();
		System.out.println("Nome: " + nome);
		System.out.println("Celular: " + celular);
				
		System.out.println("\n***** Tecle enter para continuar *****");
		entrada.nextLine();
	}
	
	private static void emprestar() {
		ArrayList<Livro> livrosDisponiveis = new ArrayList<Livro>();
		
		// selecionar livros disponiveis
		for (Livro livro : biblioteca.getAlLivros()) {
			if (livro.getDispLivro() != Disponibilidade.EMPRESTADO && livro.getDispLivro() != Disponibilidade.EXTRAVIADO) {
				livrosDisponiveis.add(livro);
			}
		}
		
		// mostrar livros disponiveis
		System.out.println("Os seguintes livros estao disponiveis:");
		for (int i=0; i<livrosDisponiveis.size(); i++) {
			System.out.println("\nLivro " + livrosDisponiveis.get(i).getIdLivro());
			System.out.println("Titulo: " + livrosDisponiveis.get(i).getTitulo());
			System.out.println("Autor: " + livrosDisponiveis.get(i).getAutor());
		}
		
		// perguntar o id do livro
		System.out.println("\nDigite o numero do livro que deseja emprestar: ");
		int idLivroSelecionado = entrada.nextInt();
		entrada.nextLine();

		// mostrar os amigos cadastrados
		System.out.println("\nOs amigos cadastrados sao:\n");
		for (int i=0; i<amigos.getListaAmigosSize(); i++) {
			System.out.println(amigos.getAmigo(i).getIdAmigo() + " - " + amigos.getAmigo(i).getNome());
		}

		// perguntar o id do amigo
		System.out.println("\nDigite o id do amigo que pegou o livro: ");
		int idAmigoSelecionado = entrada.nextInt();
		entrada.nextLine();

		// criar emprestimo		
		Emprestimo emprestimo = new Emprestimo(idAmigoSelecionado, idLivroSelecionado, biblioteca, amigos); 
		
		// adicionar o emprestimo ao arraylist de emprestimos
		emprestimos.addEmprestimo(emprestimo);

		// mudar a disponibilidade do livro para EMPRESTADO
		emprestimo.setDataEmprestimo();
		emprestimo.getLivro().setDispLivro(Disponibilidade.EMPRESTADO);
		
		System.out.println("\nO livro " + emprestimo.getLivro().getTitulo() + " foi emprestado para " + emprestimo.getAmigo().getNome());
		System.out.println("\n***** Tecle enter para continuar *****");
		entrada.nextLine();

	}
	
	private static void devolver() {
			
		// mostrar livros emprestados
		if (emprestimos.getEmprestimosSize() == 0) {
			System.out.println("Nao ha livros emprestados!");
		}
		else {
			System.out.println("Os livros que estao emprestados sao:\n");
			for (int i=0; i<emprestimos.getEmprestimosSize(); i++) {
				if ((emprestimos.getAlEmprestimos().get(i).getDataDevolucao() == null)) {
					System.out.println((i+1) + " - " + emprestimos.getAlEmprestimos().get(i).getLivro().getTitulo());
					System.out.println();
				}
			}
	
			// perguntar o id do livro
			System.out.println("Digite o numero do livro que deseja devolver: ");
			int idLivroSelecionado = entrada.nextInt();
			entrada.nextLine();
	
			// selecionar o livro do arraylist
			Emprestimo emprestimoSelecionado = emprestimos.getAlEmprestimos().get(idLivroSelecionado-1);
	
			// mudar a disponibilidade do livro para DISPONIVEL
			emprestimoSelecionado.getLivro().setDispLivro(Disponibilidade.DISPONIVEL);
			emprestimoSelecionado.setDataDevolucao();
			
			System.out.println("\nO livro " + emprestimoSelecionado.getLivro().getTitulo() + " foi devolvido.");
		}
		System.out.println("\n***** Tecle enter para continuar *****");
		entrada.nextLine();

	}
	
	private static void listarEmprestimos() {
		// selecionar livros EMPRESTADOS do arraylist de emprestimos
		for (int i=0; i<emprestimos.getEmprestimosSize(); i++) {
			if ((emprestimos.getAlEmprestimos().get(i).getDataDevolucao()) == null) {
				Emprestimo emprestimo = emprestimos.getAlEmprestimos().get(i);
				emprestados.addEmprestimo(emprestimo);
			}
		}


		// imprimir o arraylist de emprestados
		System.out.println("Os livros que estao emprestados atualmente sao:");
		
		for (int i=0; i<emprestados.getEmprestimosSize(); i++) {
			if ((emprestimos.getAlEmprestimos().get(i).getDataDevolucao() == null)) {
				System.out.println("\n" + (i+1) + " - " + emprestados.getAlEmprestimos().get(i).getLivro().getTitulo());				
			}
		}
		
		System.out.println("\n***** Tecle enter para continuar *****");
		entrada.nextLine();

	}
	
	private static void listarHistorico() {
		@SuppressWarnings("unchecked")
		ArrayList<Livro> bibliotecaOrdenada = (ArrayList<Livro>) biblioteca.getAlLivros().clone();
		Collections.sort(bibliotecaOrdenada);
		
		System.out.println("Livros na biblioteca:\n");
		
		for (int i=0; i<(biblioteca.getAlLivros().size()); i++) {
			System.out.println("Livro " + (i+1) + " " + bibliotecaOrdenada.get(i).getTitulo());
			System.out.println(bibliotecaOrdenada.get(i).getDispLivro());
			System.out.println();
		}
		
		// perguntar o id do livro que quer saber
		System.out.println("\nDigite o numero do livro que deseja: ");
		int idSelecionado = entrada.nextInt();		
		Livro livroSelecionado = biblioteca.getLivro(idSelecionado-1);
		
		// imprimir as informacoes de emprestimo do livro
		for (Emprestimo emprestimo:emprestimos.getAlEmprestimos()) {
			if (emprestimo.getLivro().getTitulo() == livroSelecionado.getTitulo()) {
				System.out.println("\nLivro: " + emprestimo.getLivro().getTitulo());
				System.out.println("Emprestado para: " + emprestimo.getAmigo().getNome());
				System.out.println("Data de emprestimo: " + emprestimo.getDataEmprestimo());
				System.out.println("Data de devolucao:  " + emprestimo.getDataDevolucao());
				
			}
		}
		
		System.out.println("\n***** Tecle enter para continuar *****");
		entrada.nextLine();
	}
	
	private static void listarBiblioteca() {
		// ordenar o arraylist da biblioteca
		
		// imprimir a biblioteca mostrando:
		// titulo - disponibilidade - preco - investimento total biblioteca
		@SuppressWarnings("unchecked")
		ArrayList<Livro> bibliotecaOrdenada = (ArrayList<Livro>) biblioteca.getAlLivros().clone();
		Collections.sort(bibliotecaOrdenada);
		
		System.out.println("Livros na biblioteca:\n");
		
		for (int i=0; i<(biblioteca.getAlLivros().size()); i++) {
			System.out.println("Titulo: " + bibliotecaOrdenada.get(i).getTitulo());
			System.out.println(bibliotecaOrdenada.get(i).getDispLivro());
			System.out.println("Preco: R$" + String.format("%.2f",bibliotecaOrdenada.get(i).getPreco()));
			System.out.println();
		}

		System.out.println("Investimento total na biblioteca: R$" + String.format("%.2f", biblioteca.getInvestimento()));
		System.out.println("\n***** Tecle enter para continuar *****");
		entrada.nextLine();
			
	}
	
	private static void alterarEstado() {
		// perguntar o id de um livro
		System.out.println("De qual livro deseja alterar o estado?\n");
		for (int i=0; i<(biblioteca.getAlLivros().size()); i++) {
			System.out.println("Livro " + biblioteca.getLivro(i).getIdLivro() + " - " + biblioteca.getLivro(i).getTitulo());
			System.out.println(biblioteca.getLivro(i).getDispLivro());
			System.out.println();
		}
		System.out.println("Numero do livro escolhido: ");
		int escolha = entrada.nextInt() - 1;
		entrada.nextLine();
		
		Livro livroEscolhido = biblioteca.getLivro(escolha);
		boolean opcaoValida = false;
		int disponibilidade = 0;
		
		// perguntar o estado que deseja colocar
			while (opcaoValida == false) {
			System.out.println("\nSelecione o estado que deseja");
			System.out.println("1- Disponivel");
			System.out.println("2- Consulta local");
			System.out.println("3- Emprestado");
			System.out.println("4- Danificado");
			System.out.println("5- Extraviado");
			System.out.println("");
			System.out.println("Estado escolhido: ");
			disponibilidade = entrada.nextInt();
			entrada.nextLine();
			
			// se estiver emprestado nao pode ser consulta local
			if (livroEscolhido.getDispLivro() == Disponibilidade.EMPRESTADO && disponibilidade == 2) {
				System.out.println("O livro que voce escolheu esta Emprestado e nao pode\nser alterado para Consulta Local!");
				System.out.println("\n***** Tecle enter para continuar *****");
				entrada.nextLine();
				opcaoValida = false;
			}
			else {
				opcaoValida = true;
			}
		}
		
		if (opcaoValida == true) {
			switch (disponibilidade) {
				case 1:
					livroEscolhido.setDispLivro(Disponibilidade.DISPONIVEL);
					break;
				case 2:
					livroEscolhido.setDispLivro(Disponibilidade.CONSULTALOCAL);
					break;
				case 3:
					livroEscolhido.setDispLivro(Disponibilidade.EMPRESTADO);
					break;
				case 4:
					livroEscolhido.setDispLivro(Disponibilidade.DANIFICADO);
					break;
				case 5:
					livroEscolhido.setDispLivro(Disponibilidade.EXTRAVIADO);
					break;
			}
		}
		
		
		
	}

	private static void sair() {
		System.exit(0);
	}
	
	public final static void limparConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
}
