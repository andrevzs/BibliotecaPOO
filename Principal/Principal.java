package Principal;

// import java.util.ArrayList;
import java.util.Scanner;

import Amigo.*;
import Emprestimo.*;
import Biblioteca.*;


public class Principal {
	
	private static Biblioteca bib 				= new Biblioteca("Biblioteca Pessoal");
	private static ListaEmprestimos emprestimos = new ListaEmprestimos();
	private static ListaAmigos amigos 			= new ListaAmigos();
	
	
	public static void main(String[] args) {
		boolean rodar   = true;
		int opcao 	    = 0;
		Scanner entrada = new Scanner(System.in);
		
		/*
		int idAmigo;
		idAmigo = amigos.addAmigo("Fulano", "(41) 99876-5432");
		System.out.println("Adicionado com codigo " + idAmigo);

		idAmigo = amigos.addAmigo("Ciclano", "(47) 98123-2121");
		System.out.println("Adicionado com codigo " + idAmigo);

		for (int i =0; i < amigos.getListaAmigosSize(); i++) {
			Amigo amigo = amigos.getAmigo(i);
			System.out.println("Nome: " + amigo.getNome());
			System.out.println("Celular: " + amigo.getCelular());
		}
		*/

		while(rodar == true) {
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

		entrada.close();
	}

		
	private static void cadastrarLivro() {
		Scanner entrada = new Scanner(System.in);
		int id 					  = 0;
		String titulo 			  = "";
		String autor 			  = "";
		float preco 			  = 00.00f;
		int disponibilidade 	  = 0;
		Disponibilidade dispLivro = Disponibilidade.DISPONIVEL;
		
		// gerar id
		id = 0;
		
		// perguntar titulo
		System.out.println("Digite o titulo do livro: ");
		while(entrada.hasNextLine()) {
			titulo = entrada.next();
		}
		
		// perguntar autor
		System.out.println("Digite o autor do livro: ");
		while(entrada.hasNextLine()) {
			autor = entrada.nextLine();
		}
		
		// perguntar preco
		System.out.println("Digite o preco do livro (R$XX.XX): ");
		while(entrada.hasNextFloat()) {
			preco = entrada.nextFloat();
		}
		
		// perguntar disponibilidade
		System.out.println("Agora, selecione a disponibilidade ");
		System.out.println("1- Disponivel");
		System.out.println("2- Consulta local");
		System.out.println("3- Emprestado");
		System.out.println("4- Danificado");
		System.out.println("5- Extraviado");
		System.out.println("");
		System.out.println("Digite uma opcao:");
		while(entrada.hasNextInt()) {
			disponibilidade = entrada.nextInt();
		}
	
		entrada.close();
		
		switch (disponibilidade) {
			case 1:
			dispLivro = Disponibilidade.DISPONIVEL;
			case 2:
			dispLivro = Disponibilidade.CONSULTALOCAL;
			case 3:
			dispLivro = Disponibilidade.EMPRESTADO;
			case 4:
			dispLivro = Disponibilidade.DANIFICADO;
			case 5:
			dispLivro = Disponibilidade.EXTRAVIADO;
		}
		
		// Instanciar o livro cadastrado
		Livro livro = new Livro(id, titulo, autor, preco, dispLivro);
		
		// Mostrar os dados do livro cadastrado
		System.out.println();
		System.out.println("O livro com os seguintes dados foi cadastrado:");
		System.out.println();
		System.out.println("Titulo: " + livro.getTitulo());
		System.out.println("Autor: " + livro.getAutor());
		System.out.println("Preco: R$" + livro.getPreco());
		System.out.println("Disponibilidade: " + livro.getDispLivro());
	}
	
	private static void cadastrarAmigo() {
		Scanner entrada = new Scanner(System.in);
		int id;
		String nome;
		String celular;
		
		// gerar id
		id = 0;
		
		// perguntar nome
		System.out.println("Digite o nome do amigo: ");
		nome = entrada.nextLine();
		
		// perguntar celular
		System.out.println("Digite o celular do amigo: ");
		celular = entrada.nextLine();
		entrada.close();
		
		// adicionar amigo ao arraylist de amigos
		
		
		// Instanciar o amigo cadastrado
		Amigo amigo = new Amigo(id, nome, celular);
	}
	
	private static void emprestar() {
		Scanner entrada = new Scanner(System.in);
		Livro livro;
		
		// mostrar livros disponiveis
		System.out.println();
		
		// perguntar o id do livro
		System.out.println("Digite o id do livro que deseja emprestar: ");
		entrada.nextInt();

		// mostrar os amigos cadastrados
		System.out.println();

		// perguntar o id do amigo
		System.out.println("Digite o id do amigo que pegou o livro: ");
		entrada.nextInt();
		entrada.close();

		// selecionar o livro do arraylist da biblioteca


		// adicionar o livro ao arraylist de emprestimos


		// mudar a disponibilidade do livro para EMPRESTADO
		livro.setDispLivro(Disponibilidade.EMPRESTADO);

	}
	
	private static void devolver() {
		Scanner entrada = new Scanner(System.in);
		Livro livro;
		
		// mostrar livros emprestados
		System.out.println();

		// perguntar o id do livro
		System.out.println("Digite o id do livro que deseja devolver: ");
		entrada.nextInt();
		entrada.close();

		// selecionar o livro do arraylist


		// mudar a disponibilidade do livro para DISPONIVEL
		livro.setDispLivro(Disponibilidade.DISPONIVEL);

	}
	
	private static void listarEmprestimos() {
		// adicionar livros selecionados a um arraylist de emprestados


		// selecionar livros EMPRESTADOS do arraylist de emprestimos


		// imprimir o arraylist de emprestados
		System.out.println();

	}
	
	private static void listarHistorico() {
		// perguntar o id do livro que quer saber
		// imprimir as informacoes de emprestimo do livro
	}
	
	private static void listarBiblioteca() {
		// ordenar o arraylist da biblioteca
		// imprimir a biblioteca mostrando:
		// titulo - disponibilidade - preco - investimento total biblioteca
		System.out.println();

			
	}
	
	private static void alterarEstado() {
		// perguntar o id de um livro
		// perguntar o estado que deseja colocar
		// se estiver emprestado nao pode ser consulta local
	}

	private static void sair() {
		System.exit(0);
	}
}
