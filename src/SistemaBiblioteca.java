import java.util.*;

import Ifrn.tads.poo.biblioteca.materialdeleitura.*;

public class SistemaBiblioteca {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = -1,i = 0, cdgLivro = 1;
		String nome;
		Biblioteca biblioteca;
		System.out.println("Bem Vindo ao asistente de configuração do seu sistema de biblioteca!\n"
				+ "Para começar digite o nome da sua biblioteca: ");
		nome = sc.nextLine();
		biblioteca = new Biblioteca(nome);
		System.out.println("2 Adicionar livro\n3 Alugar\n4 listar");
		opcao = sc.nextInt();
		while(opcao != 0){
			
			switch(opcao){
				case 1:
					System.out.println("Digite o nome do administrador: \n"
							+ "");
					break;
				case 2:
					String tit = null, autor, isbn;					
					int qtd = 0,edi = 0;					
					System.out.println("Titulo: ");
					if(sc.hasNext()){
						tit = sc.next();
					}
					System.out.println("Autor: ");
					autor = sc.next();
					System.out.println("ISBN: ");
					isbn = sc.next();
					System.out.println(isbn.length());
					System.out.println("Edição: ");
					edi = sc.nextInt();
					System.out.println("Quantidade: ");
					qtd = sc.nextInt();
					
					if(biblioteca.verificarISBN(isbn)){
						Livro novo = new Livro(tit,autor,isbn,new Integer(edi), cdgLivro++);
						biblioteca.adicionarLivro(novo, qtd);
					}else{
						System.out.println("Número do ISBN invalido ou repetido!");
					}
					
					break;
				case 3:
					Livro lista[] = new Livro[biblioteca.tamLivros()];
					lista = biblioteca.listLivros();
					int escolha = 0;
					Date data = new Date();					
					System.out.println("Livros disponiveis");
					for(i = 0 ; i < lista.length ; i++){
						System.out.printf("Cod: %d, Titulo: %s, Autor: %s, ISBN: %s, Edição: %d, "
								+ "Quantidade Disponivel: %d\n"
								+ "",lista[i].getCdg(),lista[i].getTitulo(),lista[i].getAutor(),lista[i].getISBN(),lista[i].getEdi(),biblioteca.qtdDoLivro(lista[i]));
					}
					System.out.print("Digite o código do livro desejado: ");
					if(sc.hasNextInt())
						escolha = sc.nextInt();
					biblioteca.alugar(lista[escolha - 1], data,7);
					break;
				case 4:
					Livro listar[] = new Livro[biblioteca.tamLivros()];
					listar = biblioteca.listLivros();
					for(i = 0 ; i < listar.length ; i++){
						System.out.printf("Cod: %d, Titulo: %s, Autor: %s, ISBN: %s, Edição: %d, "
								+ "Quantidade Disponivel: %d\n"
								+ "",listar[i].getCdg(),listar[i].getTitulo(),listar[i].getAutor(),listar[i].getISBN(),listar[i].getEdi(),biblioteca.qtdDoLivro(listar[i]));
					}
				default:
					break;
			}
			System.out.println("2 Adicionar livro\n3 Alugar\n 4 Listar");
			if(sc.hasNextInt())
				opcao = sc.nextInt();
		}
		
	}

}
