import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Ifrn.tads.poo.biblioteca.materialdeleitura.*;

public class Biblioteca {
	String nomeBiblioteca;
	
	Map<Livro, Integer> livros;
	ArrayList<Apostila> apostilas = new ArrayList<Apostila>();
	ArrayList<Texto> textos = new ArrayList<Texto>();
	ArrayList<Administrador> admins = new ArrayList<Administrador>();
	ArrayList<Usuario> clientes = new ArrayList<Usuario>();
	
	public Biblioteca(String nome){
		this.nomeBiblioteca = nome;
		this.livros = new HashMap<>();
	}
	
	public boolean verificarISBN(String num){
		boolean verdade  = false, repetido = false;
		int i = 0;
		Livro[] lista = new Livro[this.livros.size()];
		lista = listLivros();
		System.out.println("teste1");
		while(i<lista.length){
			if(lista[i].getISBN() == num){
				repetido = true;
				System.out.println("passou 0");
			}				
		}
		System.out.println("teste2");
		System.out.println(num.length());
		if(num.length() == 13){
			System.out.println("passou");
			if((num.charAt(0) == '9') & (num.charAt(1) == '7') & (num.charAt(2) == '8') & (repetido == false)){
				System.out.println("passou2");
				verdade  = true;
			}			
		}
		return verdade;
	}
	public Livro[] listLivros(){
		Livro listLi[] = new Livro[this.livros.size()];
		return this.livros.keySet().toArray(listLi);
	}
	public int tamLivros(){
		return this.livros.size();
	}
	public int qtdDoLivro(Livro livro){
		if(this.livros.containsKey(livro)){
			return this.livros.get(livro);
		}
		return -1;
	}
	public void adicionarLivro(Livro novo, Integer qtd){
		if(this.livros.containsKey(novo)){
			this.livros.put(novo, new Integer(this.livros.get(qtd).intValue() + 1));
		}
		this.livros.put(novo, qtd);
	}
	public void alugar(Livro alugado,Date dataAluguel, int prazo){
		alugado.setDataAluguel(dataAluguel);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataAluguel);
		cal.add(Calendar.DAY_OF_MONTH, prazo);
		alugado.setDataDevolucao(cal.getTime());
		this.livros.put(alugado, new Integer(this.livros.get(alugado).intValue() - 1));
	}
	public void adicionarApostila(Apostila nova){
		apostilas.add(nova);
	}
	public void adicionarTexto(Texto novo){
		textos.add(novo);
	}
	public void addUsuario(Usuario novo){
		clientes.add(novo);
	}
	public void addAdmin(Administrador novo){
		admins.add(novo);
	}
}
