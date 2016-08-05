package Ifrn.tads.poo.biblioteca.sistema;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import Ifrn.tads.poo.biblioteca.materialdeleitura.*;
import Ifrn.tads.poo.biblioteca.usuarios.Administrador;
import Ifrn.tads.poo.biblioteca.usuarios.Usuario;

public class SistemaBiblioteca {
	
	public static void addAdm(Biblioteca biblioteca,int cdgAdm, String nomeA, String endeA, String cpfA){
		Administrador adm = new Administrador(cdgAdm, nomeA, endeA, cpfA);
		if(biblioteca.veriAdm(adm) == 1){
			System.out.println("Adminstrador ja cadastrado!");
		}else if(biblioteca.veriAdm(adm) == 2){
			System.out.println("CPF n�o disponivel para cadastro!");
		}
		biblioteca.addAdm(adm);
	}
	public static void devolver(int codUsu,Biblioteca biblioteca, Scanner sc, ItemAcervo alugado){
		Usuario usu = null;
		int dev = 0;
		usu = biblioteca.buscaUsuario(codUsu);
		ItemAcervo[] aluPeUsu = new ItemAcervo[usu.qtdAlugados()];
		aluPeUsu = usu.listaAlugados();
	    System.out.println("Digite uma data nesse formato dd/mm/yyyy: ");
		String dataRecebida = sc.nextLine();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
		Date dt = df.parse(dataRecebida);

		if (alugado.getPago()==false){
			if (CalcDias(alugado.getDataDevolucao(),) > 0 ){
				
			}
			System.out.println("Pagar? S/N");
			if(sc.hasNext())
		}
		System.out.println("Escolha o item a ser devolvido: ");
		for(int i = 0; i < aluPeUsu.length; i++){
			System.out.printf("Cod: %d, Titulo: %s",aluPeUsu[i].getCodigoItem(),aluPeUsu[i].getTitulo());
		}
		if(sc.hasNextInt())
			dev = sc.nextInt() - 1;
		if(aluPeUsu[dev] instanceof Livro){
			biblioteca.adicionarLivro((Livro) aluPeUsu[dev], new Integer(1));
		}else if(aluPeUsu[dev] instanceof Apostila){
			biblioteca.adicionarApostila((Apostila) aluPeUsu[dev], new Integer(1));
		}else if(aluPeUsu[dev] instanceof Texto)
			biblioteca.adicionarTexto((Texto) aluPeUsu[dev], new Integer(1));
		usu.devolver(aluPeUsu[dev]);
		
	}
	public static void alugar(int tipo, int codUsu, Biblioteca biblioteca, Scanner sc){
		SimpleDateFormat format = new SimpleDateFormat();
		int escolha = 0, i;
		Date data = new Date();
		switch(tipo){
			case 1:
				
				Livro listaL[] = new Livro[biblioteca.tamLivros()];
				listaL = biblioteca.listLivros();									
				System.out.println("Livros disponiveis\n");
				for(i = 0 ; i < listaL.length ; i++){
					System.out.printf("Cod: %d, Titulo: %s, Autor: %s, ISBN: %s, Edi��o: %d, "
							+ "Quantidade Disponivel: %d, Valor do Aluguel: %f\n"
							+ "",listaL[i].getCdg(),listaL[i].getTitulo(),listaL[i].getAutor(),listaL[i].getISBN(),listaL[i].getEdi(),biblioteca.qtdDoLivro(listaL[i]), listaL[i].getCusto());
				}
				System.out.println("Digite o c�digo do livro que deseja alugar: ");
				if(sc.hasNextInt())
					escolha = sc.nextInt();
				biblioteca.alugar(listaL[escolha - 1], data,7, codUsu);
				System.out.printf("O livro deve ser entregue at� o dia: ");
				System.out.println(format.format(listaL[escolha].getDataDevolucao()));
				break;
			case 2:
				Texto listaT[] = new Texto[biblioteca.qtdTxt()];
				listaT = biblioteca.listTxt();
				System.out.println("Textos disponiveis: ");
				for (i = 0; i < listaT.length; i++) {
					System.out.printf("Cod: %d, Titulo: %s, Autor: %s"
							+ "", listaT[i].getCodigoItem(), listaT[i].getTitulo(), listaT[i].getAutor());
				}
				System.out.println("Digite o c�digo do texto que deseja alugar: ");
				if(sc.hasNextInt())
					escolha = sc.nextInt();
				biblioteca.alugar(listaT[escolha - 1], data, 15, codUsu);
				System.out.printf("O texto deve ser entregue at� o dia: ");
				System.out.println(format.format(listaT[escolha].getDataDevolucao()));
				break;
			case 3:
				Apostila listaA[] = new Apostila[biblioteca.qtdApo()];
				listaA = biblioteca.listApostila();
				System.out.println("Textos disponiveis: ");
				for (i = 0; i < listaA.length; i++) {
					System.out.printf("Cod: %d, Titulo: %s, Autor: %s"
							+ "", listaA[i].getCodigoItem(), listaA[i].getTitulo(), listaA[i].getAutor());
				}
				System.out.println("Digite o c�digo da apostila que deseja alugar: ");
				if(sc.hasNextInt())
					escolha = sc.nextInt();
				biblioteca.alugar(listaA[escolha - 1], data, 15, codUsu);
				System.out.printf("A apostila deve ser entregue at� o dia: ");
				System.out.println(format.format(listaA[escolha].getDataDevolucao()));
				break;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao = -1,i = 0, cdgLivro = 1, cdgUsu = 1, cdgAdm = 1;
		String nome;
		Biblioteca biblioteca;
		
		
		System.out.println("Bem Vindo ao asistente de configura��o do seu sistema de biblioteca!\n"
				+ "Para come�ar digite o nome da sua biblioteca: ");
		nome = sc.nextLine();
		biblioteca = new Biblioteca(nome);
		System.out.println("1 Adicionar Administrador\n2 Adicionar livro\n3 Alugar\n4 listar\n5 Teste CPF");
		opcao = sc.nextInt();
		while(opcao != 0){
			
			switch(opcao){
				case 1:
					String cpfA = null,nomeA = null,endeA = null;
					
					System.out.print("Digite o nome: ");
					if(sc.hasNext())
						nomeA = sc.next();
					System.out.print("Digite o endere�o: ");
					if(sc.hasNext())
						endeA = sc.next();
					System.out.print("Digite o cpf: ");
					if(sc.hasNext())
						cpfA = sc.next();					
					if(biblioteca.verificarCPF(cpfA) == 1){
						System.out.println("Tamanho inv�lido!");						
					}else{
						addAdm(biblioteca, cdgAdm++,nomeA, endeA, cpfA);
					}
					break;
				case 2:
					String tit = null, autor, isbn;
					double valor = 0;
					int qtd = 0,edi = 0;					
					System.out.println("Titulo: ");
					if(sc.hasNext()){
						tit = sc.next();
					}
					System.out.println("Autor: ");
					autor = sc.next();
					System.out.println("ISBN: ");
					isbn = sc.next();					
					System.out.println("Edi��o: ");
					edi = sc.nextInt();
					System.out.println("Quantidade: ");
					qtd = sc.nextInt();
					System.out.println("Insira o valor do aluguel do livro: ");
					if(sc.hasNextDouble())
						valor = sc.nextDouble();
					if(biblioteca.verificarISBN(isbn)){
						Livro novo = new Livro(tit,autor,isbn,new Integer(edi), cdgLivro++,valor);
						biblioteca.adicionarLivro(novo, qtd);
					}else{
						System.out.println("N�mero do ISBN invalido ou repetido!");
					}
					
					break;
				case 3:
					int escolha = -1 ,cod = -1;
					System.out.print("Caso queira alugar um livro digite 1 para textos 2 e apostilas 3: ");
					if(sc.hasNextInt())
						escolha = sc.nextInt();
					System.out.print("Digite o c�digo do Usuario: ");
					if(sc.hasNextInt())
						cod = sc.nextInt();
					try{
						alugar(escolha,cod,biblioteca,sc);
					}catch(ArrayIndexOutOfBoundsException e){
						System.out.println("C�digo do livro ou do usu�rio inv�lido! Tente novamente.");
					}
					break;
				case 4:
					Livro listar[] = new Livro[biblioteca.tamLivros()];
					listar = biblioteca.listLivros();
					for(i = 0 ; i < listar.length ; i++){
						System.out.printf("Cod: %d, Titulo: %s, Autor: %s, ISBN: %s, Edi��o: %d, "
								+ "Quantidade Disponivel: %d\n"
								+ "",listar[i].getCdg(),listar[i].getTitulo(),listar[i].getAutor(),listar[i].getISBN(),listar[i].getEdi(),biblioteca.qtdDoLivro(listar[i]));
					}
					break;
				case 5:
					String cpfU = null,nomeU = null, enderecoU = null;;
					Usuario usu;
					System.out.print("Digite o nome: ");
					if(sc.hasNext())
						nomeU = sc.next();
					System.out.print("Digite o endere�o: ");
					if(sc.hasNext())
						enderecoU = sc.next();
					System.out.print("Digite o cpf: ");
					if(sc.hasNext())
						cpfU = sc.next();					
					if(biblioteca.verificarCPF(cpfU) == 1){
						System.out.println("Tamanho inv�lido!");						
					}else{
						usu = new Usuario(cdgUsu, nomeU, enderecoU, cpfU);
						if(biblioteca.veriUsu(usu) == 1){
							System.out.println("Usuario ja cadastrado!");
						}else if(biblioteca.veriUsu(usu) == 2){
							System.out.println("CPF n�o disponivel para cadastro!");
						}
						biblioteca.addUsuario(usu);
					}					
					break;
				case 6:
					
					break;
				default:
					break;
			}
			System.out.println("1 Adicionar Administrador\n2 Adicionar livro\n3 Alugar\n4 listar\n5 Teste CPF");
			if(sc.hasNextInt())
				opcao = sc.nextInt();
		}
		
	}

}
