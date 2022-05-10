package Principal;

import java.util.ArrayList;
import java.util.Collections;
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
	
	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean rodar   = true;
		
		// Criacao de livros como exemplo
		Livro hamlet  = new Livro(0, "Hamlet", "William Shakespeare", 24.90f, Disponibilidade.DISPONIVEL);
		Livro gray    = new Livro(1, "O Retrato de Dorian Gray", "Oscar Wilde", 29.86f, Disponibilidade.DISPONIVEL);
		Livro jekyll  = new Livro(2, "O Medico e O Monstro", "Robert Louis Stevenson", 18.64f, Disponibilidade.DISPONIVEL);
		Livro werther = new Livro(3, "Os Sofrimentos do Jovem Werther", "Goethe", 17.52f, Disponibilidade.DISPONIVEL);
		
		biblioteca.addLivro(hamlet);
		biblioteca.addLivro(gray);
		biblioteca.addLivro(jekyll);
		biblioteca.addLivro(werther);
		
		// Criacao de amigos como exemplo
		Amigo eduardo = new Amigo(0, "Eduardo Scaburi Costa Barros", "41 9 9851-1409");
		Amigo luiz    = new Amigo(1, "Luiz Felipe Sprada de Medeiros", "41 9 9208-8710");
		
		amigos.addAmigo(eduardo);
		amigos.addAmigo(luiz);
		
		while(rodar == true) {
			int opcao 	    = 0;
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
		Disponibilidade dispLivro = Disponibilidade.DISPONIVEL;
		
		// gerar id
		int id = biblioteca.getAlLivrosSize() + 1;
		
		// perguntar titulo
		System.out.println("Digite o titulo do livro: ");
		String titulo = entrada.nextLine();
		
		// perguntar autor
		System.out.println("Digite o autor do livro: ");
		String autor = entrada.nextLine();
		
		// perguntar preco
		System.out.println("Digite o preco do livro (R$XX.XX): ");
		float preco = entrada.nextFloat();
		entrada.nextLine();
		
		// perguntar disponibilidade
		System.out.println("Agora, selecione a disponibilidade ");
		System.out.println("1- Disponivel");
		System.out.println("2- Consulta local");
		System.out.println("3- Emprestado");
		System.out.println("4- Danificado");
		System.out.println("5- Extraviado");
		System.out.println("");
		System.out.println("Digite uma opcao:");
		int disponibilidade = entrada.nextInt();
		entrada.nextLine();
	
		// Selecionar a disponibilidade da enumeracao
		switch (disponibilidade) {
			case 1:
				dispLivro = Disponibilidade.DISPONIVEL;
				break;
			case 2:
				dispLivro = Disponibilidade.CONSULTALOCAL;
				break;
			case 3:
				dispLivro = Disponibilidade.EMPRESTADO;
				break;
			case 4:
				dispLivro = Disponibilidade.DANIFICADO;
				break;
			case 5:
				dispLivro = Disponibilidade.EXTRAVIADO;
				break;
		}
		
		// Instanciar o livro cadastrado
		Livro livro = new Livro(id, titulo, autor, preco, dispLivro);
		
		// Mostrar os dados do livro cadastrado
		System.out.println();
		System.out.println("O livro com os seguintes dados foi cadastrado:");
		System.out.println();
		System.out.println("Titulo: " + livro.getTitulo());
		System.out.println("Autor: " + livro.getAutor());
		System.out.println("Preco: R$" + String.format("%.2f", livro.getPreco()));
		System.out.println("Disponibilidade: " + livro.getDispLivro());
		
		// Adicionar o livro no arraylist da biblioteca
		biblioteca.addLivro(livro);
		

	}
	
	private static void cadastrarAmigo() {
		
		// gerar id
		int id = amigos.getListaAmigosSize() + 1;
		
		// perguntar nome
		System.out.println("Digite o nome do amigo: ");
		String nome = entrada.nextLine();
		
		// perguntar celular
		System.out.println("Digite o celular do amigo (DDD XXXXX-XXXX): ");
		String celular = entrada.nextLine();
				
		// Instanciar o amigo cadastrado
		Amigo amigo = new Amigo(id, nome, celular);
		
		// Mostrar os dados do amigo cadastrado
				System.out.println();
				System.out.println("O amigo com os seguintes dados foi cadastrado:");
				System.out.println();
				System.out.println("Nome: " + amigo.getNome());
				System.out.println("Celular: " + amigo.getCelular());
		
		// adicionar amigo ao arraylist de amigos
		amigos.addAmigo(amigo);
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
		System.out.println("Os seguintes livros estao disponiveis:\n");
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
			System.out.println(amigos.getAmigo(i).getIdAmigo() + " " + amigos.getAmigo(i).getNome());
		}

		// perguntar o id do amigo
		System.out.println("\nDigite o id do amigo que pegou o livro: ");
		int idAmigoSelecionado = entrada.nextInt();
		entrada.nextLine();

		// criar emprestimo
		Livro livroSelecionado = biblioteca.getAlLivros().get((idLivroSelecionado));
		Amigo amigoSelecionado = amigos.getAlAmigos().get((idAmigoSelecionado));
		
		Emprestimo emprestimo = new Emprestimo(idAmigoSelecionado, idLivroSelecionado, livroSelecionado, amigoSelecionado); 
		
		// adicionar o livro ao arraylist de emprestimos
		emprestimos.addEmprestimo(emprestimo);

		// mudar a disponibilidade do livro para EMPRESTADO
		livroSelecionado.setDispLivro(Disponibilidade.EMPRESTADO);
		
		System.out.println("\nO livro " + emprestimo.getLivro().getTitulo() + " foi emprestado para " + emprestimo.getAmigo().getNome());

	}
	
	private static void devolver() {
			
		// mostrar livros emprestados
		System.out.println("Os livros que estao emprestados sao:");

		// perguntar o id do livro
		System.out.println("Digite o numero do livro que deseja devolver: ");
		entrada.nextInt();
		entrada.nextLine();

		// selecionar o livro do arraylist


		// mudar a disponibilidade do livro para DISPONIVEL
		// livro.setDispLivro(Disponibilidade.DISPONIVEL);

	}
	
	private static void listarEmprestimos() {
		// selecionar livros EMPRESTADOS do arraylist de emprestimos
		for (Emprestimo emprestimo : emprestimos.getAlEmprestimos()) {
			
		}


		// imprimir o arraylist de emprestados
		System.out.println();

	}
	
	private static void listarHistorico() {
		// perguntar o id do livro que quer saber
		
		
		// imprimir as informacoes de emprestimo do livro
		System.out.println();
	}
	
	private static void listarBiblioteca() {
		// ordenar o arraylist da biblioteca
		
		// imprimir a biblioteca mostrando:
		// titulo - disponibilidade - preco - investimento total biblioteca
		System.out.println("Livros na biblioteca:");
		for (int i=0; i<(biblioteca.getAlLivros().size()); i++) {
			System.out.println("Titulo: ");
			System.out.println();
			System.out.println("Preco: ");
		}
		System.out.println("Investimento total na biblioteca: R$" + String.format("%2f", biblioteca.getInvestimento()));

			
	}
	
	private static void alterarEstado() {
		// perguntar o id de um livro
		
		
		// perguntar o estado que deseja colocar
		System.out.println("Selecione o estado que deseja");
		System.out.println("1- Disponivel");
		System.out.println("2- Consulta local");
		System.out.println("3- Emprestado");
		System.out.println("4- Danificado");
		System.out.println("5- Extraviado");
		System.out.println("");
		System.out.println("Digite uma opcao:");
		int disponibilidade = entrada.nextInt();
		entrada.nextLine();
		
		// se estiver emprestado nao pode ser consulta local
		
		
	}

	private static void sair() {
		System.exit(0);
	}
}
